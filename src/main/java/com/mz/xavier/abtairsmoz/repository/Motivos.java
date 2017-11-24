/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mz.xavier.abtairsmoz.model.Motivo;


/**
 * @author langar
 *
 */
public interface Motivos extends JpaRepository<Motivo, Long>{
	public Optional<Motivo> findByNomeIgnoreCase(String nome);

}
