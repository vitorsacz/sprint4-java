package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Servico;
import br.com.fiap.dao.ServicoDAO;

public class ServicoBO {
	
	ServicoDAO servicoDao;
	
	//Inserir 
	public void inserirBO(Servico servico) throws ClassNotFoundException, SQLException {
		servicoDao = new ServicoDAO();
		
		servicoDao.inserir(servico);
	}
	
	//Atualizar
	public void atualizarBO(Servico servico) throws ClassNotFoundException, SQLException {
		servicoDao = new ServicoDAO();
		
		servicoDao.atualizar(servico);
	}
	
	//Deletar
	public void deletarBO(int id) throws ClassNotFoundException, SQLException {
	
		servicoDao = new ServicoDAO();
		
		servicoDao.deletar(id);
	}

	//Selecionar
	public List<Servico> selecionarBO() throws ClassNotFoundException, SQLException{
		servicoDao = new ServicoDAO();
		
		return (ArrayList<Servico>) servicoDao.selecionar();
		
	}
}
