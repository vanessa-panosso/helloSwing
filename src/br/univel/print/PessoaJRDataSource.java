package br.univel.print;

import java.util.Iterator;
import java.util.List;

import br.univel.Pessoa;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class PessoaJRDataSource implements JRDataSource {

	private List<Pessoa> lista;
	private Pessoa selecionado;
	private Iterator<Pessoa> iterator;
	public PessoaJRDataSource(List<Pessoa> lista) {

		this.lista = lista;
		this.iterator = lista.iterator();
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		if("id".equals(arg0.getName())){
			return selecionado.getId();

		}else if ("nome".equals(arg0.getName())){
			return selecionado.getNome();

		}else if (arg0.getName().equals("telefone")){
			return selecionado.getTelefone();
		}

		return "Undefined";
	}

	@Override
	public boolean next() throws JRException {
		if (iterator.hasNext()){
			selecionado = iterator.next();
			return true;
		}
		return false;
	}

}
