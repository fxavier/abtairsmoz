/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.distrito;

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

import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.repository.filter.DistritoFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;


/**
 * @author langar
 *
 */
public class DistritosImpl implements DistritosQueries {

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Distrito> filtrar(DistritoFilter filtro, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Distrito.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private Long total(DistritoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Distrito.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(DistritoFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
		}	
		
	}

}
