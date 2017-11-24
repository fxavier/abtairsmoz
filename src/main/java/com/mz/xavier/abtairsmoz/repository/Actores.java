/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.repository.helper.actor.ActoresQueries;


/**
 * @author langar
 *
 */
@Repository
public interface Actores extends JpaRepository<Actor, Long>, ActoresQueries{
	public Optional<Actor> findByNomeIgnoreCase(String nome);
	
	public List<Actor> findByActorTypeCodigo(Long codigo);

}
