package factory.factorymethod;

/*
 * ���幤����ɫ
 */
public class BmwDriver implements Driver{
	
	public Car driverCar(){  
        return new Bmw();  
     }  

}
