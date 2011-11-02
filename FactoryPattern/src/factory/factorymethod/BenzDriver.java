package factory.factorymethod;

/*
 * 具体工厂角色
 */
public class BenzDriver implements Driver{
	
	 public Car driverCar(){  
         return new Benz();  
  }  

}
