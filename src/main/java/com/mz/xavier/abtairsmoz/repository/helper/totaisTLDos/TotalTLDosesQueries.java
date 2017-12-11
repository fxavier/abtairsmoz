/**
 * 
 */
package com.mz.xavier.abtairsmoz.repository.helper.totaisTLDos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mz.xavier.abtairsmoz.dto.AlertasVermelhas;
import com.mz.xavier.abtairsmoz.dto.AlertasVermelhasDistrito;
import com.mz.xavier.abtairsmoz.dto.SupervisoesPorMes;
import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.DetalheDos;
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
		
	public Optional<TotaisTlDos> obterUmTotal(DetalheDos dDos);
	
	public TotaisTlDos buscarComRelacionamentos(Long codigo);
	
	public Page<TotaisTlDos> filtrar(TotalTLDosFilter filtro, Pageable pageable);
	
	public List<AlertasVermelhasDistrito> totalPorDistrito();
	
	public List<AlertasVermelhas> totalPorIndicador();
	
	public List<SupervisoesPorMes> totalPorSupervisao();
}
