/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.TotalTLDoses;

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
		totalTLDoses.save(totaisTlDos);
	}
	
	
}
