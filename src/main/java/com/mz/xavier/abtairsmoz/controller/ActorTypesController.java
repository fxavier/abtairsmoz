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
import com.mz.xavier.abtairsmoz.model.ActorType;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroActorTypeException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;
import com.mz.xavier.abtairsmoz.repository.filter.ActorTypeFilter;
import com.mz.xavier.abtairsmoz.service.CadastroActorTypeService;

/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/actorTypes")
public class ActorTypesController {
	
	@Autowired
	private CadastroActorTypeService cadastroActorTypeService;
	
	@Autowired
	private ActorTypes actorTypes;
	
	@RequestMapping("/novo")
	public ModelAndView novo(ActorType actorType) {
		ModelAndView mv = new ModelAndView("actorType/CadastroTipoActor");
		return mv;
	}
	

	@GetMapping
	public ModelAndView pesquisar(ActorTypeFilter actorTypeFilter, BindingResult result, 
			@PageableDefault(size = 10) Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("actorType/PesquisaActorTypes");
		PageWrapper<ActorType> pageWrapper = new PageWrapper<>(actorTypes.filtrar(actorTypeFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	
	@RequestMapping(value = {"/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid ActorType actorType, BindingResult result
			                  , Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(actorType);
		}
		
		try {
			cadastroActorTypeService.salvar(actorType);
		}catch(CadastroActorTypeException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(actorType);
		}
		
		attributes.addFlashAttribute("mensagem", "Actor type cadastrado com sucesso!");
		return new ModelAndView("redirect:/actorTypes/novo");
		
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Long codigo) {
		ActorType actorType = actorTypes.findOne(codigo);
		ModelAndView mv = novo(actorType);
		mv.addObject(actorType);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo){
		try{
			cadastroActorTypeService.excluir(codigo);
		} catch(ImpossivelExcluirEntidadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
	

}
