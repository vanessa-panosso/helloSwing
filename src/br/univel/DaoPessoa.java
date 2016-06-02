package br.univel;

import java.util.ArrayList;
import java.util.List;

public class DaoPessoa {
	/**
	 * Faz de conta que vai no banco e busca todos
	 * os registros, mas na verdade, está somente
	 * instanciando. Quem chama não vê a diferença.
	 * @return
	 */
	public List<Pessoa> getPessoas() {
		List<Pessoa> lista = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			Pessoa p = new Pessoa(i, "Nome " + i, "Telefone " + i);
			lista.add(p);
		}

		return lista;
	}

}
