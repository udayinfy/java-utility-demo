package template.inherit;

public class MethodBenchmark extends Benchmark {

	/**
	 * 真正定义benchmark内容
	 */
	public void benchmark() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println("i=" + i);
		}
	}
}