/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * @author langar
 *
 */
@Embeddable
public class TotalDosCalculado implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	@Column(name = "SOPMixFor75Sim")
	private Long sopMixFor75Sim;
	
	
	@Column(name = "SOPMixFor75Nao")
	private Long sopMixFor75Nao;
	
	
	@Column(name = "SOPEnxaugou3vezesSim")
	private Long sopEnxaugou3vezesSim;
	
	
	@Column(name = "SOPEnxaugou3vezesNao")
	private Long sopEnxaugou3vezesNao;
	
	
	@Column(name = "SOPTemEPICompletoSim")
	private Long sopTemEPICompletoSim;
	

	@Column(name = "SOPTemEPICompletoNao")
	private Long sopTemEPICompletoNao;
	
	
	@Column(name = "SOPPulvComBombaComCntFluxoSim")
	private Long sopPulvComBombaComCntFluxoSim;
	
	
	@Column(name = "SOPPulvComBombaComCntFluxoNao")
	private Long sopPulvComBombaComCntFluxoNao;
	
	
	@Column(name = "todosPertencesForaCasaSim")
	private Long todosPertencesForaCasaSim;
	
	
	@Column(name = "todosPertencesForaCasaNao")
	private Long todosPertencesForaCasaNao;
	
	
	@Column(name = "todosPertencesNTiradosCobertosSim")
	private Long todosPertencesNTiradosCobertosSim;
	
	
	@Column(name = "todosPertencesNTiradosCobertosNao")
	private Long todosPertencesNTiradosCobertosNao;
	
	@Column(name = "existeVazamentoBombaSim")
	private Long existeVazamentoBombaSim;
	
	
	@Column(name = "existeVazamentoBombaNao")
	private Long existeVazamentoBombaNao;
	
	
	@Column(name = "SOPPulvComDist45cmParedeSim")
	private Long sopPulvComDist45cmParedeSim;
	
	
	@Column(name = "SOPPulvComDist45cmParedeNao")
	private Long sopPulvComDist45cmParedeNao;
	
	
	@Column(name = "SOPMantemVelocCorrectaSim")
	private Long sopMantemVelocCorrectaSim;
	
	
	@Column(name = "SOPMantemVelocCorrectaNao")
	private Long sopMantemVelocCorrectaNao;
	
	
	@Column(name = "existeSubreposicao5cmSim")
	private Long existeSubreposicao5cmSim;
	
	
	@Column(name = "existeSubreposicao5cmNao")
	private Long existeSubreposicao5cmNao;

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
	
	

}
