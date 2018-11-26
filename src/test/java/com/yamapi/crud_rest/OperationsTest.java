package com.yamapi.crud_rest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


import com.yamapi.crud_rest.entities.Cliente;

import junit.framework.Assert;
import junit.framework.TestCase;


//Classe que testa as operacoes basicas da classe operations (logica bruta do trabalho)

public class OperationsTest extends TestCase {

	@InjectMocks
	Operations operations;

	public OperationsTest()
	{
		MockitoAnnotations.initMocks(this);

		operations = new Operations();
	}
	
	
	//Testa o input do usuario ao criar um novo registro, se a forma de colocar os dados esta certa
	@Test
	public void testDataInput()
	{
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		
		Assert.assertFalse(Operations.create("cpf,999,nome,TESTE", "cliente"));	
			
	}
	
	

	//Testa a lógica de criação de um novo registro
	@Test
	public void createTest()
	{
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		
		Assert.assertTrue(Operations.create("cpf:999,nome:TESTE", "cliente"));	
		Operations.delete("999", "cliente");
		
	}
	
	
	//Testa a atualização de um registro já existente
	@Test
	public void updateTest()
	{
		
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		Operations.create("cpf:999,nome:TESTE", "cliente");
		
		
		Assert.assertTrue(Operations.update("999","nome:update", "cliente"));	
		Operations.delete("999", "cliente");
		
	}	
	
	
	
	//Testa a consulta a um registro
	@Test
	public void getTest()
	{
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		Operations.create("cpf:999,nome:TESTE", "cliente");
		
		Assert.assertTrue(Operations.read("999", "cliente"));
		Operations.delete("999", "cliente");

	}
	
	
	//Testa a opção de retornar todos os dados de uma tabela
	@Test
	public void getAllTest()
	{
		
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		Operations.create("cpf:999,nome:TESTE", "cliente");
		
		Assert.assertTrue(Operations.list("cliente"));
		
		Operations.delete("999", "cliente");


		
	}
	
	//Testa a delecao de um registro
	@Test
	public void deleteTest()
	{
		
		MockitoAnnotations.initMocks(this);
		Cliente cliente = new Cliente();
		cliente.setCpf("999");
		cliente.setNome("TESTE");
		Operations.create("cpf:999,nome:TESTE", "cliente");
		
		
		Assert.assertTrue(Operations.delete("999", "cliente"));	
			
		Operations.delete("999", "cliente");

	}	
	
	
}
