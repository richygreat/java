package test;

import com.ibm.btt.config.InitManager;

public class TestBTT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InitManager.reset("jar:///definitions/btt.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
