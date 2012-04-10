package spatial.hibernate.domain;

import java.io.Serializable;

import com.vividsolutions.jts.geom.Geometry;

public class ColaMarkets implements Serializable{
	
	private static final long serialVersionUID = 2516012903956498477L;
	
	private int mktId;
	private String name;
	private Geometry shape;
	
	public int getMktId() {
		return mktId;
	}
	public void setMktId(int mktId) {
		this.mktId = mktId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Geometry getShape() {
		return shape;
	}
	public void setShape(Geometry shape) {
		this.shape = shape;
	}
	
	
	
	

}
