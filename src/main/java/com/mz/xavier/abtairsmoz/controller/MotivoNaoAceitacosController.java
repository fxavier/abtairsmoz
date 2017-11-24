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

import com.mz.xavier.abtairsmoz.model.MotivoNaoAceitacao;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroMotivoNaoAceitacaoException;
import com.mz.xavier.abtairsmoz.service.CadastroMotivoNaoAceitacaoService;



/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/motivoNaoAceitacaos")
public class MotivoNaoAceitacosController {
	
	@Autowired
	private CadastroMotivoNaoAceitacaoService cadastroMotivoNaoAceitacaoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(MotivoNaoAceitacao motivoNaoAceitacao) {
		ModelAndView mv = new ModelAndView("motivo_nao_aceitacao/CadastroMotivoNaoAceitacao");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid MotivoNaoAceitacao motivoNaoAceitacao, BindingResult result,
			                 Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(motivoNaoAceitacao);
		}
		
		try {
			cadastroMotivoNaoAceitacaoService.salvar(motivoNaoAceitacao);
		}catch(CadastroMotivoNaoAceitacaoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(motivoNaoAceitacao);
		}
		
		attributes.addFlashAttribute("mensagem", "Motivo Nao aceitacao adicionado com sucesso");
		return new ModelAndView("redirect:/motivoNaoAceitacaos/novo");
	}

}
