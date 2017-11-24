/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.Distrito;


/**
 * @author langar
 *
 */

public class DistritoConverter implements Converter<String, Distrito>{

	@Override
	public Distrito convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Distrito distrito = new Distrito();
			distrito.setCodigo(Long.valueOf(codigo));
			return distrito;
		}
		return null;
	}

	

}
