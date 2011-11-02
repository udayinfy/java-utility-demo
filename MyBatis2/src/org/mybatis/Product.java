package org.mybatis;

public class Product {

	private int pid;
	private int pcode;
	private String pname;
	private java.util.Date pdate;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public java.util.Date getPdate() {
		return pdate;
	}

	public void setPdate(java.util.Date pdate) {
		this.pdate = pdate;
	}

	public String toString() {
		return "pid:" + pid + "  pcode:" + pcode + "  pname:" + pname + "  pdate:"
				+ pdate;
	}

}
