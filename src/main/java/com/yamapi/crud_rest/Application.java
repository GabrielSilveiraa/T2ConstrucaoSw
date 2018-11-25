package com.yamapi.crud_rest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import org.apache.commons.*;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	private static String APIUrl = "http://localhost:8080"; 
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        menu();
    }
    
	private static void menu() { // menu principal
			System.out
					.println("\n\n### Sistema de aluguel de carro ###");
			System.out.println("\n                  =========================");
			System.out.println("                  |     1 - Create           |");
			System.out.println("                  |     2 - Read             |");
			System.out.println("                  |     3 - Update           |");
			System.out.println("                  |     4 - Delete           |");
			System.out.println("                  |     5 - List             |");
			System.out.println("                  |     0 - Quit             |");
			System.out.println("                  =========================\n");
			Scanner reader = new Scanner(System.in);
			int opcao = reader.nextInt();
			System.out.print("\n");
			System.out.println("Digite o nome da tabela:");
			String nomeTabela = reader.next();
			switch (opcao) {
			case 1:
				System.out.println("Digite os atributos e os valores a serem criados no formato 'atributo: valor, atributo: valor, ...'");
				String atributos = reader.next();
				create(atributos, nomeTabela);
				break;
			case 2:
				System.out.println("Digite o id");
				String id = reader.next();
				read(id, nomeTabela);
				break;
			case 3:
				System.out.println("Digite o id");
				String idUpdate = reader.next();
				System.out.println("Digite os atributos e os valores a serem criados no formato 'atributo: valor, atributo: valor, ...'");
				String atributosUpdate = reader.next();
				update(idUpdate, nomeTabela, atributosUpdate);
			case 4:
				System.out.println("Digite o id");
				String idDelete = reader.next();
				delete(idDelete, nomeTabela);
			case 5:
				list(nomeTabela);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			menu();
	}
	
	
	private static void create(String atributos, String tabela) {
		String[] pares = atributos.split(",");
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		for (String par:pares) {
			String[] dupla = par.split(":");
			params.add(new BasicNameValuePair(dupla[0].trim(), dupla[1].trim()));
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
	
	private static void read(String id, String tabela) {		 
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
	
	private static void update(String id, String tabela, String atributos) {
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
	
	private static void delete(String id, String tabela) {
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
	
	private static void list(String tabela) {
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