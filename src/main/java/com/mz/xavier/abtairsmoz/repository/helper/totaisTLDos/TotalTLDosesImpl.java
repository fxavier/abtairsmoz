package com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.Bairro;


public class TotalTLDosesImpl implements TotalTLDosesQueries{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public String findLastUUID() {
		
		return manager.createQuery(
		  "select t.UUID from TotaisTlDos t where t.codigo = (select max(codigo) from TotaisTlDos)", String.class)
				.getSingleResult();
	}

	@Override
	public Long findUltmoBairro() {
		return manager.createQuery(
		"select b.codigo from TotaisTlDos t, Bairro b where where t.codigo = (select max(codigo) from TotaisTlDos)", Long.class)
				.getSingleResult();
	}

	@Override
	public LocalDate findUltimaData() {		
		return  manager.createQuery(
				 "select t.data from TotaisTlDos t where t.codigo = (select max(codigo) from TotaisTlDos)", LocalDate.class)
					.getSingleResult();
	}
	
	@Override
	public Long obtrCodigoTotalDoses(LocalDate data, Bairro bairro) {
		return  manager.createQuery(
				"select codigo from TotaisTlDos  where data = :data and bairro = :bairro" , Long.class)
		        .setParameter("data", data)
		        .setParameter("bairro", bairro)
		        .getSingleResult();
	}




	@Override
	public Actor findUltimoBSTL() {
		
		return null;
	}

	@Override
	public Long findLastCodigo() {
		return manager.createQuery(
				 "select Max(t.codigo) from TotaisTlDos t", Long.class)
					.getSingleResult();
	}

	
}
