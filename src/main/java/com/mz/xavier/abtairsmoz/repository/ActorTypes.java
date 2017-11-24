/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.repository.helper.actorType.ActorTypesQueries;

/**
 * @author langar
 *
 */
@Repository
public interface ActorTypes extends JpaRepository<ActorType, Long>, ActorTypesQueries{
	public Optional<ActorType> findByNomeIgnoreCase(String nome);
	public List<ActorType> findByCodigo(Long codigo);

}
