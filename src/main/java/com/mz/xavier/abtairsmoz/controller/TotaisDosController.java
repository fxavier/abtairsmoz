/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.model.TotaisTlDos;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.service.CadastroTotalTLService;

/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/totaisDos")
public class TotaisDosController {

	
	@Autowired
	private CadastroTotalTLService totalDosService;

	@Autowired
	private Distritos distritos;

	@Autowired
	private ActorTypes actorTypes;

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
		totalDosService.salvar(totaisTlDos);
		attributes.addFlashAttribute("Mensagem", "Totais salvos com sucesso");
		return new ModelAndView("redirect:/totaisDos/novo");
	}

}
