package Utilities;

public class Common {

	public static void ShortWait() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public static void MediumWait() throws InterruptedException {
		Thread.sleep(8000);
	}
	
	public static void LongWait() throws InterruptedException {
		Thread.sleep(10000);
	}
	

//	public static int GetRandomNumber() {
//		return (int)(Math.random()*((20000-1000)+1))+327341;
//	}
}
