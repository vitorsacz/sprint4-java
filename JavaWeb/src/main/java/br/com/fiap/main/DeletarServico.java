package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Servico;
import br.com.fiap.dao.ServicoDAO;

public class DeletarServico{
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
Servico objServico = new Servico();
        
        ServicoDAO dao = new ServicoDAO();
		
		objServico.setIdServicos(inteiro("Digite o ID do servico a ser deletado"));
		
		System.out.println(dao.deletar(objServico.getIdServicos()));
	}

}
