package threads;

class MyTheadRunnable implements Runnable {
	private int count = 5;

	@Override
	public void run() {
		System.out.println("当前线程:" + Thread.currentThread().getName() + "开始");

		while (count > 0) {
			count--;
			System.out.println("当前线程:" + Thread.currentThread().getName() + " 卖了一张，还剩票数:" + this.count);
			
		}
		System.out.println("当前线程:" + Thread.currentThread().getName() + "结束");
	}

}

//http://www.imooc.com/video/6097/0

/*当前线程:t2开始
当前线程:t1开始
当前线程:t3开始
当前线程:t3 卖了一张，还剩票数:2
当前线程:t3 卖了一张，还剩票数:1
当前线程:t1 卖了一张，还剩票数:3
当前线程:t2 卖了一张，还剩票数:4
当前线程:t2结束
当前线程:t1结束
当前线程:t3 卖了一张，还剩票数:0
当前线程:t3结束*/

public class ThreadExtendsFromRunnable {

	public static void main(String[] args) {
		MyTheadRunnable runnable = new MyTheadRunnable();

		Thread t1 = new Thread(runnable, "t1");
		Thread t2 = new Thread(runnable, "t2");
		Thread t3 = new Thread(runnable, "t3");

		//t1、t2、t3使用相同的runnable，所以共享count，不会导致卖出15张票
		//如果三个不同的runnble，一样会卖出15张票
		//线程的时间片是在代码行级别的，可能执行了count--后，cpu就被其他线程占用，所以剩余
		//数量不是按顺序减少
		t1.start();
		t2.start();
		t3.start();
	}

}
