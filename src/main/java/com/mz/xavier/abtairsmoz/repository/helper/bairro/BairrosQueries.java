/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.bairro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.repository.filter.BairroFilter;


/**
 * @author langar
 *
 */
public interface BairrosQueries {
	
	public Page<Bairro> filtrar(BairroFilter filtro, Pageable pageable);

}
