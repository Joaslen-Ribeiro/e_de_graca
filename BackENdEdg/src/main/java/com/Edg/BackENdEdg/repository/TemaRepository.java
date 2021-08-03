package com.Edg.BackENdEdg.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Edg.BackENdEdg.model.modelTema;
@Repository
public interface TemaRepository extends JpaRepository<modelTema, Long> {

	public List<modelTema> findAllByAreaContainingIgnoreCase(String area);
	public List<modelTema> findAllByTipoDeAcaoContainingIgnoreCase(String tipodeacao);
	public List<modelTema> findAllByPublicoContainingIgnoreCase(String publico);
	public List<modelTema> findAllByCidadeContainingIgnoreCase(String cidade);
	public List<modelTema> findAllByData(LocalDate data);
}
