package com.mz.xavier.abtairsmoz.dto;

public class SupervisoesPorMes {
	
	private String mes;
	private Integer total;
	
	
	public SupervisoesPorMes() {
		
	}


	public SupervisoesPorMes(String mes, Integer total) {
		this.mes = mes;
		this.total = total;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}
	
	

}
