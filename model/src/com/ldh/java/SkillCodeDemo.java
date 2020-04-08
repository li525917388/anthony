package com.ldh.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.plaf.SliderUI;


/**
 * 常用代码demo
 * @author Li Dehuan
 * @date 2020年2月29日
 *
 */
public class SkillCodeDemo {

	
	public static void main(String[] args) {
		
		try {
			
			/*
			 * 线程任务 demo
			 */
			//FutureTaskDemo();
			
			
			/*
			 * 获取格式化时间字符串 demo
			 */
			// fetchDateStringDemo();
			
			
			/**
			 * 多线程监听任务，判断线程是否全部结束
			 */
			CountDownLatchDemo();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static void CountDownLatchDemo() throws InterruptedException {
		int length = 3;
		CountDownLatch downLatch = new CountDownLatch(length);
		ExecutorService executorService = Executors.newFixedThreadPool(length);
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("A开始倒计时");
				for(int i = 0; i < 10; i++){
					System.out.println("A:" + (10 - i));
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				downLatch.countDown();
			}
		});
		
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("B开始倒计时");
				for(int i = 0; i < 10; i++){
					System.out.println("B:" + (10 - i));
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				downLatch.countDown();
			}
		});
		

		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("C开始倒计时");
				for(int i = 0; i < 10; i++){
					System.out.println("C:" + (10 - i));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				downLatch.countDown();
			}
		});
		
		downLatch.await();
		
		System.out.println("全部执行完了");
	}


	/**
	 * 线程任务 demo
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 * @throws ExecutionException 
	 */
	public static void FutureTaskDemo() throws InterruptedException, ExecutionException, TimeoutException{
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		/**
		 * 第一任务
		 */
		/*FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("烧开水...");
				Thread.sleep(3000);
				System.out.println("水开了");
				return "ok";
			}
			
		});*/
		
		/**
		 * 第一任务（java8）
		 */
		FutureTask<String> futureTask1 = new FutureTask<>(() -> {
			System.out.println("烧开水...");
			Thread.sleep(3000);
			System.out.println("水开了");
			return "ok";
		});
		
		
		/**
		 * 第二个任务
		 */
		/*FutureTask<String> futureTask2 = new FutureTask<>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("煮饭...");
				Thread.sleep(5000);
				System.out.println("饭煮好了");
				return "ok";
			}
			
		});*/
		
		/**
		 * 第二任务（java8）
		 */
		FutureTask<String> futureTask2 = new FutureTask<>(() -> {
			System.out.println("煮饭...");
			Thread.sleep(5000);
			System.out.println("饭煮好了");
			return "ok";
		});
		
		executorService.submit(futureTask1);
		executorService.submit(futureTask2);
		
		System.out.println("炒菜...");
		
		Thread.sleep(2000);
		
		System.out.println("菜炒好了");
		
		if(futureTask1.get(3000, TimeUnit.MILLISECONDS) == "ok" && futureTask2.get(3000, TimeUnit.MILLISECONDS) == "ok"){
			System.out.println("开饭了");
			
		}
		
		
	}
	
	
	
	
	/**
	 * 获取格式化时间字符串demo
	 */
	public static void fetchDateStringDemo(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(formatter));
	}
}
