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
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Operations {

	
	private static String APIUrl = "http://localhost:8080"; 

	
	static void create(String atributos, String tabela) {
		String[] pares = atributos.split(",");
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		
		try {
		for (String par:pares) {
			String[] dupla = par.split(":");
			params.add(new BasicNameValuePair(dupla[0].trim(), dupla[1].trim()));
		}		
		} catch(ArrayIndexOutOfBoundsException e) {

			System.out.println("Formato de entrada não esperado, repita a operação no menu por favor");
			
			return;
		}
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(APIUrl + "/" + tabela);
		httppost.setHeader("Accept", "application/json");
		httppost.setHeader("Content-type", "application/json");
		
		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		

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
		}
	}
	
	static void read(String id, String tabela) {		 
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
	}
	
	static void update(String id, String tabela, String atributos) {
		String[] pares = atributos.split(",");
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		for (String par:pares) {
			String[] dupla = par.split(":");
			params.add(new BasicNameValuePair(dupla[0].trim(), dupla[1].trim()));
		}
		 
		HttpClient httpclient = HttpClients.createDefault();
		HttpPut httpput = new HttpPut(APIUrl + "/" + tabela + "/" + id);
		httpput.setHeader("Accept", "application/json");
		httpput.setHeader("Content-type", "application/json");
		
		try {
			httpput.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		

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
		}

	}
	
	static void delete(String id, String tabela) {
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
		}
	}
	
	static void list(String tabela) {
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
		}
	}
	
	
	
}
