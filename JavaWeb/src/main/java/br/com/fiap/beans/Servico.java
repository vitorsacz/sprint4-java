package br.com.fiap.beans;


public class Servico {
	
    private int id_servicos;
    private String nome;
    private String descricao;

    
    public Servico(int idServicos, String nome, String descricao) {
        this.id_servicos = idServicos;
        this.nome = nome;
        this.descricao = descricao;
    }


	public Servico() {
	}


	public int getIdServicos() {
		return id_servicos;
	}

	public void setIdServicos(int idServicos) {
		this.id_servicos = idServicos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    
}