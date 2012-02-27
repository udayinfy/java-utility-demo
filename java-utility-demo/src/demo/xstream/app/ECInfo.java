package demo.xstream.app;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/**
 * XO映射ECInfo节点
 * @author zhc
 *
 */
public class ECInfo {
	
	@Test
	public void testOutput(){
		// ...
	}
	
	@Test
	public void testInput(){
		// ...
	}
	

	private String OprCode;
	private String ECID;
	private String ProvECID;
	private String ECName;
	private String ECEName;
	private String OprTime;
	private String EffTime;
	private String ECTel;
	private String IntroURL;
	private String ContractTel;
	private String ContractName;
	private String Note;

	/**
	 * 配置映射
	 * @param xStream
	 */
	private static void configAlias(XStream xStream) {
		xStream.aliasType("ECInfo", ECInfo.class);
	}

	/**
	 * 编组
	 * @param obj
	 * @return
	 */
	public static String marshall(ECInfo obj) {
		XStream xStream = new XStream();
		String xml = null;
		try {
			configAlias(xStream);
			xml = xStream.toXML(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return xml;
	}

	/**
	 * 解组
	 * @param xml
	 * @return
	 */
	public static ECInfo unmarshall(String xml) {
		XStream xStream = new XStream();
		ECInfo obj = null;
		try {
			configAlias(xStream);
			obj = (ECInfo) xStream.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return obj;
	}

	public String getOprCode() {
		return OprCode;
	}

	public void setOprCode(String oprCode) {
		OprCode = oprCode;
	}

	public String getECID() {
		return ECID;
	}

	public void setECID(String eCID) {
		ECID = eCID;
	}

	public String getProvECID() {
		return ProvECID;
	}

	public void setProvECID(String provECID) {
		ProvECID = provECID;
	}

	public String getECName() {
		return ECName;
	}

	public void setECName(String eCName) {
		ECName = eCName;
	}

	public String getECEName() {
		return ECEName;
	}

	public void setECEName(String eCEName) {
		ECEName = eCEName;
	}

	public String getOprTime() {
		return OprTime;
	}

	public void setOprTime(String oprTime) {
		OprTime = oprTime;
	}

	public String getEffTime() {
		return EffTime;
	}

	public void setEffTime(String effTime) {
		EffTime = effTime;
	}

	public String getECTel() {
		return ECTel;
	}

	public void setECTel(String eCTel) {
		ECTel = eCTel;
	}

	public String getIntroURL() {
		return IntroURL;
	}

	public void setIntroURL(String introURL) {
		IntroURL = introURL;
	}

	public String getContractTel() {
		return ContractTel;
	}

	public void setContractTel(String contractTel) {
		ContractTel = contractTel;
	}

	public String getContractName() {
		return ContractName;
	}

	public void setContractName(String contractName) {
		ContractName = contractName;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

}
