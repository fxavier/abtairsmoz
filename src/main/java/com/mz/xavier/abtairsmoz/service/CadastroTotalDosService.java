/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.TotalTLDoses;
import com.mz.xavier.abtairsmoz.service.exception.CadastroTotaisException;

/**
 * @author langar
 *
 */
@Service
public class CadastroTotalDosService {
	
	@Autowired
	private TotalTLDoses totalTLDoses;
	
	@Transactional
	public void salvar(TotaisTlDos totaisTlDos) {
		Optional<TotaisTlDos> totalExistente = totalTLDoses.findByReferencia(totaisTlDos.getReferencia());
		if(totalExistente.isPresent() && totaisTlDos.isNovo()) {
			throw new CadastroTotaisException("Esse total ja foi cadastrado");
		}
		totalTLDoses.save(totaisTlDos);
	}
	
		
	
}
