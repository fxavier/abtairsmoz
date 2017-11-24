/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.localidade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.filter.LocalidadeFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;

/**
 * @author langar
 *
 */
public class LocalidadesImpl implements LocalidadesQueries{


	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Localidade> filtrar(LocalidadeFilter filtro, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Localidade.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);	
		criteria.createAlias("distrito", "d");
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	@Transactional(readOnly = true)
	@Override
	public Localidade buscarComDistrito(Long codigo) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Localidade.class);
		criteria.createAlias("distrito", "d", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("codigo", codigo));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Localidade) criteria.uniqueResult();
	}

	private Long total(LocalidadeFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Localidade.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(LocalidadeFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if(isDistritoPresent(filtro)) {
				criteria.add(Restrictions.eq("distrito", filtro.getDistrito()));
			}
			
		
		
	}
  }

	private boolean isDistritoPresent(LocalidadeFilter filtro) {
		return filtro.getDistrito() != null && filtro.getDistrito().getCodigo() != null;
	}
	
	
}
