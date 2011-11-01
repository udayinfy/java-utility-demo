package demo.dom4j.xml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ReadXml {
	
	public static void main(String[] args) {
		String msg = 
			"<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
			"<acars v=\"2.0\">" +
			"  <!-- id: 标志xml为系统安全验证格式-->" +
			"  <body id=\"SAFE\">" +
			"		<skylink type=\"DOWNLINKSPLIT\" splitState=\"0\">" +
			"			<head>" +
			"				<datagramId>20080222011211DFDB-2641D70A</datagramId>" +
			"				<gatewayTime>2008-02-22 01:17:11</gatewayTime>" +
			"				<an>B-2641</an>" +
			"				<fi>CA101</fi>" +
			"				<rcvAddress>BJSAGCA ILNGE7X</rcvAddress>" +
			"				<sndAddress>BJSXCXA</sndAddress>" +
			"				<smi>DFD</smi>" +
			"				<dsp>BJS</dsp>" +
			"				<rgs>LYG</rgs>" +
			"				<rgsTime>2008-02-22 01:17:11</rgsTime>" +
			"				<msn>D70A</msn>" +
			"				<datagramType>WOB</datagramType>" +
			"				<templateName>HW_M14POSAAA</templateName>" +
			"				<templateId>1001</templateId>" +
			"			</head>" +
			"			<data>" +
			"				<unit>" +
			"					<unitName>PF</unitName>" +
			"					<uniformName></uniformName>" +
			"					<format>NNN</format>" +
			"					<length>3</length>" +
			"					<value>LVR</value>" +
			"				</unit>" +
			"			</data>" +
			"			<msg>" +
			"				2008-02-22 01:12:11" +
			"				 QU BJSAGCA ILNGE7X" +
			"				.BJSXCXA 220117" +
			"				 DFD" +
			"				FI CA101/AN B-2641" +
			"				DT BJS LYG 220117 D70A" +
			"				-  B-2641------02224004" +
			"				0117-130-3883210474205N3433E11444259103" +
			"			</msg>" +
			"		</skylink>" +
			"  </body>" +
			"</acars>" ;
		Document document = null;
		
		try {
			document = DocumentHelper.parseText(msg);
			List list = document.selectNodes("//rgs");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				String text = element.getText();
				System.out.println(text);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}

}
