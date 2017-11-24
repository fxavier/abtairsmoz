/**
 * 
 */
package com.mz.xavier.abtairsmoz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.xavier.abtairsmoz.model.Mobilizador;
import com.mz.xavier.abtairsmoz.repository.Mobilizadores;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroMobilizadorException;


/**
 * @author langar
 *
 */
@Service
public class CadastroMobilizadorService {
	
	@Autowired
	private Mobilizadores mobilizadores;
	
	@Transactional
	public void salvar(Mobilizador mobilizador) {
		Optional<Mobilizador> mobilizadorExistente = mobilizadores.findByNomeIgnoreCase(mobilizador.getNome());
		if(mobilizadorExistente.isPresent() && mobilizador.isNovo()) {
			throw new CadastroMobilizadorException("Esse nome ja existe");
		}
		
		mobilizadores.save(mobilizador);
	}

}
