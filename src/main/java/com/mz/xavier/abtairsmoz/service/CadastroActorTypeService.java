/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroActorTypeException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;



/**
 * @author langar
 *
 */
@Service
public class CadastroActorTypeService {
	@Autowired
	private ActorTypes actorTypes;
	
	@Transactional
	public void salvar(ActorType actorType) {
		Optional<ActorType> actorTypeExistente = actorTypes.findByNomeIgnoreCase(actorType.getNome());
		if(actorTypeExistente.isPresent() && actorType.isNovo()) {
			throw new CadastroActorTypeException("Esse tipo de actor ja foi cadastrado");
		}
		
		actorTypes.save(actorType);
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			actorTypes.delete(codigo);
			actorTypes.flush();
		} catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Não é possível excluir esse registo, pois etsta sendo usado");
		}
		
	}
	

}
