package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.print.PessoaJRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaPrincipal extends JFrame {


	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaPrincipal tp = new TelaPrincipal();// instancia a janela
				tp.setSize(800, 600);//tamanho da tela
				tp.setLocationRelativeTo(null); // centraliza no meio da tela
				tp.setVisible(true);// mostra a janela
			}
		});

	}


	public TelaPrincipal() {
		JPanel jp = new JPanel();//craindo um painel
		jp.setLayout(new BorderLayout());// objeto que gerencia

		JScrollPane jsc = new JScrollPane();// painel barra de rolagem
		table = new JTable();
		jsc.setViewportView(table);//criar automatico pelo tamaho
		jp.add(jsc, BorderLayout.CENTER);//adiciona no centro do painel
		{
		JButton button = new JButton("Carregar");// criar botao
		jp.add(button, BorderLayout.NORTH);// adicionar no norte do painel

		setContentPane(jp);//painel do conteudo

		button.addActionListener(new ActionListener() {//passando classe anonimo

			@Override
			public void actionPerformed(ActionEvent e) {
				carregar();
			}
		});
		}
		{
		JButton button = new JButton("Imprimir");// criar botao
		jp.add(button, BorderLayout.SOUTH);// adicionar no norte do painel

		setContentPane(jp);//painel do conteudo

		button.addActionListener(new ActionListener() {//passando classe anonimo

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					imprimir();
				} catch (JRException e1) {
					e1.printStackTrace();
				}
			}

			private void imprimir() throws JRException {
				String arq = "pessoa_report.jasper";

				DaoPessoa dao = new DaoPessoa();
				PessoaJRDataSource ds = new PessoaJRDataSource(dao.getPessoas());

				JasperPrint jp = JasperFillManager.fillReport(arq, null, ds);

				JasperViewer jasperViewer = new JasperViewer(jp);

				jasperViewer.setBounds(50, 50, 320, 240);
				jasperViewer.setLocationRelativeTo(null);
				jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);

				jasperViewer.setVisible(true);
			}
		});
		}

	}


	protected void carregar() {

		DaoPessoa dao = new DaoPessoa();//busca os dados no banco
		List<Pessoa> lista = dao.getPessoas();

		MeuModelo meuModelo = new MeuModelo(lista);//instanciado um modelo para tabela, modelo: o que será ixibido

		table.setModel(meuModelo);//passa o modelo (dados) para a visão

	}

}
