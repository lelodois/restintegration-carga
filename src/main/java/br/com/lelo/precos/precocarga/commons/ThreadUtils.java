package br.com.lelo.precos.precocarga.commons;

public class ThreadUtils {

	public static void silientSleep() {
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
