package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Servico;
import br.com.fiap.dao.ServicoDAO;

public class CadastrarServico {
    
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }
    
    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
    	Servico objServico = new Servico();
        
        ServicoDAO dao = new ServicoDAO();
        
        
        
        objServico.setIdServicos(inteiro("Informe o Id do servico: "));
    	objServico.setNome(texto("Nome do servico: "));
    	objServico.setDescricao(texto("Descricao do servico"));
        
        System.out.println(dao.inserir(objServico));
    }

}
