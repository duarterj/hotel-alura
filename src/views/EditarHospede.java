package views;

import controller.HospedesController;
import modelo.Hospede;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EditarHospede extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtIdReserva;
	public static JTextField txtNome;
	public static JTextField txtSobrenome;
	public static JTextField txtDataNascimento;
	public static JTextField txtNacionalidade;
	public static JTextField txtTelefone;
	int xMouse, yMouse;
	private JLabel labelAtras;
	private HospedesController hospedesController;

	public EditarHospede(JTable tbReservas) {
		hospedesController = new HospedesController();
		iniciandoEditarReserva(tbReservas);
	}

	private void iniciandoEditarReserva(JTable tbHospedes) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarHospede.class.getResource("/resources/imagens/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);


		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);

		txtId = new JTextField();
		txtId.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 0).toString());

		txtIdReserva = new JTextField();
		txtIdReserva.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 6).toString());

		JLabel lblTitulo = new JLabel("EDITAR HOSPEDE");
		lblTitulo.setBounds(119, 40, 219, 42); // 50 -> 30
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		panel.add(lblTitulo);

		JLabel lblCheckIn = new JLabel("NOME");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 106, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(lblCheckIn);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNome.setBounds(68, 131, 289, 35);
		txtNome.setBackground(Color.WHITE);
		txtNome.setColumns(10);
		txtNome.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 1).toString());
		panel.add(txtNome);

		JLabel lblCheckOut = new JLabel("SOBRENOME");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 181, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(lblCheckOut);

		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSobrenome.setBounds(68, 206, 289, 35);
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(Color.WHITE);
		txtSobrenome.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 2).toString());
		panel.add(txtSobrenome);

		JLabel DataNascimento = new JLabel("DATA NASCIMENTO");
		DataNascimento.setForeground(SystemColor.textInactiveText);
		DataNascimento.setBounds(68, 256, 187, 14);
		DataNascimento.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(DataNascimento);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtDataNascimento.setBounds(68, 281, 289, 35);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBackground(Color.WHITE);
		txtDataNascimento.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 3).toString());
		panel.add(txtDataNascimento);

		JLabel Nacionalidade = new JLabel("NACIONALIDADE");
		Nacionalidade.setForeground(SystemColor.textInactiveText);
		Nacionalidade.setBounds(68, 331, 187, 14);
		Nacionalidade.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(Nacionalidade);

		txtNacionalidade = new JTextField();
		txtNacionalidade.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNacionalidade.setBounds(68, 356, 289, 35);
		txtNacionalidade.setColumns(10);
		txtNacionalidade.setBackground(Color.WHITE);
		txtNacionalidade.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 4).toString());
		panel.add(txtNacionalidade);

		JLabel Telefone = new JLabel("TELEFONE");
		Telefone.setForeground(SystemColor.textInactiveText);
		Telefone.setBounds(68, 406, 187, 14);
		Telefone.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		panel.add(Telefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefone.setBounds(68, 431, 289, 35);
		txtTelefone.setColumns(10);
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setText(tbHospedes.getValueAt(tbHospedes.getSelectedRow(), 5).toString());
		panel.add(txtTelefone);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);


		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Buscar buscar = new Buscar();
				buscar.setVisible(true);
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
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));


		JPanel btnSalvar = new JPanel();
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alterarHospede();

			}
		});
		btnSalvar.setLayout(null);
		btnSalvar.setBackground(SystemColor.textHighlight);
		btnSalvar.setBounds(208, 493, 122, 35);
		panel.add(btnSalvar);
		btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel lblSeguinte = new JLabel("SALVAR");
		lblSeguinte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguinte.setForeground(Color.WHITE);
		lblSeguinte.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSeguinte.setBounds(0, 0, 122, 35);
		btnSalvar.add(lblSeguinte);

	}

	 private void headerMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void alterarHospede() {
		Hospede novoHospede = new Hospede(Integer.parseInt(txtId.getText()), txtNome.getText(), txtSobrenome.getText(),
				java.sql.Date.valueOf(txtDataNascimento.getText()), txtNacionalidade.getText(), txtTelefone.getText(),
				Integer.valueOf(txtIdReserva.getText()));

		hospedesController.alterar(novoHospede);

		JOptionPane.showMessageDialog(contentPane, "Hóspede atualizado com sucesso! " +
				"ID Hóspede: " + txtId.getText());
	}
}
