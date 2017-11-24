/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.Localidade;


/**
 * @author langar
 *
 */
public class LocalidadeConverter implements Converter<String, Localidade>{

	@Override
	public Localidade convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Localidade localidade = new Localidade();
			localidade.setCodigo(Long.valueOf(codigo));
			return localidade;
		}
		return null;
	}

}
