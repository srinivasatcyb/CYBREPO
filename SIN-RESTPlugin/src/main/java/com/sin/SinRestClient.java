package com.sin;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class SinRestClient {
	
	HttpClient httpClient;
	String targetUrl = "http://localhost:8090/hello-world";

	@NotNull
	HttpGet buildHttpGet() {
		HttpGet httpGet = new HttpGet(targetUrl);
		return httpGet;
	}

	@NotNull
	HttpPost buildHttpPost() {
		HttpPost httpPost = new HttpPost(targetUrl);
		return httpPost;
	}

	public void getResponseStatus() {
		httpClient = new DefaultHttpClient();
		HttpGet getRequest = buildHttpGet();
		HttpResponse response = null;
		try {
			response = httpClient.execute(getRequest);
			System.out.println("Response ---"+response.getStatusLine());
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
	}
	
	public static void main(String args[]) {
		new SinRestClient().getResponseStatus();
	}
}
