/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.distrito;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.repository.filter.DistritoFilter;

/**
 * @author langar
 *
 */
public interface DistritosQueries {
	public Page<Distrito> filtrar(DistritoFilter filtro, Pageable pageable);

}
