package thread.java5;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试FutureTask的用法，如果不想分支线程阻塞主线程，又想取得分支线程的执行结果，就用FutureTask
 * 
 * @author Administrator
 * 
 */
public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountNum countNum = new CountNum(0);
		// FutureTask<Integer> 这里的表示返回的是Integer
		FutureTask<Integer> futureTask = new FutureTask<Integer>(countNum);
		Thread td = new Thread(futureTask);
		System.out.println("futureTask�?��执行计算:" + System.currentTimeMillis());
		td.start();
		System.out.println("main 主线程可以做些其他事�?" + System.currentTimeMillis());
		try {
			// futureTask的get方法会阻塞，直到可以取得结果为止
			Integer result = futureTask.get();
			System.out.println("计算的结果是:" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("取得分支线程执行的结果后，主线程可以继续处理其他事项");
	}

}

class CountNum implements Callable<Integer> {
	private Integer sum;

	public CountNum(Integer sum) {
		this.sum = sum;
	}

	public Integer call() throws Exception {
		for (int i = 0; i < 100; i++) {
			sum = sum + i;
		}
		// 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取得FutureTask的结果是等待直至完成�?
		Thread.sleep(5000);
		System.out.println("futureTask 执行完成" + System.currentTimeMillis());
		return sum;
	}

}