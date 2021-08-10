package com.Edg.BackENdEdg.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Edg.BackENdEdg.model.Tema;
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByAreaContainingIgnoreCase(String area);
	public List<Tema> findAllByTipoDeAcaoContainingIgnoreCase(String tipodeacao);
	public List<Tema> findAllByPublicoContainingIgnoreCase(String publico);
	public List<Tema> findAllByCidadeContainingIgnoreCase(String cidade);
	public List<Tema> findAllByData(LocalDate data);
}
