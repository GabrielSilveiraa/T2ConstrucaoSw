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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.commons.*;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	//private static String APIUrl = "http://localhost:8080"; 
	//private static Operations operations;
	
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
				Operations.create(atributos, nomeTabela);
				break;
			case 2:
				System.out.println("Digite o id");
				String id = reader.next();
				Operations.read(id, nomeTabela);
				break;
			case 3:
				System.out.println("Digite o id");
				String idUpdate = reader.next();
				System.out.println("Digite os atributos e os valores a serem criados no formato 'atributo: valor, atributo: valor, ...'");
				String atributosUpdate = reader.next();
				Operations.update(idUpdate, nomeTabela, atributosUpdate);
			case 4:
				System.out.println("Digite o id");
				String idDelete = reader.next();
				Operations.delete(idDelete, nomeTabela);
			case 5:
				Operations.list(nomeTabela);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			menu();
	}
	
	
	
}