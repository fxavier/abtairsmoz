/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.MotivoNaoAceitacao;
import com.mz.xavier.abtairsmoz.repository.MotivoNaoAceitacaos;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroMotivoNaoAceitacaoException;

/**
 * @author langar
 *
 */
@Service
public class CadastroMotivoNaoAceitacaoService {
	
	@Autowired
	private MotivoNaoAceitacaos motivoNaoAceitacaos;
	
	@Transactional
	public void salvar(MotivoNaoAceitacao motivoNaoAceitacao) {
		Optional<MotivoNaoAceitacao> motivoNaoAceitacaoExistente =
				motivoNaoAceitacaos.findByNomeIgnoreCase(motivoNaoAceitacao.getNome());
		if(motivoNaoAceitacaoExistente.isPresent() && motivoNaoAceitacao.isNovo()) {
			throw new CadastroMotivoNaoAceitacaoException("Esse nome ja existe");
		}
		
		motivoNaoAceitacaos.save(motivoNaoAceitacao);
			
		
		
	}

}
