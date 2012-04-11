package template.inherit;

public class Test {

	public static void main(String[] args) {
		Benchmark operation = new MethodBenchmark();
		long duration = operation.repeat(100);
		System.out.println("The operation took " + duration + " milliseconds");
	}

}
