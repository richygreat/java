package com.rg.servlet.sample;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rg.bean.sample.TestBeanLocal;
import com.rg.bean.sample.TestBeanRemote;
import com.rg.util.sample.LogUtil;
import com.rg.util.sample.TestUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TestServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TestBeanLocal testBean = InitialContext.doLookup("java:global/ear/servlet-1.0/TestBean!com.rg.bean.sample.TestBeanLocal");
			testBean.store("appname", "Artha");
			log.info("appname :: " + testBean.get("appname"));
			TestBeanRemote testRemote = InitialContext.doLookup("java:global/ear/servlet-1.0/TestBean!com.rg.bean.sample.TestBeanRemote");
			log.info("appname isEmpty :: " + TestUtil.isEmpty((String) testRemote.get("appname")));
			log.info("appname remote :: " + testRemote.get("appname"));
			LogUtil.checkLog();
		} catch (NamingException e) {
			log.error("Exception while creating local Bean", e);
		}
	}

}
