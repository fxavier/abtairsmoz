/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.repository.helper.distrito.DistritosQueries;



/**
 * @author langar
 *
 */
@Repository
public interface Distritos extends JpaRepository<Distrito, Long>, DistritosQueries{
	public Optional<Distrito> findByNomeIgnoreCase(String nome);

}
