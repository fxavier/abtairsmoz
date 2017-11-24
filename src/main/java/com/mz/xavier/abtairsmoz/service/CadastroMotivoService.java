/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Motivo;
import com.mz.xavier.abtairsmoz.repository.Motivos;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroMotivoException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;


/**
 * @author langar
 *
 */
@Service
public class CadastroMotivoService {
	
	@Autowired
	private Motivos motivos;
	
	@Transactional
	public void salvar(Motivo motivo) {
		Optional<Motivo> motivoExistente = motivos.findByNomeIgnoreCase(motivo.getNome());
		if(motivoExistente.isPresent() && motivo.isNovo()) {
			throw new CadastroMotivoException("Esse motivo ja foi cadastrado!");
		}
		
		motivos.save(motivo);
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			motivos.delete(codigo);
			motivos.flush();
		}catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Nao e possivel excluir o registo ");
		}
	}

}
