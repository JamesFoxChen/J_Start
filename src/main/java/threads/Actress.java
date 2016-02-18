package threads;

public class Actress implements Runnable {


	@Override
	public void run() {
		String threadname=Thread.currentThread().getName();
		System.out.println(threadname + "是一个女演员！");
		int count = 0;
		boolean keepRunning = true;

		while (keepRunning) {
			System.out.println(threadname + "登台演出：" + (++count));

			if (count == 100) {
				keepRunning = false;
			}

			if (count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(threadname + "的演出结束了！");
	}

}
