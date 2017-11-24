/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.filter;

import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.model.Localidade;

/**
 * @author langar
 *
 */
public class BairroFilter {
	
	private String nome;
	
	private Localidade localidade;
	
	private Distrito distrito;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	

}
