/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author langar
 *
 */
@Entity
@Table(name = "totais_mobilizacao")
public class TotaisMobilizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private LocalDateTime data;
	
	@Column(name="est_el_sensibilizadaSim")
	private Long numEstElSensibilizadaSim;
	
	@Column(name = "est_el_sensibilizadaNao")
	private Long numEstElSensibilizadaNao;
	
	@Column(name = "num_adultosH")
	private Long numAdultosHomens;
	
	@Column(name = "num_adultosM")
	private Long numAdultosMulheres;
	
	@Column(name = "aceitacao_pidomSim")
	private Long aceitacaoPidomSim;
	
	@Column(name = "aceitacao_pidomNao")
	private Long aceitacaoPidomNao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_mobilizador")
	private Actor mobilizador;
	
	@ManyToOne
	@JoinColumn(name = "codigo_bairro")
	private Bairro bairro;
	
	@Transient
	private Localidade localidade;
	
	@Transient
	private Distrito distrito;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getNumEstElSensibilizadaSim() {
		return numEstElSensibilizadaSim;
	}

	public void setNumEstElSensibilizadaSim(Long numEstElSensibilizadaSim) {
		this.numEstElSensibilizadaSim = numEstElSensibilizadaSim;
	}

	public Long getNumEstElSensibilizadaNao() {
		return numEstElSensibilizadaNao;
	}

	public void setNumEstElSensibilizadaNao(Long numEstElSensibilizadaNao) {
		this.numEstElSensibilizadaNao = numEstElSensibilizadaNao;
	}

	public Long getNumAdultosHomens() {
		return numAdultosHomens;
	}

	public void setNumAdultosHomens(Long numAdultosHomens) {
		this.numAdultosHomens = numAdultosHomens;
	}

	public Long getNumAdultosMulheres() {
		return numAdultosMulheres;
	}

	public void setNumAdultosMulheres(Long numAdultosMulheres) {
		this.numAdultosMulheres = numAdultosMulheres;
	}

	public Long getAceitacaoPidomSim() {
		return aceitacaoPidomSim;
	}

	public void setAceitacaoPidomSim(Long aceitacaoPidomSim) {
		this.aceitacaoPidomSim = aceitacaoPidomSim;
	}

	public Long getAceitacaoPidomNao() {
		return aceitacaoPidomNao;
	}

	public void setAceitacaoPidomNao(Long aceitacaoPidomNao) {
		this.aceitacaoPidomNao = aceitacaoPidomNao;
	}

	
	public Actor getMobilizador() {
		return mobilizador;
	}

	public void setMobilizador(Actor mobilizador) {
		this.mobilizador = mobilizador;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TotaisMobilizacao other = (TotaisMobilizacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
