package br.com.hack.inadimplencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hack.inadimplencia.business.FinanciaBusiness;
import br.com.hack.inadimplencia.business.LoginBusiness;
import br.com.hack.inadimplencia.business.PessoaBusiness;
import br.com.hack.inadimplencia.entity.Pessoa;
import br.com.hack.inadimplencia.entity.Usuario;

@Controller
public class ViewController {
	@Autowired
	private LoginBusiness loginBusiness;
	
	@Autowired
	private PessoaBusiness pessoaBusiness;
	
	@Autowired
	private FinanciaBusiness financiaBusiness;
	@RequestMapping("/login")
	public String login(){
		return "acesso";
	}
	@RequestMapping("/autenticar")
	public String autenticar(String cpf, String senha, RedirectAttributes redirectAttrs){
		Usuario usuario = loginBusiness.autenticar(cpf, senha);
		if(usuario!=null){
			redirectAttrs.addAttribute("cpf", usuario.getCpf());
			return "redirect:/planejamento";
		}
		return "redirect:/login";
	}
	@RequestMapping("/cadastro")
	public String cadastro(){
		return "cadastro";
	}
	@RequestMapping("/index")
	public String index(String cpf, Model model){
		Pessoa pessoa = pessoaBusiness.obter(cpf);
		model.addAttribute("pessoa", pessoa);
		return "index";
	}
	@RequestMapping("/acordo")
	public String acordo(){
		return "acordo";
	}
	@RequestMapping("/planejamento")
	public String planejamento(String cpf, Model model){
		if(cpf==null)cpf="42016714883";
		//Pessoa pessoa = pessoaBusiness.obter(cpf);
		model.addAttribute("cpf", cpf);	
		return "planejamento";
	}
	@RequestMapping("/negociar")
	public String fecharAcordo(Integer parcelas, String cpf, RedirectAttributes redirectAttrs){
		financiaBusiness.fecharAcordo(parcelas, cpf);
		
		redirectAttrs.addAttribute("cpf", cpf);
		return "redirect:/planejamento";
	}
}
