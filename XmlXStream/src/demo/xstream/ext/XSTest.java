package demo.xstream.ext;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 回车换行相关
 *
 */
@XStreamAlias("XStreamTest")
public class XSTest {
    @XStreamAlias("content")
    public String s;
    @XStreamAsAttribute
    public String attrib;

    public static void main(String[] args) {
        XSTest x = new XSTest();
        x.s = "foo\r\nbar";
        x.attrib = "test\r\nlinebreaks";
        
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.setMode(XStream.NO_REFERENCES);
        System.out.println(xstream.toXML(x));
        System.out.println("---------------------------------");
        xstream.marshal(x, new com.thoughtworks.xstream.io.xml.CompactWriter(
                new java.io.OutputStreamWriter(System.out)));
    }
}
