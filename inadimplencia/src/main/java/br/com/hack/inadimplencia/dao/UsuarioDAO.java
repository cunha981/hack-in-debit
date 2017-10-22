package br.com.hack.inadimplencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hack.inadimplencia.entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	Usuario findByCpf(String cpf);

}
