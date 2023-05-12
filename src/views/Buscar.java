package views;

import controller.HospedesController;
import controller.ReservasController;
import modelo.Hospede;
import modelo.Reserva;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private JLabel labelAtras;
	private JLabel labelExit;
	private ReservasController reservasController;
	private HospedesController hospedesController;
	int xMouse, yMouse;

	public Buscar() {
		reservasController = new ReservasController();
		hospedesController = new HospedesController();
		inicializarViewBuscar();
	}

	private void inicializarViewBuscar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/resources/imagens/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitulo.setBounds(331, 62, 280, 42);
		contentPane.add(lblTitulo);

		var panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pagamento");

		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/resources/imagens/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);

		tbHospedes = new JTable();
		tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");


		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
		panel.addTab("Hóspedes", new ImageIcon(Buscar.class.getResource("/resources/imagens/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Buscar.class.getResource("/resources/imagens/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) { //Quando o usuário remove o mouse do botão, ele retornará ao estado original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnBuscar = new JPanel();
		btnBuscar.setLayout(null);
		btnBuscar.setBackground(new Color(12, 138, 199));
		btnBuscar.setBounds(748, 125, 122, 35);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qualTabelaFoiSelecionada = panel.getSelectedIndex();

				if (qualTabelaFoiSelecionada == 0) {
					removendoDadosTabela(modelo);
					dadosReservaPesquisado();

				} else if (qualTabelaFoiSelecionada == 1) {
					removendoDadosTabela(modeloHospedes);
					dadosHospedePesquisado();
				}
			}
		});
		contentPane.add(btnBuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnBuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnMostrar = new JPanel();
		btnMostrar.setLayout(null);
		btnMostrar.setBackground(new Color(12, 138, 199));
		btnMostrar.setBounds(503, 508, 122, 35);
		btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qualTabelaFoiSelecionada = panel.getSelectedIndex();

				if (qualTabelaFoiSelecionada == 0) {
					removendoDadosTabela(modelo);
					preencherDadosTabelaReservas();

				} else if (qualTabelaFoiSelecionada == 1) {
					removendoDadosTabela(modeloHospedes);
					preencherDadosTabelaHospedes();
				}
			}
		});

		contentPane.add(btnMostrar);

		JLabel lblMostrar = new JLabel("MOSTRAR");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblMostrar.setBounds(0, 0, 122, 35);
		btnMostrar.add(lblMostrar);

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qualTabelaFoiSelecionada = panel.getSelectedIndex();

				if (qualTabelaFoiSelecionada == 0) {
					EditarReserva editarReserva = new EditarReserva(tbReservas);
					editarReserva.setVisible(true);
					dispose();

				} else if (qualTabelaFoiSelecionada == 1) {
					EditarHospede editarHospede = new EditarHospede(tbHospedes);
					editarHospede.setVisible(true);
					dispose();
				}
			}
		});

		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnDeletar = new JPanel();
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnDeletar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int qualTabelaFoiSelecionada = panel.getSelectedIndex();

				if (qualTabelaFoiSelecionada == 0) {
					excluirReserva();

				} else if (qualTabelaFoiSelecionada == 1) {
					excluirHospede();
				}
			}

		});
		contentPane.add(btnDeletar);

		JLabel lblExcluir = new JLabel("DELETAR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExcluir.setBounds(0, 0, 122, 35);
		btnDeletar.add(lblExcluir);
		setResizable(false);
	}
	private List<Reserva> registrosReservas() {
		return this.reservasController.retornarListaReserva();
	}
	private List<Hospede> registrosHospedes() { return this.hospedesController.retornarListaHospedes(); }
	private List<Hospede> hospedesPesquisados() {
		String pesquisa = txtBuscar.getText();
		return this.hospedesController.retornarListaHospedePesquisado(pesquisa);
	}
	private List<Reserva> reservasPesquisados() {
		String pesquisa = txtBuscar.getText();
		return this.reservasController.retornarListaReservaPesquisado(pesquisa);
	}


	private void preencherDadosTabelaReservas() {
		List<Reserva> reservaList = registrosReservas();
		try {
			for (Reserva reserva : reservaList) {
				modelo.addRow(new Object[] {reserva.getId(), reserva.getDataEntrada(), reserva.getDataSaida(),
					reserva.getValor(), reserva.getFormaPagamento()});
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	private void preencherDadosTabelaHospedes() {
		List<Hospede> hospedesList = registrosHospedes();
		try {
			for (Hospede hospede : hospedesList) {
				modeloHospedes.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getSobrenome(),
					hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva()});
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	private void dadosHospedePesquisado() {
		List<Hospede> hospedesList = hospedesPesquisados();
		try {
			for (Hospede hospede : hospedesList) {
				modeloHospedes.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getSobrenome(),
						hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva()});
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	private void dadosReservaPesquisado() {
		List<Reserva> reservasList = reservasPesquisados();
		try {
			for (Reserva reserva : reservasList) {
				modelo.addRow(new Object[] {reserva.getId(), reserva.getDataEntrada(), reserva.getDataSaida(),
						reserva.getValor(), reserva.getFormaPagamento()});
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	private void removendoDadosTabela(DefaultTableModel table) {
		while(table.getRowCount() > 0){
			for(int i = 0 ; i < table.getRowCount();i++){
				table.removeRow(i);
			}
		}
	}

	private void excluirReserva() {
		String idReserva = tbReservas.getValueAt(tbReservas.getSelectedRow(), 0).toString();
		Reserva novaReserva = new Reserva(Integer.valueOf(idReserva));

		int resposta = JOptionPane.showConfirmDialog(contentPane,
				"Deseja excluir a reserva com o ID " + idReserva + "?");

		if (resposta == 0) {
			reservasController.excluir(novaReserva);
			JOptionPane.showMessageDialog(contentPane, "Reserva excluída com sucesso!");
		} else {
			JOptionPane.showMessageDialog(contentPane, "Operação cancelada!");
		}

		Buscar buscar = new Buscar();
		buscar.setVisible(true);
		buscar.dispose();
	}

	private void excluirHospede() {
		String idHospede = tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 0).toString();
		Hospede novoHospede = new Hospede(Integer.valueOf(idHospede));

		int resposta = JOptionPane.showConfirmDialog(contentPane,
				"Deseja excluir o Hospede com ID " + idHospede + "?");

		if (resposta == 0) {
			hospedesController.excluir(novoHospede);
			JOptionPane.showMessageDialog(contentPane, "Hóspede excluído com sucesso!");
		} else {
			JOptionPane.showMessageDialog(contentPane, "Operação cancelada!");
		}

		Buscar buscar = new Buscar();
		buscar.setVisible(true);
		buscar.dispose();
	}


	private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	}
}
