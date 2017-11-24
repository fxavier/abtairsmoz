/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.TotaisMobilizacao;
import com.mz.xavier.abtairsmoz.repository.TotaisMobilizacaos;


/**
 * @author langar
 *
 */
@Service
public class CadastroTotaisMobilicaoService {
	
	@Autowired
	private TotaisMobilizacaos totaisMobilizacaos;
	
	
	@Transactional
	public void salvar(TotaisMobilizacao totaisMobilizacao) {
		// TODO: Regras de negocio
		
		totaisMobilizacaos.save(totaisMobilizacao);
	}
	
	
}
