package com.mz.xavier.abtairsmoz.dto;

import java.time.LocalDate;


public class PeriodoRelatorio {

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String distrito;
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	
		
	

}
