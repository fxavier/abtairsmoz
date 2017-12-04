/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
* @author langar
 *
 */
@Entity
@Table(name = "totais_tldos")
public class TotaisTlDos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String UUID;
	
	@NotNull(message = "A data é obrigatória")
	private LocalDate data;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPMixFor75Sim")
	private Long sopMixFor75Sim;
	
	@NotNull(message = "Esse campo é obrigatório")	
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPMixFor75Nao")
	private Long sopMixFor75Nao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPEnxaugou3vezesSim")
	private Long sopEnxaugou3vezesSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPEnxaugou3vezesNao")
	private Long sopEnxaugou3vezesNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPTemEPICompletoSim")
	private Long sopTemEPICompletoSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPTemEPICompletoNao")
	private Long sopTemEPICompletoNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPPulvComBombaComCntFluxoSim")
	private Long sopPulvComBombaComCntFluxoSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPPulvComBombaComCntFluxoNao")
	private Long sopPulvComBombaComCntFluxoNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "todosPertencesForaCasaSim")
	private Long todosPertencesForaCasaSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "todosPertencesForaCasaNao")
	private Long todosPertencesForaCasaNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "todosPertencesNTiradosCobertosSim")
	private Long todosPertencesNTiradosCobertosSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "todosPertencesNTiradosCobertosNao")
	private Long todosPertencesNTiradosCobertosNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "existeVazamentoBombaSim")
	private Long existeVazamentoBombaSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "existeVazamentoBombaNao")
	private Long existeVazamentoBombaNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPPulvComDist45cmParedeSim")
	private Long sopPulvComDist45cmParedeSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPPulvComDist45cmParedeNao")
	private Long sopPulvComDist45cmParedeNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPMantemVelocCorrectaSim")
	private Long sopMantemVelocCorrectaSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "SOPMantemVelocCorrectaNao")
	private Long sopMantemVelocCorrectaNao;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "existeSubreposicao5cmSim")
	private Long existeSubreposicao5cmSim;
	
	@NotNull(message = "Esse campo é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(name = "existeSubreposicao5cmNao")
	private Long existeSubreposicao5cmNao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_tlOusupBrigada")
	@NotNull(message = "O Nome do lider é obrigatório")
	private Actor teamLeaderOuChefeBrigada;
	
	@ManyToOne
	@JoinColumn(name = "codigo_distrito")
	@NotNull(message = "O distrito é obrigatório")
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "codigo_localidade")
	@NotNull(message = "A Localidade é obrigatória")
	private Localidade localidade;
	
	@Transient
	@NotNull(message = "O tipo do lider é obrigatório")
	private ActorType actorType;
	
	@ManyToOne
	@JoinColumn(name = "codigo_bairro")
	@NotNull(message = "O Bairro é obrigatório")
	private Bairro bairro;

	public Long getCodigo() {
		return codigo;
	}
	
    
	public String getUUID() {
		return UUID;
	}


	public void setUUID(String uUID) {
		UUID = uUID;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getSopMixFor75Sim() {
		return sopMixFor75Sim;
	}

	public void setSopMixFor75Sim(Long sopMixFor75Sim) {
		this.sopMixFor75Sim = sopMixFor75Sim;
	}

	public Long getSopMixFor75Nao() {
		return sopMixFor75Nao;
	}

	public void setSopMixFor75Nao(Long sopMixFor75Nao) {
		this.sopMixFor75Nao = sopMixFor75Nao;
	}

	public Long getSopEnxaugou3vezesSim() {
		return sopEnxaugou3vezesSim;
	}

	public void setSopEnxaugou3vezesSim(Long sopEnxaugou3vezesSim) {
		this.sopEnxaugou3vezesSim = sopEnxaugou3vezesSim;
	}

	public Long getSopEnxaugou3vezesNao() {
		return sopEnxaugou3vezesNao;
	}

	public void setSopEnxaugou3vezesNao(Long sopEnxaugou3vezesNao) {
		this.sopEnxaugou3vezesNao = sopEnxaugou3vezesNao;
	}

	public Long getSopTemEPICompletoSim() {
		return sopTemEPICompletoSim;
	}

	public void setSopTemEPICompletoSim(Long sopTemEPICompletoSim) {
		this.sopTemEPICompletoSim = sopTemEPICompletoSim;
	}

	public Long getSopTemEPICompletoNao() {
		return sopTemEPICompletoNao;
	}

	public void setSopTemEPICompletoNao(Long sopTemEPICompletoNao) {
		this.sopTemEPICompletoNao = sopTemEPICompletoNao;
	}

	public Long getSopPulvComBombaComCntFluxoSim() {
		return sopPulvComBombaComCntFluxoSim;
	}

	public void setSopPulvComBombaComCntFluxoSim(Long sopPulvComBombaComCntFluxoSim) {
		this.sopPulvComBombaComCntFluxoSim = sopPulvComBombaComCntFluxoSim;
	}

	public Long getSopPulvComBombaComCntFluxoNao() {
		return sopPulvComBombaComCntFluxoNao;
	}

	public void setSopPulvComBombaComCntFluxoNao(Long sopPulvComBombaComCntFluxoNao) {
		this.sopPulvComBombaComCntFluxoNao = sopPulvComBombaComCntFluxoNao;
	}

	public Long getTodosPertencesForaCasaSim() {
		return todosPertencesForaCasaSim;
	}

	public void setTodosPertencesForaCasaSim(Long todosPertencesForaCasaSim) {
		this.todosPertencesForaCasaSim = todosPertencesForaCasaSim;
	}

	public Long getTodosPertencesForaCasaNao() {
		return todosPertencesForaCasaNao;
	}

	public void setTodosPertencesForaCasaNao(Long todosPertencesForaCasaNao) {
		this.todosPertencesForaCasaNao = todosPertencesForaCasaNao;
	}

	public Long getTodosPertencesNTiradosCobertosSim() {
		return todosPertencesNTiradosCobertosSim;
	}

	public void setTodosPertencesNTiradosCobertosSim(Long todosPertencesNTiradosCobertosSim) {
		this.todosPertencesNTiradosCobertosSim = todosPertencesNTiradosCobertosSim;
	}

	public Long getTodosPertencesNTiradosCobertosNao() {
		return todosPertencesNTiradosCobertosNao;
	}

	public void setTodosPertencesNTiradosCobertosNao(Long todosPertencesNTiradosCobertosNao) {
		this.todosPertencesNTiradosCobertosNao = todosPertencesNTiradosCobertosNao;
	}

	public Long getExisteVazamentoBombaSim() {
		return existeVazamentoBombaSim;
	}

	public void setExisteVazamentoBombaSim(Long existeVazamentoBombaSim) {
		this.existeVazamentoBombaSim = existeVazamentoBombaSim;
	}

	public Long getExisteVazamentoBombaNao() {
		return existeVazamentoBombaNao;
	}

	public void setExisteVazamentoBombaNao(Long existeVazamentoBombaNao) {
		this.existeVazamentoBombaNao = existeVazamentoBombaNao;
	}

	public Long getSopPulvComDist45cmParedeSim() {
		return sopPulvComDist45cmParedeSim;
	}

	public void setSopPulvComDist45cmParedeSim(Long sopPulvComDist45cmParedeSim) {
		this.sopPulvComDist45cmParedeSim = sopPulvComDist45cmParedeSim;
	}

	public Long getSopPulvComDist45cmParedeNao() {
		return sopPulvComDist45cmParedeNao;
	}

	public void setSopPulvComDist45cmParedeNao(Long sopPulvComDist45cmParedeNao) {
		this.sopPulvComDist45cmParedeNao = sopPulvComDist45cmParedeNao;
	}

	public Long getSopMantemVelocCorrectaSim() {
		return sopMantemVelocCorrectaSim;
	}

	public void setSopMantemVelocCorrectaSim(Long sopMantemVelocCorrectaSim) {
		this.sopMantemVelocCorrectaSim = sopMantemVelocCorrectaSim;
	}

	public Long getSopMantemVelocCorrectaNao() {
		return sopMantemVelocCorrectaNao;
	}

	public void setSopMantemVelocCorrectaNao(Long sopMantemVelocCorrectaNao) {
		this.sopMantemVelocCorrectaNao = sopMantemVelocCorrectaNao;
	}

	public Long getExisteSubreposicao5cmSim() {
		return existeSubreposicao5cmSim;
	}

	public void setExisteSubreposicao5cmSim(Long existeSubreposicao5cmSim) {
		this.existeSubreposicao5cmSim = existeSubreposicao5cmSim;
	}

	public Long getExisteSubreposicao5cmNao() {
		return existeSubreposicao5cmNao;
	}

	public void setExisteSubreposicao5cmNao(Long existeSubreposicao5cmNao) {
		this.existeSubreposicao5cmNao = existeSubreposicao5cmNao;
	}

	public Actor getTeamLeaderOuChefeBrigada() {
		return teamLeaderOuChefeBrigada;
	}

	public void setTeamLeaderOuChefeBrigada(Actor teamLeaderOuChefeBrigada) {
		this.teamLeaderOuChefeBrigada = teamLeaderOuChefeBrigada;
	}

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
		TotaisTlDos other = (TotaisTlDos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
