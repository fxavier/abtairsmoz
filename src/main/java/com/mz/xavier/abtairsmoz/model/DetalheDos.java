/**
 * 
 */
package com.mz.xavier.abtairsmoz.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



/**
 * @author langar
 *
 */
@Entity
@Table(name = "detalhes_tldos")
public class DetalheDos implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String UUID;
	
	@Column(name = "codigo_totalDos")
	private Long codigoTotalDos;
	
	@NotNull(message = "A data é obrigatória")
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name = "codigo_distrito")
	@NotNull(message = "O distrito é obrigatório")
	private Distrito distrito;
	
	@ManyToOne
	@JoinColumn(name = "codigo_localidade")
	@NotNull(message = "A Localidade é obrigatória")
	private Localidade localidade;
	
	/*@Transient
	@NotNull(message = "O tipo do lider é obrigatório")
	private ActorType actorType;
	*/
	
	@ManyToOne
	@JoinColumn(name = "codigo_tlOusupBrigada")
	@NotNull(message = "O Nome do lider é obrigatório")
	private Actor teamLeaderOuChefeBrigada;

	
	@ManyToOne
	@JoinColumn(name = "codigo_bairro")
	@NotNull(message = "O Bairro é obrigatório")
	private Bairro bairro;
	
	@Column(name = "SOPMixFor75")
	@NotNull(message = "Todos os campos sao obrigatorios")
	
	private String sopMixFor75;
	
	@Column(name = "SOPEnxaugou3vezes")
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String sopEnxaugou3vezes;
	
	@Column(name = "SOPTemEPICompleto")
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String sopTemEPICompleto;
	
	@Column(name = "SOPPulvComBombaComCntFluxo")
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String sopPulvComBombaComCntFluxo;	

	@NotNull(message = "Todos os campos sao obrigatorios")
	private String todosPertencesForaCasa;	

	@NotNull(message = "Todos os campos sao obrigatorios")
	private String todosPertencesNTiradosCobertos;
	
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String existeVazamentoBomba;
	
	@Column(name = "SOPPulvComDist45cmParede")
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String sopPulvComDist45cmParede;
	
	@Column(name = "SOPMantemVelocCorrecta")
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String sopMantemVelocCorrecta;
	
	@NotNull(message = "Todos os campos sao obrigatorios")
	private String existeSubreposicao5cm;
	
	@Embedded
	private TotalDosCalculado totalDosCalculado;
	
		
	@ManyToOne
	@JoinColumn(name = "codigo_roceador")
	private Actor roceador;
	

	public String getUUID() {
		return UUID;
	}
	

	public LocalDate getData() {
		return data;
	}




	public void setData(LocalDate data) {
		this.data = data;
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

    

	public Actor getTeamLeaderOuChefeBrigada() {
		return teamLeaderOuChefeBrigada;
	}


	public void setTeamLeaderOuChefeBrigada(Actor teamLeaderOuChefeBrigada) {
		this.teamLeaderOuChefeBrigada = teamLeaderOuChefeBrigada;
	}


	public Bairro getBairro() {
		return bairro;
	}




	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}




	public TotalDosCalculado getTotalDosCalculado() {
		return totalDosCalculado;
	}




	public void setTotalDosCalculado(TotalDosCalculado totalDosCalculado) {
		this.totalDosCalculado = totalDosCalculado;
	}




	public Long getCodigoTotalDos() {
		return codigoTotalDos;
	}


	public void setCodigoTotalDos(Long codigoTotalDos) {
		this.codigoTotalDos = codigoTotalDos;
	}



	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
    
	public String getSopMixFor75() {
		return sopMixFor75;
	}


    
	public void setSopMixFor75(String sopMixFor75) {
		this.sopMixFor75 = sopMixFor75;
	}

	public String getSopEnxaugou3vezes() {
		return sopEnxaugou3vezes;
	}

	public void setSopEnxaugou3vezes(String sopEnxaugou3vezes) {
		this.sopEnxaugou3vezes = sopEnxaugou3vezes;
	}

	public String getSopTemEPICompleto() {
		return sopTemEPICompleto;
	}

	public void setSopTemEPICompleto(String sopTemEPICompleto) {
		this.sopTemEPICompleto = sopTemEPICompleto;
	}

	public String getSopPulvComBombaComCntFluxo() {
		return sopPulvComBombaComCntFluxo;
	}

	public void setSopPulvComBombaComCntFluxo(String sopPulvComBombaComCntFluxo) {
		this.sopPulvComBombaComCntFluxo = sopPulvComBombaComCntFluxo;
	}

	public String getTodosPertencesForaCasa() {
		return todosPertencesForaCasa;
	}

	public void setTodosPertencesForaCasa(String todosPertencesForaCasa) {
		this.todosPertencesForaCasa = todosPertencesForaCasa;
	}

	public String getTodosPertencesNTiradosCobertos() {
		return todosPertencesNTiradosCobertos;
	}

	public void setTodosPertencesNTiradosCobertos(String todosPertencesNTiradosCobertos) {
		this.todosPertencesNTiradosCobertos = todosPertencesNTiradosCobertos;
	}

	public String getExisteVazamentoBomba() {
		return existeVazamentoBomba;
	}

	public void setExisteVazamentoBomba(String existeVazamentoBomba) {
		this.existeVazamentoBomba = existeVazamentoBomba;
	}

	public String getSopPulvComDist45cmParede() {
		return sopPulvComDist45cmParede;
	}

	public void setSopPulvComDist45cmParede(String sopPulvComDist45cmParede) {
		this.sopPulvComDist45cmParede = sopPulvComDist45cmParede;
	}

	public String getSopMantemVelocCorrecta() {
		return sopMantemVelocCorrecta;
	}

	public void setSopMantemVelocCorrecta(String sopMantemVelocCorrecta) {
		this.sopMantemVelocCorrecta = sopMantemVelocCorrecta;
	}

	public String getExisteSubreposicao5cm() {
		return existeSubreposicao5cm;
	}

	public void setExisteSubreposicao5cm(String existeSubreposicao5cm) {
		this.existeSubreposicao5cm = existeSubreposicao5cm;
	}
	
	
	
	
	public Actor getRoceador() {
		return roceador;
	}

	public void setRoceador(Actor roceador) {
		this.roceador = roceador;
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
		DetalheDos other = (DetalheDos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
