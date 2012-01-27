package factory.simplefactory;

/*
 * 工厂类角色
 */
public class Driver {

	public static Car driverCar(String carName) throws Exception{
		
		if( carName.equals("Benz") ){
			return new Benz();
		}else if( carName.equals("Bwm") ){
			return new Bmw();
		}else{
			throw new Exception("没有这种车辆。");
		}
		
		// Car car = (Car)Class.forName("packagename." + carType).newInstance();
		// 反射可以减少代码量
		
	}
	
}
