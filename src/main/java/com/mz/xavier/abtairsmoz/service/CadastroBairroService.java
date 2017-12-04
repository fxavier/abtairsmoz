/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.repository.Bairros;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeBairroException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;



/**
 * @author langar
 *
 */
@Service
public class CadastroBairroService {
	
	@Autowired
	private Bairros bairros;
	
	@Transactional
	public void salvar(Bairro bairro) {
		//Optional<Bairro> bairroExistente = bairros.findByNomeIgnoreCase(bairro.getNome());
		Optional<Bairro> bairroExistente = bairros.findByNomeAndLocalidade(bairro.getNome(),bairro.getLocalidade());
		if(bairroExistente.isPresent() && bairro.isNovo()) {
			throw new CadastroNomeBairroException("Esse nome ja foi cadastrado");
		}
		
		bairros.save(bairro);
	}
	
	@Transactional
	public void excluir(Long codigo) {
		try {
			bairros.delete(codigo);
			bairros.flush();
		} catch(PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Nao e possivel excluir o bairro");
		}
	}

}
