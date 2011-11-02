package factory.abstractfactory;

/*
 * 抽象工厂角色
 */
public interface Driver {
	
	public BoatDriver getBoatDriver(Boat boat);
	
	public CarDriver getCarDriver(Car car); 
	
}
