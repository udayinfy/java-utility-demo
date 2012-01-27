package factory.abstractfactory;


public class CarDriver {
	
	public Car drive(String carName) throws Exception{
		
		if( carName.equals("Benz") ){
			return new Benz();
		}else if( carName.equals("Bwm") ){
			return new Bmw();
		}else{
			throw new Exception("没有这种车辆。");
		}
		
		
	}

}
