package factory.factorymethod;

/*
 * ���幤����ɫ
 */
public class BenzDriver implements Driver{
	
	 public Car driverCar(){  
         return new Benz();  
  }  

}
