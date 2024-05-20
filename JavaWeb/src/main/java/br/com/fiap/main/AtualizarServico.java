package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;


import br.com.fiap.beans.Servico;
import br.com.fiap.dao.ServicoDAO;

public class AtualizarServico {
    
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
        
        int idServico = inteiro("Insira o ID do servico que voce deseja alterar: ");
        
        // Consultar o servico pelo ID para obter seus dados atuais
        Servico servicoExistente = dao.buscarPorId(idServico);
        
        // Verificar se o servico existe
        if (servicoExistente != null) {
        	
            // Preencher os novos dados
        	objServico.setIdServicos(idServico);
        	objServico.setNome(texto("Nome do servico: "));
        	objServico.setDescricao(texto("Descricao do servico"));
          
            
            // Atualizar o servico com os novos dados
            System.out.println(dao.atualizar(objServico));
        } else {
            System.out.println("Servico com ID " + idServico + " não encontrado.");
        }
    }

}
