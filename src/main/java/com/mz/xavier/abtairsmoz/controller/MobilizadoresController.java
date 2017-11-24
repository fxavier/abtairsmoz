/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.model.Mobilizador;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroMobilizadorException;
import com.mz.xavier.abtairsmoz.service.CadastroMobilizadorService;



/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/mobilizadores")
public class MobilizadoresController {
	
	@Autowired
	private CadastroMobilizadorService cadastroMobilizadorService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Mobilizador mobilizador) {
		ModelAndView mv = new ModelAndView("mobilizador/CadastroMobilizador");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Mobilizador mobilizador, 
			BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(mobilizador);
		}
		
		try {
			cadastroMobilizadorService.salvar(mobilizador);
		} catch(CadastroMobilizadorException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(mobilizador);
		}
		
		attributes.addFlashAttribute("mensagem","Mobilizador adicionado com sucesso");
		return new ModelAndView("redirect:/mobilizadores/novo");
	}
	

}
