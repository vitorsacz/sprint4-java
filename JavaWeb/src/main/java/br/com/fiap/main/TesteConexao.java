package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.conexao.ConnectionFactory;


public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

     Connection c = new ConnectionFactory().conexao();
     
     System.out.println("Conectado com o Banco");
     
     c.close();    		 

	}

}
