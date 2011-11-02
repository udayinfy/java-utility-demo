package factory.simplefactory;

/*
 * 用户
 */
public class Magnate {
	
	public static void main(String[] args) {
		
		try {
			Car car = Driver.driverCar("Benz");
			car.drive();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


//1) 工厂类角色：这是本模式的核心，含有一定的商业逻辑和判断逻辑。在java中它往往由一个具体类实现。 
//
//2) 抽象产品角色：它一般是具体产品继承的父类或者实现的接口。在java中由接口或者抽象类来实现。 
//
//3) 具体产品角色：工厂类所创建的对象就是此角色的实例。在java中由一个具体类实现。 