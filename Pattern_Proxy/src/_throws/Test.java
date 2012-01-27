package _throws;

public class Test {
	
	public static void testThrows(){
		Hello hello = new Hello();
		
		try {
			hello.sayHello("tom");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static void main(String args){
		testThrows();
	}

}
