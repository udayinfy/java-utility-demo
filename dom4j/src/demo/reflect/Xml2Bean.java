package demo.reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import demo.util.FileUtil;

/**
 * Xml转换为Bean
 * @author haichao.zhang
 */
public class Xml2Bean {

    public static void main(String[] args){

        String fileUrl = FileUtil.class.getResource("/").getFile()
                + File.separator + "poi.xml";
        String encode = "GBK";
        String xmlStr = FileUtil.readToBuffer(fileUrl, encode);

        List<Row> rowList = Xml2Bean.getBeanFromXml(xmlStr);
        

    }

    public static List<Row> getBeanFromXml(String xmlStr){
        List retValue = new ArrayList();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException ex) {
            Logger.getLogger(Xml2Bean.class.getName()).log(Level.SEVERE, null, ex);
        }

        Element rootElement = doc.getRootElement();
        List<Element> rowElements = rootElement.elements("ROW");

        for (Iterator<Element> it = rowElements.iterator(); it.hasNext();) {
            Element rowElement = it.next();
             Row row = new Row();
            for(Iterator<Element> it2 = rowElement.elementIterator(); it2.hasNext();){
                Element subElement = it2.next();
                String subElementName = subElement.getQualifiedName().toLowerCase();
                String subElementValue = subElement.getText();

                try {
                    String methodName = "set" + Character.toUpperCase(subElementName.charAt(0)) + subElementName.substring(1);
                    Method method = row.getClass().getDeclaredMethod(methodName, String.class);
                    method.invoke(row, subElementValue);
                } catch (Exception ex) {
                    Logger.getLogger(Xml2Bean.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
          retValue.add(row);
        }
        
        return retValue;
    }

}
