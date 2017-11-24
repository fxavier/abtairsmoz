/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos;

import java.time.LocalDate;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.Bairro;

/**
 * @author langar
 *
 */
public interface TotalTLDosesQueries {
	
	public String findLastUUID();

	public Long findUltmoBairro();

	public LocalDate findUltimaData();

	public Actor findUltimoBSTL();
	
	public Long findLastCodigo();
	public Long obtrCodigoTotalDoses(LocalDate data, Bairro bairro);
}
