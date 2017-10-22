package br.com.hack.inadimplencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hack.inadimplencia.entity.Pessoa;

public interface PessoaDAO extends JpaRepository<Pessoa, Integer> {

	Pessoa findByCpf(String cpf);

}
