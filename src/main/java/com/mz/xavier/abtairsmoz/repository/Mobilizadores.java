/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.Mobilizador;

/**
 * @author langar
 *
 */
@Repository
public interface Mobilizadores extends JpaRepository<Mobilizador, Long>{
	public Optional<Mobilizador> findByNomeIgnoreCase(String nome);

}
