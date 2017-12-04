/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.Bairro;
import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.filter.TotalTLDosFilter;

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
	
	public Page<TotaisTlDos> filtrar(TotalTLDosFilter filtro, Pageable pageable);
}
