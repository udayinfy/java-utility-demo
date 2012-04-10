package spatial.hibernate.domain;

import java.io.Serializable;

import com.vividsolutions.jts.geom.Geometry;

public class MapArea implements Serializable {
	
	private static final long serialVersionUID = 7842229885091723814L;
	
	private int areaId;
	private String areaCode;
	private String areaName;
	private String gid;
	private Geometry shape;
	
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Geometry getShape() {
		return shape;
	}
	public void setShape(Geometry shape) {
		this.shape = shape;
	}
	

}
