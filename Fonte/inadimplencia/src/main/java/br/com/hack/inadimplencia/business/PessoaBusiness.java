package br.com.hack.inadimplencia.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.inadimplencia.dao.PessoaDAO;
import br.com.hack.inadimplencia.entity.Pessoa;

@Service
public class PessoaBusiness {

	@Autowired
	private PessoaDAO pessoaDAO;
	public Pessoa obter(String cpf) {
		if(cpf != null){
			Pessoa pessoa = pessoaDAO.findByCpf(cpf);
			
			return pessoa;
		}
		return null;
	}

}
