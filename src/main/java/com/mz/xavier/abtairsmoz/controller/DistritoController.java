/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.controller.page.PageWrapper;
import com.mz.xavier.abtairsmoz.model.Distrito;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeDistritoException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;
import com.mz.xavier.abtairsmoz.repository.filter.DistritoFilter;
import com.mz.xavier.abtairsmoz.service.CadastroDistritoService;



/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/distritos")
public class DistritoController {
	
	@Autowired
	private CadastroDistritoService cadastroDistritoService;
	
	@Autowired
	private Distritos distritos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Distrito distrito) {
		ModelAndView mv = new ModelAndView("distrito/CadastroDistrito");
		return mv;
	}
	
	@RequestMapping(value = {"/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Distrito distrito, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(distrito);
		}
		
		try {
			cadastroDistritoService.salvar(distrito);
		} catch(CadastroNomeDistritoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(distrito);
		}
		
		attributes.addFlashAttribute("mensagem", "Distrito adicionado com sucesso");
		return new ModelAndView("redirect:/distritos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(DistritoFilter distritoFilter, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("distrito/PesquisaDistritos");
		PageWrapper<Distrito> pageWrapper = new PageWrapper<>(distritos.filtrar(distritoFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Long codigo) {
		Distrito distrito = distritos.findOne(codigo);
		ModelAndView mv = novo(distrito);
		mv.addObject(distrito);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo){
		try{
			cadastroDistritoService.excluir(codigo);
		} catch(ImpossivelExcluirEntidadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	

}



