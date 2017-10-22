package br.com.hack.inadimplencia.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hack.inadimplencia.business.FinanciaBusiness;
import br.com.hack.inadimplencia.business.LoginBusiness;
import br.com.hack.inadimplencia.business.PessoaBusiness;
import br.com.hack.inadimplencia.entity.Pessoa;
import br.com.hack.inadimplencia.entity.Proposta;
import br.com.hack.inadimplencia.entity.Usuario;

@RestController
public class ResourceController {
	@Autowired
	private LoginBusiness loginBusiness;
	
	@Autowired
	private PessoaBusiness pessoaBusiness;
	@Autowired
	private FinanciaBusiness financiaBusiness;
	
	/*@PostMapping("/login/{cpf}/{senha}/")
	public ResponseEntity<Usuario> login(@PathVariable String cpf, @PathVariable String senha){
		Usuario usuario = loginBusiness.autenticar(cpf, senha);
		
		if(usuario != null)
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.BAD_REQUEST);
	}*/
	/*@PostMapping("/cadastro")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		usuario = loginBusiness.cadastrar(usuario);
		
		if(usuario != null)
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.BAD_REQUEST);
	}*/
	@PostMapping("/gastos/{cpf}/")
	public ResponseEntity<Pessoa> gastos(@PathVariable String cpf){
		Pessoa pessoa = pessoaBusiness.obter(cpf);
		if(pessoa != null)
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/ws/{cpf}")
	public ResponseEntity<Proposta> apiAcordo(@PathVariable String cpf){
		Proposta proposta = financiaBusiness.gerar(cpf);
		if(proposta != null)
			return new ResponseEntity<Proposta>(proposta, HttpStatus.OK);
		return new ResponseEntity<Proposta>(proposta, HttpStatus.BAD_REQUEST);
	}
	
}
