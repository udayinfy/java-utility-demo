package template;

public class MethodBenchmark extends Benchmark {

	/**
	 * ��������benchmark����
	 */
	public void benchmark() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println("i=" + i);
		}
	}
}