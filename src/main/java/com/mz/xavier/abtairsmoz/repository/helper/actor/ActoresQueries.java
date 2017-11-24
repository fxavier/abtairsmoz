/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.actor;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.repository.filter.ActorFilter;


/**
 * @author langar
 *
 */
public interface ActoresQueries {

	public Page<Actor> filtrar(ActorFilter filtro, Pageable pageable );
	
	public Actor buscarComDistrito(Long codigo);
	
	public List<Actor> listarSupervisores();
	
	
}
