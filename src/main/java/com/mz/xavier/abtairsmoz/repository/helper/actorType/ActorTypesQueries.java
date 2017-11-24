/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.actorType;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.repository.filter.ActorTypeFilter;

/**
 * @author langar
 *
 */
public interface ActorTypesQueries {
	
	public Page<ActorType> filtrar(ActorTypeFilter filtro, Pageable pageable );
	
	public List<ActorType> listarPorBSTL();
	
}
