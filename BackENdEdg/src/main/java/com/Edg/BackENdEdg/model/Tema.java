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
@Table(name = "tb_tema")
public class Tema {
	
	// Atributos
	
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long id;
		
		@NotBlank 
		@Size(min = 1, max = 50, message = "Limite de 50 caracteres")
		private String titulo;
				
		@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("tema")
		private List<Postagem> postagens;
		
		public List<Postagem> getPostagens() {
			return postagens;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public void setPostagens(List<Postagem> postagens) {
			this.postagens = postagens;
		}
		}
