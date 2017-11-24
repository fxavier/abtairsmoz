/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.Localidades;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeLocalidadeException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;



/**
 * @author langar
 *
 */
@Service
public class CadastroLocalidadeService {
	
	@Autowired
	private Localidades localidades;
	
	@Transactional
	public void salvar(Localidade localidade) {
		Optional<Localidade> localidadeExistente = localidades.findByNomeIgnoreCase(localidade.getNome());
		if(localidadeExistente.isPresent() && localidade.isNova()) {
			throw new CadastroNomeLocalidadeException("Essa localidade ja existe");
		}
		
		localidades.save(localidade);
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			localidades.delete(codigo);
			localidades.flush();
		}catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Nao e possivel excluir a localidade");
		}
	}

}
