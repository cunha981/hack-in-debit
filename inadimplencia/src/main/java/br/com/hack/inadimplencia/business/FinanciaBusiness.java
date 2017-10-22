package br.com.hack.inadimplencia.business;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hack.inadimplencia.dao.PessoaDAO;
import br.com.hack.inadimplencia.entity.Pessoa;
import br.com.hack.inadimplencia.entity.Proposta;

@Service
public class FinanciaBusiness {

	@Autowired
	private PessoaDAO pessoaDAO;

	public Proposta gerar(String cpf) {
		if (cpf != null) {
			Proposta proposta = new Proposta();

			Pessoa pessoa = pessoaDAO.findByCpf(cpf);
			if (pessoa != null) {
				proposta.setStatus(pessoa.getSituacao().toUpperCase());
				proposta.setCpf(pessoa.getCpf());

				Double saldoDisponivel = pessoa.getRenda() - pessoa.getValorGastoFixo();
				proposta.setPodePagar(true);
				proposta.setQuantoMaximo(round(saldoDisponivel*0.7,2));
				proposta.setQuantoMinimo(round(saldoDisponivel*0.2,2));
				return proposta;
			}
		}
		return null;
	}
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_EVEN);
	    return bd.doubleValue();
	}
	public void fecharAcordo(Integer parcelas, String cpf) {
		Pessoa pessoa = pessoaDAO.findByCpf(cpf);
		if(parcelas.equals(2)){
			pessoa.setValorGastoFixo(pessoa.getValorGastoFixo()+500);
		}else if(parcelas.equals(4)){
			pessoa.setValorGastoFixo(pessoa.getValorGastoFixo()+400);
		}else if(parcelas.equals(6)){
			pessoa.setValorGastoFixo(pessoa.getValorGastoFixo()+300);
		}else if(parcelas.equals(8)){
			pessoa.setValorGastoFixo(pessoa.getValorGastoFixo()+250);
		}
		pessoaDAO.save(pessoa);
	}
}
