package br.com.hack.inadimplencia.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.inadimplencia.dao.UsuarioDAO;
import br.com.hack.inadimplencia.entity.Usuario;

@Service
public class LoginBusiness {
	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario autenticar(String cpf, String senha) {

		Boolean autenticado;

		Usuario usuario = usuarioDAO.findByCpf(cpf);
		if (usuario != null) {
			autenticado = (senha.equals(usuario.getSenha()) ? true : false);
			if (autenticado) {
				return usuario;
			}
		}
		return null;
	}

	public Usuario cadastrar(Usuario usuario) {
		if(usuario != null){
			return usuarioDAO.save(usuario);
		}
		return usuario;
	}
}
