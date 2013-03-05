package demo.numeric;

public class NumericRepresentation {

	public static void main(String[] args) {
		
			testPerformance();
			
	}

	public static void testByte() {
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
	}

	/**
	 * 移位计算vs符号运算  <br>
	 * 10次10亿次计算测试, 前两次计算有差异，后续计算JVM可能做了优化  <br>
	 * 移位运算  4474ms; 符号运算 5102ms; <br>
	 * 移位运算  4490ms; 符号运算 5130ms; <br>
	 * 移位运算  1257ms; 符号运算 1265ms; <br>
	 * 移位运算  1262ms; 符号运算 1253ms; <br>
	 * 移位运算  1262ms; 符号运算 1278ms; <br>
	 * 移位运算  1245ms; 符号运算 1300ms; <br>
	 * 移位运算  1237ms; 符号运算 1253ms; <br>
	 * 移位运算  1242ms; 符号运算 1267ms; <br>
	 * 移位运算  1249ms; 符号运算 1285ms; <br>
	 * 移位运算  1261ms; 符号运算 1252ms; <br>
	 */
	public static void testPerformance() {
		
		
		for(int i=0; i<10; i++){
			long val = 2;
			long alterX = 0;
			long myResult = 0;
			
			long time1 = System.currentTimeMillis();
			for (long j = 0; j<999999999L; j++) {
				alterX = val * 8;
				myResult = val * 2;
			}
			long time2 = System.currentTimeMillis();
			System.out.print("* " + (time2 - time1) + ";");
			
			time1 = System.currentTimeMillis();
			for (long j = 0; j<999999999L; j++) {
				alterX = val << 3;
				myResult = val << 1;
			}
			time2 = System.currentTimeMillis();
			System.out.print("< " + (time2 - time1) + ";");
			
			System.out.println();
		}
	}

}
