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
import com.mz.xavier.abtairsmoz.model.Localidade;
import com.mz.xavier.abtairsmoz.repository.Distritos;
import com.mz.xavier.abtairsmoz.repository.Localidades;
import com.mz.xavier.abtairsmoz.repository.exception.CadastroNomeLocalidadeException;
import com.mz.xavier.abtairsmoz.repository.exception.ImpossivelExcluirEntidadeException;
import com.mz.xavier.abtairsmoz.repository.filter.LocalidadeFilter;
import com.mz.xavier.abtairsmoz.service.CadastroLocalidadeService;


/**
 * @author langar
 *
 */
@Controller
@RequestMapping("/localidades")
public class LocalidadesController {
	
	@Autowired 
	private CadastroLocalidadeService cadastroLocalidadeService;
	
	@Autowired
	private Distritos distritos;
	
	@Autowired
	private Localidades localidades;
	
	@RequestMapping("/nova")
	public ModelAndView novo(Localidade localidade) {
		ModelAndView mv = new ModelAndView("localidade/CadastroLocalidade");
		mv.addObject("distritos", distritos.findAll());
		return mv;
	}
	
	@RequestMapping(value = { "/nova", "{//d+}" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Localidade localidade, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()) {
			return novo(localidade);
		}
		
		try {
			cadastroLocalidadeService.salvar(localidade);
		} catch(CadastroNomeLocalidadeException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(localidade);
		}
		
		attributes.addFlashAttribute("mensagem", "Localidade adicionada com sucesso");
		return new ModelAndView("redirect:/localidades/nova");
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Localidade> pesquisarPorCodigoDistrito(
			@RequestParam(name = "distrito", defaultValue = "-1") Long codigoDistrito){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
			return localidades.findByDistritoCodigo(codigoDistrito);
	}
	
	@GetMapping
	public ModelAndView pesquisar(LocalidadeFilter localidadeFilter, BindingResult result, 
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("localidade/PesquisaLocalidades");
		mv.addObject("distritos", distritos.findAll());
		PageWrapper<Localidade> pageWrapper = new PageWrapper<>(localidades.filtrar(localidadeFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Long codigo) {
		Localidade localidade = localidades.buscarComDistrito(codigo);
		ModelAndView mv = novo(localidade);
		mv.addObject(localidade);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long codigo){
		try{
			cadastroLocalidadeService.excluir(codigo);
		} catch(ImpossivelExcluirEntidadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
	

}
