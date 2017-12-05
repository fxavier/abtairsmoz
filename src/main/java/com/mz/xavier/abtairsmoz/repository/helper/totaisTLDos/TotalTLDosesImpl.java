package com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.filter.TotalTLDosFilter;
import com.mz.xavier.abtairsmoz.repository.paginacao.PaginacaoUtil;


public class TotalTLDosesImpl implements TotalTLDosesQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

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
	public Actor findUltimoBSTL() {
		
		return null;
	}

	@Override
	public Long findLastCodigo() {
		return manager.createQuery(
				 "select Max(t.codigo) from TotaisTlDos t", Long.class)
					.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<TotaisTlDos> filtrar(TotalTLDosFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(TotaisTlDos.class);
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Optional<TotaisTlDos> obterUmTotal(DetalheDos dDos) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(TotaisTlDos.class);
		adicionarParametros(dDos, criteria);
		return (Optional<TotaisTlDos>) criteria.uniqueResult();
	}

	private void adicionarParametros(DetalheDos dDos, Criteria criteria) {
		if(dDos != null) {
			if(dDos.getData() != null) {
				criteria.add(Restrictions.eq("data", dDos.getData()));
			}
			
			if(dDos.getDistrito() != null && dDos.getDistrito().getCodigo() != null) {
				criteria.add(Restrictions.eq("distrito", dDos.getDistrito()));
			}
			
			if(dDos.getLocalidade() != null && dDos.getLocalidade().getCodigo() != null) {
				criteria.add(Restrictions.eq("localidade", dDos.getLocalidade()));
			}
			
			if(dDos.getBairro() != null && dDos.getDistrito().getCodigo() != null) {
				criteria.add(Restrictions.eq("bairro", dDos.getBairro()));
			}
			
			if(dDos.getTeamLeaderOuChefeBrigada() != null && dDos.getTeamLeaderOuChefeBrigada().getCodigo() != null) {
				criteria.add(Restrictions.eq("teamLeaderOuChefeBrigada", dDos.getTeamLeaderOuChefeBrigada()));
			}
		}
	}
	
	private Long total(TotalTLDosFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(TotaisTlDos.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());		
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(TotalTLDosFilter filtro, Criteria criteria) {
		
		if(filtro != null) {
			if(filtro.getData() != null) {
				criteria.add(Restrictions.eq("data", filtro.getData()));
			}
			
			if(isDistritoPresente(filtro)) {
				criteria.add(Restrictions.eq("distrito", filtro.getDistrito()));
			}
			
			if(isLocalidadePresente(filtro)) {
				criteria.add(Restrictions.eq("localidade", filtro.getLocalidade()));
			}
			
			if(isBairroPresente(filtro)) {
				criteria.add(Restrictions.eq("bairro", filtro.getBairro()));
			}
			
			if(isActorPresente(filtro)) {
				criteria.add(Restrictions.eq("actor", filtro.getActor()));
			}
					
			
		} 
		
		
		
	}

	private boolean isActorPresente(TotalTLDosFilter filtro) {
		return filtro.getActor() != null && filtro.getActor().getCodigo() != null;
	}

	private boolean isBairroPresente(TotalTLDosFilter filtro) {
		return filtro.getBairro() != null && filtro.getBairro().getCodigo() != null;
	}

	private boolean isLocalidadePresente(TotalTLDosFilter filtro) {
		return filtro.getLocalidade() != null && filtro.getLocalidade().getCodigo() != null;
	}

	private boolean isDistritoPresente(TotalTLDosFilter filtro) {
		return filtro.getDistrito() != null && filtro.getDistrito().getCodigo() != null;
	}

	@Transactional(readOnly = true)
	@Override
	public TotaisTlDos buscarComRelacionamentos(Long codigo) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(TotaisTlDos.class);
		criteria.createAlias("distrito","d", JoinType.INNER_JOIN);
		criteria.createAlias("localidade", "l", JoinType.INNER_JOIN);
		criteria.createAlias("bairro", "b", JoinType.INNER_JOIN);
		criteria.createAlias("teamLeaderOuChefeBrigada", "tl", JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("codigo", codigo));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (TotaisTlDos) criteria.uniqueResult();
	}


	
}
