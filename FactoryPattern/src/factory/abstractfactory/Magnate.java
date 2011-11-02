package factory.abstractfactory;

/*
 * ”√ªß
 */
public class Magnate {
	
	public static void main(String[] args) {
		
		Car car = new Benz();
		Boat boat = new Steamer();
		
		MyDriver myDriver = new MyDriver();
		
//		myDriver.getCarDriver(car).drive();
//		
//		myDriver.getBoatDriver(boat).drive();
		
	}

}
