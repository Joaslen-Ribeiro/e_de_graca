package com.Edg.BackENdEdg.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min=1, max=60, message = "limite de 60 caractere")
	private String nome;
	
	@NotBlank
	@Size(min=1, max=50, message = "limite de 50 caractere")
	private String email;
	
	@NotBlank
	@Size(min=8, max=8, message = "senha de 8 caracteres")
	private String senha;
	
	private boolean empresa;
		
	
	@OneToMany (mappedBy= "usuario",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEmpresa() {
		return empresa;
	}

	public void setEmpresa(boolean empresa) {
		this.empresa = empresa;
	}
	
	
	
}
