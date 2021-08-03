package com.Edg.BackENdEdg.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity              
@Table(name = "tb_tema")
public class modelTema {
	
	//atributos
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank
	@Size(min = 1, max=50, message = "limite de 50 caracteres")
	private String area;
	
	@NotBlank
	@Size(min = 1, max=50, message = "limite de 50 caracteres")
	private String tipoDeAcao;
	
	@NotBlank
	@Size(min = 1, max=50, message = "limite de 50 caracteres")
	private String publico;
	
	@NotBlank
	@Size(min = 1, max=50, message = "limite de 50 caracteres")
	private String cidade;
	
	@NotBlank
	private LocalDate data;

	
	   public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	//metodos
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipoDeAcao() {
		return tipoDeAcao;
	}

	public void setTipoDeAcao(String tipoDeAcao) {
		this.tipoDeAcao = tipoDeAcao;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	
	
	
}
