package util;

import java.rmi.RemoteException;

import com.blog.webservices.client.TempConvertStub;
import com.blog.webservices.client.TempConvertStub.FahrenheitToCelsius;
import com.blog.webservices.client.TempConvertStub.FahrenheitToCelsiusResponse;

public class TestStub {

	public static void main(String[] args) throws RemoteException {
		TempConvertStub stub = new TempConvertStub();
		stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
		FahrenheitToCelsius req = new FahrenheitToCelsius();
		req.setFahrenheit("100");
		FahrenheitToCelsiusResponse resp = stub.fahrenheitToCelsius(req);
		System.out.println(resp.getFahrenheitToCelsiusResult());
	}

}
