/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.filter;

import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.model.Distrito;

/**
 * @author langar
 *
 */
public class ActorFilter {
	
	private String nome;
	
	private ActorType actorType;
	
	private Distrito distrito;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ActorType getActorType() {
		return actorType;
	}

	public void setActorType(ActorType actorType) {
		this.actorType = actorType;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	

}
