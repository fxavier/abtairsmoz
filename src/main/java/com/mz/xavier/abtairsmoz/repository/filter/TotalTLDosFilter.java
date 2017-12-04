/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.filter;

import java.time.LocalDate;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.model.Localidade;

/**
 * @author langar
 *
 */
public class TotalTLDosFilter {
	
	private Distrito distrito;
	
	private Localidade localidade;
	
	private Bairro bairro;
	
	private ActorType actorType;
	
	private Actor actor;
	
	private LocalDate data;
	

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public ActorType getActorType() {
		return actorType;
	}

	public void setActorType(ActorType actorType) {
		this.actorType = actorType;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	

}
