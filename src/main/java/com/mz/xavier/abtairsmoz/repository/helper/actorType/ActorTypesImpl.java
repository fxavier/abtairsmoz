/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.actorType;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.repository.filter.ActorTypeFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;

/**
 * @author langar
 *
 */
public class ActorTypesImpl implements ActorTypesQueries{

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<ActorType> filtrar(ActorTypeFilter filtro, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(ActorType.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<ActorType> listarPorBSTL() {
	   return manager.createQuery("from ActorType a where a.codigo = 2 OR a.codigo = 3")
			   .getResultList();
	}
	

	private Long total(ActorTypeFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(ActorType.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(ActorTypeFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
		}	
		
	}


}
