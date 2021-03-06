package com.yamapi.crud_rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;



//Classe com a logica de conexao do JAVA e as APIs
//Aqui fornecera as ações de CREATE, UPDATE, DELETE, LIST E GET

public class Operations {

	
	private static String APIUrl = "http://localhost:8080"; 

	
	//Recebe os atributos do objeto a ser inserido no formato: "coluna:valor,..." e a tabela no qual o objeto ira ser inserido
	//Utiliza requests Https para se unir ao legado do yamaapi.
	static Boolean create(String atributos, String tabela) {
		String[] pares = atributos.split(",");
		try {
			String paramsString = "{";	

			for (String par:pares) {
				String[] dupla = par.split(":");
				paramsString += "\""+dupla[0].trim()+"\":\""+ dupla[1]+"\",";
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
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (Exception e) {
			System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
			
			return false;
		}
		
		return true;
	}
	
	//Recebe os atributos do objeto a ser lido no formato: "coluna:valor,..." e a tabela no qual o objeto ira ser lido
	//Utiliza requests Https para se unir ao legado do yamaapi. REQUEST /GET/ID
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
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		}
		catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;
		
	}
	
	//Recebe os atributos do objeto a ser atualizado no formato: "coluna:valor,..." e a tabela no qual o objeto ira ser atualizado
	//Utiliza requests Https para se unir ao legado do yamaapi. REQUEST: /PATCH/ID
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
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}

		return true;
		
	}
	
	//Recebe o ID (valor da coluna) e o nome da tabela do objeto
	//Utiliza requests Https para se unir ao legado do yamaapi. Request: /DELETE/ID
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
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;
	}
	
	//Recebe por parametro a tabela dos objetos a serem listados
	//Utiliza requests Https para se unir ao legado do yamaapi.
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
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			System.out.println("Aconteceu um erro inesperado, por favor tente outra vez.");
			return false;
		} catch (Exception e) {
		System.out.println("Formato de entrada errado, verifique a grafia e tente outra vez.");
		
		return false;
	}
		
		return true;

	}
	
	
	
}
