package factory.factorymethod;

/*
 * 具体工厂角色
 */
public class BmwDriver implements Driver{
	
	public Car driverCar(){  
        return new Bmw();  
     }  

}
