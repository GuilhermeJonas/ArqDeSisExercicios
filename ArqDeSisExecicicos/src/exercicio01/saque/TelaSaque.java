package exercicio01.saque;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exercicio01.saque.SaqueController;
import exercicio01.saque.beans.Conta;

public class TelaSaque extends JFrame implements ActionListener{
	private JLabel frase;
	private JButton Imprimir;
	private JButton voltar;
	private JButton terminar;
	private JPanel botoes;
	private JPanel principal;
	private JPanel conteudo;
	private JButton v10; JButton v20; JButton v50; JButton v100; JButton v200; JButton v500;
	private JLabel lblvalor;
	private JTextField txfvalor;
	private JPanel OpcBase;
	private JPanel Opc;
	private JPanel Opc2;
	private ImageIcon imgUsr;
	private Dimension tam;
	public Locale locale;
	public ResourceBundle bundleLocale;

	TelaSaque(Locale localeParam, ResourceBundle bundleParam, final Conta conta){
		super(bundleParam.getString("tela.realizarSaque.titulo"));
		setLocation(localeParam, bundleParam);
		tam = new Dimension(100, 100);
		imgUsr = new ImageIcon("Interface/login.png");
		frase = new JLabel(conta.getNome()+" - "+ bundleLocale.getString("tela.realizarSaque.titulo") , imgUsr, SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.LEFT);
		Imprimir = new JButton(bundleLocale.getString("tela.button.imprimir"));
		terminar = new JButton(bundleLocale.getString("tela.button.terminar"));
		voltar = new JButton(bundleLocale.getString("tela.button.voltar"));
		botoes = new JPanel();
		principal = new JPanel();
		conteudo = new JPanel(new BorderLayout());
		v10 = new JButton(bundleLocale.getString("tela.realizarSaque.button.10"));
			v10.setPreferredSize(tam);
		v20 = new JButton(bundleLocale.getString("tela.realizarSaque.button.20"));
			v20.setPreferredSize(tam);
		v50 = new JButton(bundleLocale.getString("tela.realizarSaque.button.50"));
			v50.setPreferredSize(tam);
		v100 = new JButton(bundleLocale.getString("tela.realizarSaque.button.100"));
			v100.setPreferredSize(tam);
		v200 = new JButton(bundleLocale.getString("tela.realizarSaque.button.200"));
			v200.setPreferredSize(tam);
		v500 = new JButton(bundleLocale.getString("tela.realizarSaque.button.500"));
			v500.setPreferredSize(tam);
		lblvalor = new JLabel(bundleLocale.getString("tela.realizarSaque.label"));
		txfvalor = new JTextField(20);

		Opc = new JPanel();
			Opc.setLayout(new FlowLayout());
			Opc.add(v10);
			Opc.add(v20);
			Opc.add(v50);
			Opc.add(v100);
			Opc.add(v200);
			Opc.add(v500);
		Opc2 = new JPanel(new FlowLayout());
			Opc2.add(lblvalor);
			Opc2.add(txfvalor);
		Opc2.setAlignmentY(Opc.getAlignmentY());
	//	Conteudo.setLayout(new BorderLayout());
		OpcBase = new JPanel(new FlowLayout());
			OpcBase.add(Opc, SwingConstants.CENTER);
			OpcBase.add(Opc2);
		conteudo.add(OpcBase, BorderLayout.CENTER);
		botoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
			botoes.add(Imprimir);
			botoes.add(terminar);
			botoes.add(voltar);

		principal.setLayout(new BorderLayout());
		principal.add(BorderLayout.NORTH, frase);
		principal.add(BorderLayout.CENTER, conteudo);
		principal.add(BorderLayout.SOUTH, botoes);

		getContentPane().add(principal);
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		v10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale, conta);
				saqueController.setSaque(2,10);
				saqueController.actionPerformed(e);
			}
		});
		v20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale,conta);
				saqueController.setSaque(2,20);
				saqueController.actionPerformed(e);
			}
		});
		v50.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale,conta);
				saqueController.setSaque(2,50);
				saqueController.actionPerformed(e);
			}
		});
		v100.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale,conta);
				saqueController.setSaque(2,100);
				saqueController.actionPerformed(e);
			}
		});
		v200.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale,conta);
				saqueController.setSaque(2,200);
				saqueController.actionPerformed(e);
			}
		});
		v500.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SaqueController saqueController = new SaqueController(bundleLocale,conta);
				saqueController.setSaque(2,500);
				saqueController.actionPerformed(e);
			}
		});
		terminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					SaqueController saqueController = new SaqueController(bundleLocale,conta);
					saqueController.setSaque(2,Double.parseDouble(txfvalor.getText()));
					saqueController.actionPerformed(e);
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,bundleLocale.getString("mensagem.realizarSaque.fa01"),
							bundleLocale.getString("tela.realizarSaque.titulo"),2);
				}
			}
		});
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TelaMenuUsuario MU = new TelaMenuUsuario(locale, bundleLocale, conta);
				dispose();
			}
		});
		Imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,bundleLocale.getString("mensagem.msg02.ComprovanteSaque"),
						bundleLocale.getString("tela.realizarSaque.titulo"),2);
			}
		});
	}
	public void setLocation(Locale locale, ResourceBundle bundle){
		this.locale = locale;
		this.bundleLocale = bundle;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
