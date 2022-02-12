package Helpers;

import java.util.UUID;

public class Utils {
	public static String GetUDID() {
		return UUID.randomUUID().toString();
	}
	
	public static void Sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
