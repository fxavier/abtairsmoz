/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.detalhesDos;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.repository.filter.DetalheDosFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;


/**
 * @author langar
 *
 */
public class DetalheDosesImpl implements DetalheDosesQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	

	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<DetalheDos> filtrar(DetalheDosFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(DetalheDos.class);
		paginacaoUtil.preparar(criteria, pageable);
	    adicionarFiltro(filtro, criteria);
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	
	private Long total(DetalheDosFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(DetalheDos.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}



	private void adicionarFiltro(DetalheDosFilter filtro, Criteria criteria) {
		if(filtro != null) {
			if(filtro.getData() != null) {
				criteria.add(Restrictions.eq("data", filtro.getData()));
			}
					
			if(isBairroPresente(filtro)) {
				criteria.add(Restrictions.eq("bairro", filtro.getBairro()));
			}
			
			if(isActorPresent(filtro)) {
				criteria.add(Restrictions.eq("actor", filtro.getActor()));
			}
		} 
	}

	private boolean isActorPresent(DetalheDosFilter filtro) {
		return filtro.getActor() != null && filtro.getActor().getCodigo() != null;
	}

	private boolean isBairroPresente(DetalheDosFilter filtro) {
		return filtro.getBairro() != null && filtro.getBairro().getCodigo() != null;
	}




	

}
