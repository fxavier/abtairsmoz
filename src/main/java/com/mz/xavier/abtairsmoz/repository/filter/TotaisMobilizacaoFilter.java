/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.filter;

import java.time.LocalDate;

import com.mz.xavier.abtairsmoz.model.Actor;

/**
 * @author langar
 *
 */
public class TotaisMobilizacaoFilter {
	
	private LocalDate data;
	
	private Actor actor;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	

}
