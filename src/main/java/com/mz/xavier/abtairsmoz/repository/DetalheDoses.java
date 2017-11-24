/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.repository.helper.detalhesDos.DetalheDosesQueries;



/**
 * @author langar
 *
 */
@Repository
public interface DetalheDoses extends JpaRepository<DetalheDos, Long>, DetalheDosesQueries{
	

}
