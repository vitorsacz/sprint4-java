package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Servico;
import br.com.fiap.dao.ServicoDAO;

public class SelecionarServicos {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Instanciar objetos 
		ServicoDAO dao = new ServicoDAO();
		
		List<Servico> listaServico = dao.selecionar();
		
		if(listaServico != null) {
			// foreach 
			for(Servico servico : listaServico) {
				System.out.println(servico.getIdServicos() + " " + 
								   servico.getNome() + " " +  
								   servico.getDescricao() + " ");
								   
			}
		}
	}
}

