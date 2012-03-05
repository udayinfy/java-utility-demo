package webservice.axis.wsdd;

public class HelloWorldWSDD {
	
	private int requestCount = 0;

	public String hello(String name) {
		requestCount++;
		System.out.println("requestCount=" + requestCount);
		System.out.println("Received: " + name);
		return "Hello " + name;
	}

	public Float add(float a, float b) {
		requestCount++;
		String result = "a=" + a + ", b=" + b;
		System.out.println("requestCount=" + requestCount);
		System.out.println("Received: " + result);
		return a + b;
	}
}