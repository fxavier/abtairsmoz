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

/**
 * @author langar
 *
 */
@Entity
@Table(name = "detalhes_mobilizacao")
public class DetalhesMobilizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private LocalDateTime data;
	
	@Column(name = "nome_familia")
	private String nomeFamilia;
	
	@Column(name = "codigo_pidom")
	private String codigoPidom;
	
    @Column(name = "est_el_sensibilizada")
	private String estEligSensibilizada;
	
    @ManyToOne
    @JoinColumn(name = "motivo_nao_sensibilizacao")
	private Motivo motivo;
	
	@Column(name = "num_adultosH")
	private Long numAdultosHomens;
	
	@Column(name = "num_adultosM")
	private Long numAdultosMulheres;
	
	@ManyToOne
	@JoinColumn(name = "motivo_nao_aceitacao")
	private MotivoNaoAceitacao motivoNaoAceitacao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_mobilizador")
	private Mobilizador mobilizador;
	
	@ManyToOne
	@JoinColumn(name = "codigo_bairro")
	private Bairro birro;

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

	public String getNomeFamilia() {
		return nomeFamilia;
	}

	public void setNomeFamilia(String nomeFamilia) {
		this.nomeFamilia = nomeFamilia;
	}

	public String getCodigoPidom() {
		return codigoPidom;
	}

	public void setCodigoPidom(String codigoPidom) {
		this.codigoPidom = codigoPidom;
	}

	public String getEstEligSensibilizada() {
		return estEligSensibilizada;
	}

	public void setEstEligSensibilizada(String estEligSensibilizada) {
		this.estEligSensibilizada = estEligSensibilizada;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
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

	public MotivoNaoAceitacao getMotivoNaoAceitacao() {
		return motivoNaoAceitacao;
	}

	public void setMotivoNaoAceitacao(MotivoNaoAceitacao motivoNaoAceitacao) {
		this.motivoNaoAceitacao = motivoNaoAceitacao;
	}

	public Mobilizador getMobilizador() {
		return mobilizador;
	}

	public void setMobilizador(Mobilizador mobilizador) {
		this.mobilizador = mobilizador;
	}

	public Bairro getBirro() {
		return birro;
	}

	public void setBirro(Bairro birro) {
		this.birro = birro;
	}
	
	

}
