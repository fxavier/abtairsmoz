/**
 * 
 */
package com.mz.xavier.abtairsmoz.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mz.xavier.abtairsmoz.controller.page.PageWrapper;
import com.mz.xavier.abtairsmoz.model.Actor;
import com.mz.xavier.abtairsmoz.model.Gender;
import com.mz.xavier.abtairsmoz.repository.ActorTypes;
import com.mz.xavier.abtairsmoz.repository.Actores;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeActorException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;
import com.mz.xavier.abtairsmoz.repository.filter.ActorFilter;
import com.mz.xavier.abtairsmoz.service.CadastroActorService;


/**
 * @author nhagumbeX
 *
 */
@Controller
@RequestMapping("/actores")
public class ActorsController {
	
	@Autowired 
	private CadastroActorService cadastroActorService;
	
	@Autowired
	private ActorTypes actorTypes;
	
	@Autowired
	private Actores actores;
	
	@Autowired
	private Distritos distritos;
	
		
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(Actor actor) {
		ModelAndView mv = new ModelAndView("actor/CadastroActor");
		mv.addObject("actorTypes", actorTypes.findAll());
		mv.addObject("sexos", Gender.values());
		mv.addObject("distritos", distritos.findAll());
		return mv;
	}
	
	@RequestMapping(value = { "/novo", "{//d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Actor actor, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()) {
			return novo(actor);
		}
		
		try {
			cadastroActorService.salvar(actor);
		} catch(CadastroNomeActorException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(actor);
		}
		
		attributes.addFlashAttribute("mensagem", "Actor adicionado com sucesso");
		return new ModelAndView("redirect:/actores/novo");
	}
	

	@GetMapping
	public ModelAndView pesquisar(ActorFilter actorFilter, BindingResult result, 
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("actor/PesquisaActores");
		mv.addObject("actorTypes", actorTypes.findAll());
		mv.addObject("sexos", Gender.values());
		mv.addObject("distritos", distritos.findAll());
		PageWrapper<Actor> pageWrapper = new PageWrapper<>(actores.filtrar(actorFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		
		return mv;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Actor> pesquisarPorCodigoTipoActor(
			@RequestParam(name = "actorType", defaultValue = "-1") Long codigoActorType){
		return actores.findByActorTypeCodigo(codigoActorType);
		
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Long codigo) {
		Actor actor = actores.buscarComDistrito(codigo);
		ModelAndView mv = novo(actor);
		mv.addObject(actor);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo){
		try{
			cadastroActorService.excluir(codigo);
		} catch(ImpossivelExcluirEntidadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
	

}
