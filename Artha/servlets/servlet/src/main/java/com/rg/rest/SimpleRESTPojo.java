package com.rg.rest;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

@Path("/pojo")
public class SimpleRESTPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SimpleRESTPojo.class);

	@GET
	@Path("/test")
	public String pojo() {
		log.info("Test Success");
		return "pojo ok @ " + new Date().toString();
	}
}