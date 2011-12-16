package demo.xstream.xstream3;

public class Address {
	
	private Province province;
	private City city;
	
	public Address(Province province, City city) {
		super();
		this.province = province;
		this.city = city;
	}

	public String toString(){
		return "Address{" + "province='" + province + '\'' + ", city='" + city
					+ '\'' + '}';
	}
	
}