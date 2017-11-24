/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

/**
 * @author langar
 *
 */
public enum Gender {
	
	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;
	
	Gender(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
