/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.Actor;


/**
 * @author langar
 *
 */
public class ActorConverter implements Converter<String, Actor>{

	@Override
	public Actor convert(String codigo) {
	    if(!StringUtils.isEmpty(codigo)) {
	    	Actor actor = new Actor();
	    	actor.setCodigo(Long.valueOf(codigo));
	    	return actor;
	    }
		return null;
	}

}
