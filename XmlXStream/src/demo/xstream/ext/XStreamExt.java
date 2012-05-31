package demo.xstream.ext;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XStreamExt {

	/**
	 * 初始化XStream 可支持某一字段可以加入CDATA标签 如果需要某一字段使用原文
	 * 就需要在String类型的text的头加上"<![CDATA["和结尾处加上"]]>"标签， 以供XStream输出时进行识别
	 * 
	 * @param isAddCDATA
	 *            是否支持CDATA标签
	 * @return
	 */
	public static XStream initXStream(boolean isAddCDATA) {
		
		final String PREFIX_CDATA = "<![CDATA[";
		final String SUFFIX_CDATA = "]]>";
		
		XStream xstream = null;
		if (isAddCDATA) {
			xstream = new XStream(new XppDriver() {
				public HierarchicalStreamWriter createWriter(Writer out) {
					return new PrettyPrintWriter(out) {
						protected void writeText(QuickWriter writer, String text) {
							if (text.startsWith(PREFIX_CDATA) && text.endsWith(SUFFIX_CDATA)) {
								writer.write(text);
							} else {
								super.writeText(writer, text);
							}
						}
					};
				};
			});
		} else {
			xstream = new XStream();
		}
		return xstream;
	}
	
	/**
	 * 解决XStream处理下划线变成两个下划线
	 * @return
	 */
	public XStream creatXStream(){
		
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		
		return xStream;
		
	}
	
}
