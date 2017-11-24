/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

/**
 * @author langar
 *
 */
public enum Resposta {
	
   SIM("Sim"),
   NAO("Não");
	
	private String descricao;
	
	Resposta(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
