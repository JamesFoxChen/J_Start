package threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.lang.WordUtils;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;

class DaemonThread implements Runnable {

	public void run() {
		try {
			wirteFile();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private void wirteFile() throws Exception {

		File file = new File("C:" + File.separator + "daemon.txt");
		OutputStream stream = new FileOutputStream(file);
		int count = 999;
		while (count > 0) {
			stream.write(("\r\nword:" + count).getBytes());
			System.out.println("守护线程:" + Thread.currentThread().getName() + "向文件中写入了word:" + count);
			count--;
			Thread.sleep(1000);
		}
	}

}

public class ThreadDaemon {

	public static void main(String[] args) {
		System.out.println("主线程:"+Thread.currentThread().getName()+" 开始");
		
		DaemonThread daemonThread=new DaemonThread();
		Thread t1=new Thread(daemonThread,"daemon1");
		t1.setDaemon(true); //设置为守护线程
		t1.start();
		
		//等待输入，输入完成后主线程退出；守护线程也会退出
	
		Scanner scanner=new Scanner(System.in);
		scanner.next();
		
		System.out.println("主线程:"+Thread.currentThread().getName()+" 结束");
	}
}
