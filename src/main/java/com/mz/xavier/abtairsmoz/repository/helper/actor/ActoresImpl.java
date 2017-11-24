/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.actor;




import java.util.List;

import javax.persistence.EntityManager;

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

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.repository.filter.ActorFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;


/**
 * @author langar
 *
 */
public class ActoresImpl implements ActoresQueries{

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Actor> filtrar(ActorFilter filtro, Pageable pageable) {
        Criteria criteria = manager.unwrap(Session.class).createCriteria(Actor.class);
		criteria.createAlias("actorType", "a");
		criteria.createAlias("distrito", "d");
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);	
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	

	@Override
	@Transactional(readOnly = true)
	public Actor buscarComDistrito(Long codigo) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Actor.class);
		criteria.createAlias("distrito", "d", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("codigo", codigo));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Actor) criteria.uniqueResult();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Actor> listarSupervisores() {
		return manager.createQuery("from Actor a where a.actorType.codigo IN (2,3)", Actor.class)
				.getResultList();
	}


	private Long total(ActorFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Actor.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(ActorFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if(isActorTypePresent(filtro)) {
				criteria.add(Restrictions.eq("actorType", filtro.getActorType().getNome()));
			}
			
			if(isDistritoPresent(filtro)) {
				
			}
			
		}	
		
	}
	
	

	private boolean isDistritoPresent(ActorFilter filtro) {
		return filtro.getDistrito() != null && filtro.getDistrito().getCodigo() != null;
	}

	private boolean isActorTypePresent(ActorFilter filtro) {
		return filtro.getActorType() != null && filtro.getActorType().getCodigo() != null;
	}



	




}
