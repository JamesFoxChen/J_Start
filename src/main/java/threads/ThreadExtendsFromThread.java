package threads;

class MyThread extends Thread {
	private int count = 5;
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("当前线程:" + this.name + " 开始");
		
		while (count >= 0) {
			System.out.println("当前线程:" + this.name + " 票数:" + this.count);
			count--;
		}
		System.out.println("当前线程:" + this.name + " 结束");
	}
}

public class ThreadExtendsFromThread {

	public static void main(String[] args) {
		MyThread m1=new MyThread("m1");
		MyThread m2=new MyThread("m2");
		MyThread m3=new MyThread("m3");
		
		//启动了三个不同的线程，各个线程count属性相互独立
		//共卖出了15张票，其实只有5张票
		m1.start();
		m2.start();
		m3.start();
	}

}
