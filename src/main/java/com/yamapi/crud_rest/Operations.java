package com.yamapi.crud_rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Operations {

	
	private static String APIUrl = "http://localhost:8080"; 

	
	static Boolean create(String atributos, String tabela) {
		String[] pares = atributos.split(",");
		try {
			String paramsString = "{";	

			for (String par:pares) {
				String[] dupla = par.split(":");
				paramsString += "\""+dupla[0].trim()+"\":\""+ dupla[1].trim()+"\",";
			}
			char[] paramsChars = paramsString.toCharArray();
			paramsChars[paramsChars.length-1] = '}';
			paramsString = String.valueOf(paramsChars);
//			System.out.println(paramsString);
			StringEntity params = new StringEntity(paramsString);

			HttpClient httpclient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(APIUrl + "/" + tabela);
			httppost.setHeader("Accept", "application/json");
			httppost.setHeader("Content-type", "application/json");

			httppost.setEntity(params);


		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	System.out.println(IOUtils.toString(instream, "UTF-8"));
		    }
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
			
			return false;
		}
		
		return true;
	}
	
	static Boolean read(String id, String tabela) {		 
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(APIUrl + "/" + tabela + "/" + id);
		
		try {
		
		//Execute and get the response.
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	System.out.println(IOUtils.toString(instream, "UTF-8"));
		    }
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;
		
	}
	
	static Boolean update(String id, String tabela, String atributos) {
		String[] pares = atributos.split(",");
//		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		try {
		String paramsString = "{";	
		
		for (String par:pares) {
			String[] dupla = par.split(":");
			paramsString += "\""+dupla[0].trim()+"\":\""+ dupla[1].trim()+"\",";
//			params.add(new BasicNameValuePair(dupla[0].trim(), dupla[1].trim()));
		}
		char[] paramsChars = paramsString.toCharArray();
		paramsChars[paramsChars.length-1] = '}';
		paramsString = String.valueOf(paramsChars);
		System.out.println(paramsString);
		StringEntity params = new StringEntity(paramsString); 
//				new StringEntity("\"name\":\"myname\",\"age\":\"20\"} "); 
		HttpClient httpclient = HttpClients.createDefault();
		HttpPut httpput = new HttpPut(APIUrl + "/" + tabela + "/" + id);
		httpput.setHeader("Accept", "application/json");
		httpput.setHeader("Content-type", "application/json");
		
		
			httpput.setEntity(params);
		

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httpput);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	System.out.println(IOUtils.toString(instream, "UTF-8"));
		    }
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}

		return true;
		
	}
	
	static Boolean delete(String id, String tabela) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpDelete httpdelete = new HttpDelete(APIUrl + "/" + tabela + "/" + id);
		
		try {
		//Execute and get the response.
		HttpResponse response = httpclient.execute(httpdelete);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	System.out.println(IOUtils.toString(instream, "UTF-8"));
		    }
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;
	}
	
	static Boolean list(String tabela) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(APIUrl + "/" + tabela);
		
		try {
		
		//Execute and get the response.
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    try (InputStream instream = entity.getContent()) {
		    	System.out.println(IOUtils.toString(instream, "UTF-8"));
		    }
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;

	}
	
	
	
}
