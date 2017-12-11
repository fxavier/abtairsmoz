/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.controller.page.PageWrapper;
import com.mz.xavier.abtairsmoz.dto.AlertasVermelhas;
import com.mz.xavier.abtairsmoz.dto.AlertasVermelhasDistrito;
import com.mz.xavier.abtairsmoz.dto.SupervisoesPorMes;
import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.Actores;
import com.mz.xavier.abtairsmoz.repository.Bairros;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.Localidades;
import com.mz.xavier.abtairsmoz.repository.TotalTLDoses;
import com.mz.xavier.abtairsmoz.repository.filter.TotalTLDosFilter;
import com.mz.xavier.abtairsmoz.service.CadastroTotalDosService;
import com.mz.xavier.abtairsmoz.service.exception.CadastroTotaisException;


/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/totaisDos")
public class TotaisDosController {

	
	@Autowired
	private CadastroTotalDosService totalDosService;

	@Autowired
	private Distritos distritos;

	@Autowired
	private ActorTypes actorTypes;
	
	@Autowired
	private Actores actores;
	
	@Autowired
	private Localidades localidades;
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private TotalTLDoses totalDoses;

	@RequestMapping("/novo")
	public ModelAndView novo(TotaisTlDos totaisTlDos) {
		   ModelAndView mv = new ModelAndView("dos/CadastroTotaisTLDos");
	       mv.addObject("distritos", distritos.findAll());
		   mv.addObject("actorTypes", actorTypes.listarPorBSTL());
		   return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid TotaisTlDos totaisTlDos, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(totaisTlDos);
		}

		totaisTlDos.setUUID(UUID.randomUUID().toString());
		totaisTlDos.setReferencia(totaisTlDos.getData()+totaisTlDos.getBairro().getNome()+totaisTlDos.getTeamLeaderOuChefeBrigada().getNome());
		try {
		totalDosService.salvar(totaisTlDos);
		}catch(CadastroTotaisException e) {
			result.rejectValue("referencia", e.getMessage(), e.getMessage());
			return novo(totaisTlDos);
		}
		attributes.addFlashAttribute("mensagem", "Totais salvos com sucesso");
		return new ModelAndView("redirect:/totaisDos/novo");
	}
	
	
	@GetMapping
	public ModelAndView pesquisar(TotalTLDosFilter totalTLDosFilter, BindingResult result, 
			 @PageableDefault(size = 100) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("dos/PesquisaTotaisDos");
		 mv.addObject("actores", actores.listarSupervisores());
		 mv.addObject("distritos", distritos.findAll());
		 mv.addObject("actorTypes", actorTypes.listarPorBSTL());
		 mv.addObject("localidades", localidades.findAll());
		 mv.addObject("bairros", bairros.findAll());
		 PageWrapper<TotaisTlDos> pageWrapper = new PageWrapper<>(totalDoses.filtrar(totalTLDosFilter, pageable),
				 httpServletRequest);
		 mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		TotaisTlDos totaisTlDos = totalDoses.findOne(codigo);
		ModelAndView mv = novo(totaisTlDos);
		mv.addObject(totaisTlDos);
		return mv;
	}
	
	@GetMapping("/porDistrito")
	public @ResponseBody List<AlertasVermelhasDistrito> alertasVermelhasPorDistrito(){
		return totalDoses.totalPorDistrito();
	}
	
	@GetMapping("/porIndicador")
	public @ResponseBody List<AlertasVermelhas> alertasVermelhasPorIndicador(){
		return totalDoses.totalPorIndicador();
	}
	
	@GetMapping("/porSupervisao")
	public @ResponseBody List<SupervisoesPorMes> supervisoesPorMes(){
		return totalDoses.totalPorSupervisao();
	}
 
}
