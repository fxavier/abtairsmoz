package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.DetalheDoses;
import com.mz.xavier.abtairsmoz.repository.TotalTLDoses;
import com.mz.xavier.abtairsmoz.service.exception.CadastroDetalheException;

@Service
public class CadastroDetalhesDosService {
	
	@Autowired
	private DetalheDoses detalheDoses;
	
	@Autowired
	private TotalTLDoses totalTLDoses;
	
	@Transactional
	public void salvar(DetalheDos detalheDos) {
		Optional<TotaisTlDos> totalExistente = totalTLDoses.findByReferencia(detalheDos.getReferencia());
		if(!totalExistente.isPresent()) {
			throw new CadastroDetalheException("Esse detalhe nao tem total correspondente!, por favor introduza o total primeiro");
			
		}
		
		detalheDoses.save(detalheDos);
	}

}
