package com.mz.xavier.abtairsmoz.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mz.xavier.abtairsmoz.dto.PeriodoRelatorio;
import com.mz.xavier.abtairsmoz.repository.Distritos;





@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {
	
	@Autowired
	private Distritos distritos;
		
	@GetMapping("/alertasVermelhas")
	public ModelAndView relatorioVendasEmitidas() {
		ModelAndView mv = new ModelAndView("relatorio/RelatorioAlertasVermelhas");
		mv.addObject("distritos", distritos.findAll());
		mv.addObject(new PeriodoRelatorio());
		return mv;
	}
	
	@PostMapping("/alertasVermelhas")
	public ModelAndView gerarRelatorioAlertasVermelhas(PeriodoRelatorio periodoRelatorio) {
		Map<String, Object> parametros = new HashMap<>();
		
		Date dataInicio = Date.from(LocalDateTime.of(periodoRelatorio.getDataInicio(), LocalTime.of(0, 0, 0))
				.atZone(ZoneId.systemDefault()).toInstant());
		Date dataFim = Date.from(LocalDateTime.of(periodoRelatorio.getDataFim(), LocalTime.of(23, 59, 59))
				.atZone(ZoneId.systemDefault()).toInstant());
		
				
		String distrito = periodoRelatorio.getDistrito();
		
		parametros.put("format", "pdf");
		parametros.put("data_inicio", dataInicio);
		parametros.put("data_fim", dataFim);
		parametros.put("distrito", distrito);
	
		
		return new ModelAndView("relatorio_alertas_vermelhas_distrito", parametros);
	}

}
