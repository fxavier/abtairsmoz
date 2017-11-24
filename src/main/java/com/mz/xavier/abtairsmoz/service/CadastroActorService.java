/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.repository.Actores;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeActorException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;

/**
 * @author langar
 *
 */
@Service
public class CadastroActorService {
	
	@Autowired
	private Actores actores;
	
	@Transactional
	public void salvar(Actor actor) {
		Optional<Actor> actorExistente = actores.findByNomeIgnoreCase(actor.getNome());
		if(actorExistente.isPresent() && actor.isNovo()) {
			throw new CadastroNomeActorException("Este actor ja existe");
		}
		
		actores.save(actor);
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			actores.delete(codigo);
			actores.flush();
		}catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Nao e possivel excluir o actor");
		}
	}

}
