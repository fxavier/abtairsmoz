/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeDistritoException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;


/**
 * @author langar
 *
 */
@Service
public class CadastroDistritoService {
	
	@Autowired
	private Distritos distritos;
	
	@Transactional
	public void salvar(Distrito distrito) {
		Optional<Distrito> distritoexistente = distritos.findByNomeIgnoreCase(distrito.getNome());
		if(distritoexistente.isPresent() && distrito.isNovo()) {
			throw new CadastroNomeDistritoException("Esse distrito ja foi cadastrado");
		}
		
		distritos.save(distrito);
		
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			distritos.delete(codigo);
			distritos.flush();
		}catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Nao e possivel excluir o registo");
		}
	}

}
