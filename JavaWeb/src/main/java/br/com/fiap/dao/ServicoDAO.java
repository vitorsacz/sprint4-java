package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Servico;
import br.com.fiap.conexao.ConnectionFactory;

public class ServicoDAO {
	
	public Connection minhaConexao; 
	
	public ServicoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}
	
	//metodo de inserir cliente
	public String inserir (Servico servico) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
	            "INSERT INTO T_CH_SERVICOS (id_servicos, nome, descricao)"
	            + "VALUES (?, ?, ?)"
	        );
		
		stmt.setInt(1, servico.getIdServicos());
		stmt.setString(2, servico.getNome());
		stmt.setString(3, servico.getDescricao());
		
		
		stmt.executeUpdate();
        stmt.close(); 
        
        
		return "Cadastrado com sucesso";
	}
	
	// Método para buscar um cliente pelo ID
    public Servico buscarPorId(int id) throws SQLException {
    	Servico servico = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Preparar a consulta SQL
            stmt = minhaConexao.prepareStatement("SELECT * FROM T_CH_SERVICOS WHERE ID_SERVICOS = ?");
            stmt.setInt(1, id);

            // Executar a consulta
            rs = stmt.executeQuery();

            // Verificar se encontrou um cliente
            if (rs.next()) {
                // Preencher os dados do cliente encontrado
                servico = new Servico();
                servico.setIdServicos(rs.getInt("ID"));
                servico.setNome(null);
                servico.setDescricao(rs.getString("DESCRICAO"));
                
                
            }
        } finally {
            // Fechar recursos
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return servico;
    }
	
	//metodo para deletar um cliente pelo id
	public String deletar(int id_servico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_CH_SERVICOS WHERE id_servicos = ?");
        
        stmt.setInt(1, id_servico);
        
        stmt.execute();
        stmt.close();        
        
        return "Deletado com Sucesso!";
    }
	
	
	//metodo para atualizar 
	public String atualizar(Servico servico) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
            "UPDATE T_CH_SERVICOS SET NOME = ?, DESCRICAO = ? WHERE ID_SERVICO = ?"
        );
        
		stmt.setString(2, servico.getNome());
		stmt.setString(3, servico.getDescricao());
		
		
        stmt.executeUpdate();
        stmt.close();    
        return "Atualizado com Sucesso!";
    }
	
	
	// Método para selecionar todos os clientes
    public List<Servico> selecionar() throws SQLException{
    	
        List<Servico> listaServicos = new ArrayList<Servico>();
        
        PreparedStatement stmt = minhaConexao.prepareStatement
            ("SELECT * FROM T_CH_SERVICOS");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
        	Servico servico = new Servico();
        	
        	servico.setIdServicos(rs.getInt(1));
        	servico.setNome(rs.getString(2));
        	servico.setDescricao(rs.getString(3));
        }       
        return listaServicos;        
    }
	
}