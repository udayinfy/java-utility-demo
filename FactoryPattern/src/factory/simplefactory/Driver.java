package factory.simplefactory;

/*
 * �������ɫ
 */
public class Driver {

	public static Car driverCar(String carName) throws Exception{
		
		if( carName.equals("Benz") ){
			return new Benz();
		}else if( carName.equals("Bwm") ){
			return new Bmw();
		}else{
			throw new Exception("û�����ֳ�����");
		}
		
		// Car car = (Car)Class.forName("packagename." + carType).newInstance();
		// ������Լ��ٴ�����
		
	}
	
}
