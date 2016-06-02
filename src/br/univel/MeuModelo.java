package br.univel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MeuModelo extends AbstractTableModel {

	private List<Pessoa> lista;

	public MeuModelo(List<Pessoa> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();//quantidade de linhas
	}

	@Override
	public int getColumnCount() {
		return 3;//quantidade de atributos
	}



	@Override
	public String getColumnName(int column) {
		switch( column) {
		case 0:
			return "Código";
		case 1:
			return "Nome";
		case 2:
			return "Telefone";
		default:
			return super.getColumnName(column);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {//JTable chama esse metodo;

		Pessoa p = lista.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		case 2:
			return p.getTelefone();
		default:
			return "erro";
		}
	}
}
