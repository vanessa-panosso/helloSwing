package br.univel.print;

import java.util.List;

import br.univel.DaoPessoa;
import br.univel.Pessoa;
import net.sf.jasperreports.engine.JRDataSource;

public class PessoaDsFactory {//Serve para desenhar um relatorio

	public static JRDataSource criar(){
		DaoPessoa dao= new DaoPessoa();
		List<Pessoa>lista = dao.getPessoas();

		PessoaJRDataSource ds = new PessoaJRDataSource(lista);

		return ds;
	}
}
