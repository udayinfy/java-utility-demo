package thread.java5;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 测试多核时代，充分的利用CPU来运算数据，并且处理返回的结�?学习API专用
 * 
 * @author Administrator
 * 
 */
public class FutureTaskAndExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<FutureTask<Integer>> list = new ArrayList<FutureTask<Integer>>();
		// 创建线程池，线程池的大小和List.size没有啥必然的关系，一般的原则�?=list.size,多出来浪费不�?
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 10; i < 20; i++) {
			// 创建对象
			FutureTask<Integer> ft = new FutureTask<Integer>(new GetSum(i));
			// 添加到list,方便后面取得结果
			list.add(ft);
			// �?��个提交给线程池，当然也可以一次�?的提交给线程池，exec.invokeAll(list);
			exec.submit(ft);
		}

		// �?��统计结果
		Integer total = 0;
		for (FutureTask<Integer> tempFt : list) {
			try {
				total = total + tempFt.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		// 处理完毕，一定要记住关闭线程池，这个不能在统计之前关闭，因为如果线程多的�?执行中的可能被打�?
		exec.shutdown();
		System.out.println("多线程计算后的�?结果�?" + total);

	}
}

/**
 * 这个类很�?��，就是统计下�?��的加法（�? 到total)
 * 
 * @author Administrator
 * 
 */
class GetSum implements Callable<Integer> {
	private Integer total;
	private Integer sum = 0;

	public GetSum(Integer total) {
		this.total = total;
	}

	public Integer call() throws Exception {
		for (int i = 1; i < total + 1; i++) {
			sum = sum + i;
		}
		System.out.println(Thread.currentThread().getName() + " sum:" + sum);
		return sum;
	}

}