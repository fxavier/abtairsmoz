/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.localidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.filter.LocalidadeFilter;


/**
 * @author langar
 *
 */
public interface LocalidadesQueries {

	public Page<Localidade> filtrar(LocalidadeFilter filtro, Pageable pageable);
	
	public Localidade buscarComDistrito(Long codigo);
}
