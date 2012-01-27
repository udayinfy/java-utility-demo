package factory.abstractfactory;

/*
 * ���󹤳���ɫ
 */
public interface Driver {
	
	public BoatDriver getBoatDriver(Boat boat);
	
	public CarDriver getCarDriver(Car car); 
	
}
