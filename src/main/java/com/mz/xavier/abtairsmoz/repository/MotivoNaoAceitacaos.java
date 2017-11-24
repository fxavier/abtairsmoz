/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.xavier.abtairsmoz.model.MotivoNaoAceitacao;



/**
 * @author langar
 *
 */
public interface MotivoNaoAceitacaos extends JpaRepository<MotivoNaoAceitacao, Long>{
	public Optional<MotivoNaoAceitacao> findByNomeIgnoreCase(String nome);

}
