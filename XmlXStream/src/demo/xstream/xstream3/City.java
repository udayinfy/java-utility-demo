package demo.xstream.xstream3;

public class City {
	
	private String name;
	private String size;
	
	public City(String name, String size) {
		super();
		this.name = name;
		this.size = size;
	}

	public String toString(){
		return "Province{" + "name='" + name + '\'' + ", size='" + size
					+ '\'' + '}';
	}

}
