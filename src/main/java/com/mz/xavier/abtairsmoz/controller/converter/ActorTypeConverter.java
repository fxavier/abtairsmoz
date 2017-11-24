/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.ActorType;


/**
 * @author langar
 *
 */
public class ActorTypeConverter implements Converter<String, ActorType>{

	@Override
	public ActorType convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			ActorType actorType = new ActorType();
			actorType.setCodigo(Long.valueOf(codigo));
			return actorType;
		}
		return null;
	}

}
