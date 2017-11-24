/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.bairro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.repository.filter.BairroFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;


/**
 * @author langar
 *
 */
public class BairrosImpl implements BairrosQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Bairro> filtrar(BairroFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Bairro.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		/*criteria.createAlias("bairro.localidade", "l", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("l.distrito", "d", JoinType.LEFT_OUTER_JOIN);*/
				
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(BairroFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Bairro.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(BairroFilter filtro, Criteria criteria) {
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if(isLocalidadePresent(filtro)) {
				criteria.add(Restrictions.eq("localidade", filtro.getLocalidade()));
				}
		}
	}

	private boolean isLocalidadePresent(BairroFilter filtro) {
		return filtro.getLocalidade() != null && filtro.getLocalidade().getCodigo() != null;
	}
	
	

}
