/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mz.xavier.abtairsmoz.model.Bairro;



/**
 * @author langar
 *
 */
public class BairroConverter implements Converter<String, Bairro>{

	@Override
	public Bairro convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Bairro bairro = new Bairro();
			bairro.setCodigo(Long.valueOf(codigo));
			return bairro;
		}
		return null;
	}

}
