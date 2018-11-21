package com.yamapi.crud_rest;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

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
				int id = reader.nextInt();
				read(id, nomeTabela);
				break;
			case 3:
				System.out.println("Digite o id");
				int idUpdate = reader.nextInt();
				System.out.println("Digite os atributos e os valores a serem criados no formato 'atributo: valor, atributo: valor, ...'");
				String atributosUpdate = reader.next();
				update(idUpdate, nomeTabela, atributosUpdate);
			case 4:
				System.out.println("Digite o id");
				int idDelete = reader.nextInt();
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
	}
	
	private static void create(String atributos, String tabela) {
		String[] pares = atributos.split(",");
		ArrayList<String> keys = new ArrayList<>();
		ArrayList<String> values = new ArrayList<>();
		for (String par:pares) {
			keys.add(par.split(":")[0].trim());
			values.add(par.split(":")[1].trim());
		}
		 
//		HttpClient httpclient = HttpClients.createDefault();
//		HttpPost httppost = new HttpPost("http://www.a-domain.com/foo/");
//
//		// Request parameters and other properties.
//		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//		params.add(new BasicNameValuePair("param-1", "12345"));
//		params.add(new BasicNameValuePair("param-2", "Hello!"));
//		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//		//Execute and get the response.
//		HttpResponse response = httpclient.execute(httppost);
//		HttpEntity entity = response.getEntity();
//
//		if (entity != null) {
//		    try (InputStream instream = entity.getContent()) {
//		        // do something useful
//		    }
//		}
	}
	
	private static void read(int id, String tabela) {
		
	}
	
	private static void update(int id, String tabela, String atributos) {
		
	}
	
	private static void delete(int id, String tabela) {
	}
	
	private static void list(String tabela) {
	}
	
		
}