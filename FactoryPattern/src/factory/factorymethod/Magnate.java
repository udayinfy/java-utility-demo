package factory.factorymethod;

/*
 * 用户
 */
public class Magnate {
	
	public static void main(String[] args) {
		
		Driver driver = new BenzDriver();
		
		Car car = driver.driverCar();
		
		car.drive();
		
	}

}

//1)抽象工厂角色： 这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。在java中它由抽象类或者接口来实现。
//
//2)具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。
//
//3)抽象产品角色：它是具体产品继承的父类或者是实现的接口。在java中一般有抽象类或者接口来实现。
//
//4)具体产品角色：具体工厂角色所创建的对象就是此角色的实例。在java中由具体的类来实现。