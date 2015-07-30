package com.rg.util.sample;

import org.apache.log4j.Logger;

public class LogUtil {
	private static final Logger log = Logger.getLogger(LogUtil.class);
	
	public static void checkLog() {
		log.info("INFO");
		log.debug("DEBUG");
		log.trace("TRACE");
	}
}
