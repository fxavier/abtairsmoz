/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.detalhesDos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.DetalheDos;
import com.mz.xavier.abtairsmoz.repository.filter.DetalheDosFilter;


/**
 * @author langar
 *
 */
public interface DetalheDosesQueries {
	
	
	public Page<DetalheDos> filtrar(DetalheDosFilter filtro, Pageable pageable);
	

	
	

}
