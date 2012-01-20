package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.InputStream;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import java.lang.reflect.*;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

public final class happyaxis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    /*
     * Happiness tests for axis. These look at the classpath and warn if things
     * are missing. Normally addng this much code in a JSP page is mad
     * but here we want to validate JSP compilation too, and have a drop-in
     * page for easy re-use
     * @author Steve 'configuration problems' Loughran
     * @author dims
     * @author Brian Ewins
     */

    /**
     * test for a class existing
     * @param classname
     * @return class iff present
     */
    Class classExists(String classname) {
        try {
            return Class.forName(classname);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * test for resource on the classpath
     * @param resource
     * @return true iff present
     */
    boolean resourceExists(String resource) {
        boolean found;
        InputStream instream=this.getClass().getResourceAsStream(resource);
        found=instream!=null;
        if(instream!=null) {
            try {
                instream.close();
            } catch (IOException e) {
            }
        }
        return found;
    }

    /**
     * probe for a class, print an error message is missing
     * @param out stream to print stuff
     * @param category text like "warning" or "error"
     * @param classname class to look for
     * @param jarFile where this class comes from
     * @param errorText extra error text
     * @param homePage where to d/l the library
     * @return the number of missing classes
     * @throws IOException
     */
    int probeClass(JspWriter out,
                   String category,
                   String classname,
                   String jarFile,
                   String description,
                   String errorText,
                   String homePage) throws IOException {
        try {
            Class clazz = classExists(classname);
            if(clazz == null)  {
               String url="";
               if(homePage!=null) {
                  url=getMessage("seeHomepage",homePage,homePage);
               }
               out.write(getMessage("couldNotFound",category,classname,jarFile,errorText,url));
               return 1;
            } else {
               String location = getLocation(out, clazz);

               if(location == null) {
                  out.write("<li>"+getMessage("foundClass00",description,classname)+"</li><br>");
               }
               else {
                  out.write("<li>"+getMessage("foundClass01",description,classname,location)+"</li><br>");
               }
               return 0;
            }
        } catch(NoClassDefFoundError ncdfe) {
            String url="";
            if(homePage!=null) {
                url=getMessage("seeHomepage",homePage,homePage);
            }
            out.write(getMessage("couldNotFoundDep",category, classname, errorText, url));
            out.write(getMessage("theRootCause",ncdfe.getMessage(), classname));
            return 1;
        }
    }

    /**
     * get the location of a class
     * @param out
     * @param clazz
     * @return the jar file or path where a class was found
     */

    String getLocation(JspWriter out,
                       Class clazz) {
        try {
            java.net.URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
            String location = url.toString();
            if(location.startsWith("jar")) {
                url = ((java.net.JarURLConnection)url.openConnection()).getJarFileURL();
                location = url.toString();
            }

            if(location.startsWith("file")) {
                java.io.File file = new java.io.File(url.getFile());
                return file.getAbsolutePath();
            } else {
                return url.toString();
            }
        } catch (Throwable t){
        }
        return getMessage("classFoundError");
    }

    /**
     * a class we need if a class is missing
     * @param out stream to print stuff
     * @param classname class to look for
     * @param jarFile where this class comes from
     * @param errorText extra error text
     * @param homePage where to d/l the library
     * @throws IOException when needed
     * @return the number of missing libraries (0 or 1)
     */
    int needClass(JspWriter out,
                   String classname,
                   String jarFile,
                   String description,
                   String errorText,
                   String homePage) throws IOException {
        return probeClass(out,
                "<b>"+getMessage("error")+"</b>",
                classname,
                jarFile,
                description,
                errorText,
                homePage);
    }

    /**
     * print warning message if a class is missing
     * @param out stream to print stuff
     * @param classname class to look for
     * @param jarFile where this class comes from
     * @param errorText extra error text
     * @param homePage where to d/l the library
     * @throws IOException when needed
     * @return the number of missing libraries (0 or 1)
     */
    int wantClass(JspWriter out,
                   String classname,
                   String jarFile,
                   String description,
                   String errorText,
                   String homePage) throws IOException {
        return probeClass(out,
                "<b>"+getMessage("warning")+"</b>",
                classname,
                jarFile,
                description,
                errorText,
                homePage);
    }

    /**
     *  get servlet version string
     *
     */

    public String getServletVersion() {
        ServletContext context=getServletConfig().getServletContext();
        int major = context.getMajorVersion();
        int minor = context.getMinorVersion();
        return Integer.toString(major) + '.' + Integer.toString(minor);
    }

    /**
     * what parser are we using.
     * @return the classname of the parser
     */
    private String getParserName() {
        SAXParser saxParser = getSAXParser();
        if (saxParser == null) {
            return getMessage("couldNotCreateParser");
        }

        // check to what is in the classname
        String saxParserName = saxParser.getClass().getName();
        return saxParserName;
    }

    /**
     * Create a JAXP SAXParser
     * @return parser or null for trouble
     */
    private SAXParser getSAXParser() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        if (saxParserFactory == null) {
            return null;
        }
        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (Exception e) {
        }
        return saxParser;
    }

    /**
     * get the location of the parser
     * @return path or null for trouble in tracking it down
     */

    private String getParserLocation(JspWriter out) {
        SAXParser saxParser = getSAXParser();
        if (saxParser == null) {
            return null;
        }
        String location = getLocation(out,saxParser.getClass());
        return location;
    }

    /**
     * Check if class implements specified interface.
     * @param Class clazz
     * @param String interface name
     * @return boolean
     */
    private boolean implementsInterface(Class clazz, String interfaceName) {
        if (clazz == null) {
            return false;
        }
        Class[] interfaces = clazz.getInterfaces();
        if (interfaces.length != 0) {
            for (int i = 0; i < interfaces.length; i++) {
                if (interfaces[i].getName().equals(interfaceName)) {
                    return true;
                }
            }
        }
        return false;
    }
    

    /*
     * A library file to produce i18n web applications. This can be easily
     * reused from your jsp(s) - just include and call any methods.
     * @author toshi
     */

    // private variable
    HttpServletRequest _req = null;

    // private variable
    String _strResourceName = null;

    /**
     * Set a HttpServletRequest to a private variable.
     * @param request HttpServletRequest
     */
    void setRequest(HttpServletRequest request) {
        _req = request;
    }

    /**
     * Get the private variable of the HttpServletRequest.
     * @return HttpServletRequest
     */
    HttpServletRequest getRequest() {
        return _req;
    }

    /**
     * Set a resouce base name to a private variable.
     * @param resouce The resouce base name
     */
    void setResouceBase(String resource) {
        _strResourceName = resource;
    }

    /**
     * Get the private variable of the resouce base name.
     * @return resouce The resouce base name
     */
    String getResouceBase() {
        return _strResourceName;
    }

    /**
     * Get a ResourceBundle object.
     * @return a ResourceBundle object
     */
    ResourceBundle getRB() {
        String strLocale = getRequest().getParameter("locale");
        ResourceBundle objRb = null;
        Locale objLcl = null;

        if (strLocale!=null) {
            objLcl=new Locale(strLocale,"");
        } else {
            objLcl=getRequest().getLocale();
        }

        Locale.setDefault(objLcl);
        objRb = ResourceBundle.getBundle(getResouceBase(),objLcl);

        return objRb;
    }

    /**
     * Get a list of locale choice
     * @return a list of supported locales
     */
    String getLocaleChoice() {
        String choice = getMessage("locales");
        StringBuffer buf = new StringBuffer();
        
        buf.append("<div align=\"right\">\n");
        buf.append(getMessage("language"));
        buf.append(": ");

        StringTokenizer st = new StringTokenizer(choice);
        String locale = null;
        while (st.hasMoreTokens()) {
            locale = st.nextToken();
            buf.append("[<a href=\"?locale="+ locale +"\">"+ locale +"</a>] ");
        }
        buf.append("\n</div>\n");

        return buf.toString();
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @return The formatted message
     */
    String getMessage(String key) {
        return getMessage(key, null, null, null, null, null);
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @param arg0 The argument to place in variable {0}
     * @return The formatted message
     */
    String getMessage(String key, String arg0) {
        return getMessage(key, arg0, null, null, null, null);
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @param arg0 The argument to place in variable {0}
     * @param arg1 The argument to place in variable {1}
     * @return The formatted message
     */
    String getMessage(String key, String arg0, String arg1) {
        return getMessage(key, arg0, arg1, null, null, null);
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @param arg0 The argument to place in variable {0}
     * @param arg1 The argument to place in variable {1}
     * @param arg2 The argument to place in variable {2}
     * @return The formatted message
     */
    String getMessage(String key, String arg0, String arg1, String arg2) {
        return getMessage(key, arg0, arg1, arg2, null, null);
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @param arg0 The argument to place in variable {0}
     * @param arg1 The argument to place in variable {1}
     * @param arg2 The argument to place in variable {2}
     * @param arg3 The argument to place in variable {3}
     * @return The formatted message
     */
    String getMessage(String key, String arg0, String arg1,
                      String arg2, String arg3) {
        return getMessage(key, arg0, arg1, arg2, arg3, null);
    }

    /**
     * Get a message from i18n.properties with several arguments.
     * @param key The resource key
     * @param arg0 The argument to place in variable {0}
     * @param arg1 The argument to place in variable {1}
     * @param arg2 The argument to place in variable {2}
     * @param arg3 The argument to place in variable {3}
     * @param arg4 The argument to place in variable {4}
     * @return The formatted message
     */
    String getMessage(String key, String arg0, String arg1,
                      String arg2, String arg3, String arg4) {
        String strPattern = getRB().getString(key);

        String [] params = { arg0, arg1, arg2, arg3, arg4 };
        for (int i=0; i<5; i++) {
            if (params[i]!=null) params[i]=replaceAll(params[i],"%20"," ");
        }

        if (arg0!=null) strPattern = replaceAll(strPattern,"{0}",params[0]);
        if (arg1!=null) strPattern = replaceAll(strPattern,"{1}",params[1]);
        if (arg2!=null) strPattern = replaceAll(strPattern,"{2}",params[2]);
        if (arg3!=null) strPattern = replaceAll(strPattern,"{3}",params[3]);
        if (arg4!=null) strPattern = replaceAll(strPattern,"{4}",params[4]);

        return strPattern;
    }

    /**
     * Get a replaced string by the specified message.
     * @param source  The original message
     * @param pattern The key message for replacing
     * @param replace The message to place in the key variable - 'pattern'
     * @return The replaced message
     */
    String replaceAll(String source, String pattern, String replace)
    {
        int i=0;
        boolean ret = false;
        StringBuffer buf = new StringBuffer();

        int lenSource  = source.length();
        int lenPattern = pattern.length();

        for (i=0; i<lenSource; i++) {
            ret = source.regionMatches(i, pattern, 0, lenPattern);
            if (ret) {
                buf.append(source.substring(0,i));
                buf.append(replace);
                buf.append(source.substring(i+lenPattern));
                source = replaceAll(buf.toString(), pattern, replace);
                break;
            }
        }
        return source;
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/i18nLib.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("\n");

/*
 * Copyright 2002,2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

/*
 * Copyright 2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

    // initialize a private HttpServletRequest
    setRequest(request);

    // set a resouce base
    setResouceBase("i18n");

      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<title>");
      out.print( getMessage("pageTitle") );
      out.write("</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor='#ffffff'>\n");
      out.write("\n");

    out.print("<h1>"+ getMessage("pageTitle") +"</h1>");
    out.print("<h2>"+ getMessage("pageRole") +"</h2><p/>");

      out.write('\n');
      out.write('\n');
      out.print( getLocaleChoice() );
      out.write('\n');
      out.write('\n');

    out.print("<h3>"+ getMessage("neededComponents") +"</h3>");

      out.write("\n");
      out.write("\n");
      out.write("<UL>\n");

    int needed=0,wanted=0;

    /**
     * the essentials, without these Axis is not going to work
     */

    // need to check if the available version of SAAJ API meets requirements
    String className = "javax.xml.soap.SOAPPart";
    String interfaceName = "org.w3c.dom.Document";
    Class clazz = classExists(className);
    if (clazz == null || implementsInterface(clazz, interfaceName)) {
        needed = needClass(out, "javax.xml.soap.SOAPMessage",
        	"saaj.jar",
                "SAAJ API",
                getMessage("criticalErrorMessage"),
                "http://ws.apache.org/axis/");
    } else {
        String location = getLocation(out, clazz);

        out.print(getMessage("invalidSAAJ",location));
        out.print(getMessage("criticalErrorMessage"));
        out.print(getMessage("seeHomepage","http://ws.apache.org/axis/java/install.html",getMessage("axisInstallation")));
        out.print("<br>");
    }

    needed+=needClass(out, "javax.xml.rpc.Service",
            "jaxrpc.jar",
            "JAX-RPC API",
            getMessage("criticalErrorMessage"),
            "http://ws.apache.org/axis/");

    needed+=needClass(out, "org.apache.axis.transport.http.AxisServlet",
            "axis.jar",
            "Apache-Axis",
            getMessage("criticalErrorMessage"),
            "http://ws.apache.org/axis/");

    needed+=needClass(out, "org.apache.commons.discovery.Resource",
            "commons-discovery.jar",
            "Jakarta-Commons Discovery",
            getMessage("criticalErrorMessage"),
            "http://jakarta.apache.org/commons/discovery/");

    needed+=needClass(out, "org.apache.commons.logging.Log",
            "commons-logging.jar",
            "Jakarta-Commons Logging",
            getMessage("criticalErrorMessage"),
            "http://jakarta.apache.org/commons/logging/");

    needed+=needClass(out, "org.apache.log4j.Layout",
            "log4j-1.2.8.jar",
            "Log4j",
            getMessage("uncertainErrorMessage"),
            "http://jakarta.apache.org/log4j");

    //should we search for a javax.wsdl file here, to hint that it needs
    //to go into an approved directory? because we dont seem to need to do that.
    needed+=needClass(out, "com.ibm.wsdl.factory.WSDLFactoryImpl",
            "wsdl4j.jar",
            "IBM's WSDL4Java",
            getMessage("criticalErrorMessage"),
            null);

    needed+=needClass(out, "javax.xml.parsers.SAXParserFactory",
            "xerces.jar",
            "JAXP implementation",
            getMessage("criticalErrorMessage"),
            "http://xml.apache.org/xerces-j/");

    needed+=needClass(out,"javax.activation.DataHandler",
            "activation.jar",
            "Activation API",
            getMessage("criticalErrorMessage"),
            "http://java.sun.com/products/javabeans/glasgow/jaf.html");

      out.write("\n");
      out.write("</UL>\n");

    out.print("<h3>"+ getMessage("optionalComponents") +"</h3>");

      out.write("\n");
      out.write("<UL>\n");

    /*
     * now the stuff we can live without
     */
    wanted+=wantClass(out,"javax.mail.internet.MimeMessage",
            "mail.jar",
            "Mail API",
            getMessage("attachmentsError"),
            "http://java.sun.com/products/javamail/");

    wanted+=wantClass(out,"org.apache.xml.security.Init",
            "xmlsec.jar",
            "XML Security API",
            getMessage("xmlSecurityError"),
            "http://xml.apache.org/security/");

    wanted += wantClass(out, "javax.net.ssl.SSLSocketFactory",
            "jsse.jar or java1.4+ runtime",
            "Java Secure Socket Extension",
            getMessage("httpsError"),
            "http://java.sun.com/products/jsse/");
    /*
     * resources on the classpath path
     */
    /* add more libraries here */


      out.write("\n");
      out.write("</UL>\n");

    out.write("<h3>");
    //is everythng we need here
    if(needed==0) {
       //yes, be happy
        out.write(getMessage("happyResult00"));
    } else {
        //no, be very unhappy
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        out.write(getMessage("unhappyResult00",Integer.toString(needed)));
    }
    //now look at wanted stuff
    if(wanted>0) {
        out.write(getMessage("unhappyResult01",Integer.toString(wanted)));
    } else {
        out.write(getMessage("happyResult01"));
    }
    out.write("</h3>");

      out.write("\n");
      out.write("<UL>\n");


    //hint if anything is missing
    if(needed>0 || wanted>0 ) {
        out.write(getMessage("hintString"));
    }

    out.write(getMessage("noteString"));

      out.write("\n");
      out.write("</UL>\n");
      out.write("\n");
      out.write("    <h2>");
      out.print( getMessage("apsExamining") );
      out.write("</h2>\n");
      out.write("\n");
      out.write("<UL>\n");
      out.write("    ");

        String servletVersion=getServletVersion();
        String xmlParser=getParserName();
        String xmlParserLocation = getParserLocation(out);
    
      out.write("\n");
      out.write("    <table border=\"1\" cellpadding=\"10\">\n");
      out.write("        <tr><td>Servlet version</td><td>");
      out.print( servletVersion );
      out.write("</td></tr>\n");
      out.write("        <tr><td>XML Parser</td><td>");
      out.print( xmlParser );
      out.write("</td></tr>\n");
      out.write("        <tr><td>XML ParserLocation</td><td>");
      out.print( xmlParserLocation );
      out.write("</td></tr>\n");
      out.write("    </table>\n");
      out.write("</UL>\n");
      out.write("\n");
 if(xmlParser.indexOf("crimson")>=0) { 
      out.write("\n");
      out.write("    <p>\n");
      out.write("    ");
      out.print( getMessage("recommendedParser") );
      out.write("\n");
      out.write("    </p>\n");
    } 
      out.write("\n");
      out.write("\n");
      out.write("    <h2>");
      out.print( getMessage("sysExamining") );
      out.write("</h2>\n");
      out.write("<UL>\n");

    /**
     * Dump the system properties
     */
    java.util.Enumeration e=null;
    try {
        e= System.getProperties().propertyNames();
    } catch (SecurityException se) {
    }
    if(e!=null) {
        out.write("<pre>");
        for (;e.hasMoreElements();) {
            String key = (String) e.nextElement();
            out.write(key + "=" + System.getProperty(key)+"\n");
        }
        out.write("</pre><p>");
    } else {
        out.write(getMessage("sysPropError"));
    }

      out.write("\n");
      out.write("</UL>\n");
      out.write("    <hr>\n");
      out.write("    ");
      out.print( getMessage("apsPlatform") );
      out.write(":\n");
      out.write("    ");
      out.print( getServletConfig().getServletContext().getServerInfo() );
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
