package com.mz.xavier.abtairsmoz.dto;


public class AlertasVermelhasDistrito {	
	
	private String distrito;
	private Integer total;

	public AlertasVermelhasDistrito() {
		
	}
	
	public AlertasVermelhasDistrito(String distrito, Integer total) {
		this.total = total;
		this.distrito = distrito;
	}
	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	

}
