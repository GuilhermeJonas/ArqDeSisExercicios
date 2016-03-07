package exercicio01.saque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import exercicio01.saque.beans.Conta;

import exercicio01.saque.ConexaoBD;
import exercicio01.saque.Log;
import exercicio01.saque.Notas;
import exercicio01.saque.Saque;

public class SaqueController implements ActionListener{
	private Conta conta;
	private Saque saque;
	private Notas notas;
	public ResourceBundle bundleParam;
	public Log log;
	public SaqueController(ResourceBundle bundleParam,final Conta conta) {
		super();
		this.conta = conta;
		this.notas = new Notas();
		this.bundleParam = bundleParam;
	}

	public Saque getSaque() {
		return saque;
	}

	public void setSaque(int tipoMovimento, double valor) {
		this.saque = new Saque(tipoMovimento, valor);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Connection conn = null;
		double saldo = 0.0;
		int qntNota =0;
		double valor = saque.getValor();
		//atributo para sair das opera��es logicas
		//                 R$10  R$20  R$50
		boolean[] vazio = {false,false,false};

		String[] mensagens = {bundleParam.getString("mensagem.sim"),bundleParam.getString("mensagem.nao")};

		// obtem conexao com o banco

		ConexaoBD bd = new ConexaoBD() ;
		try {
			conn = bd.obtemConexao();
			// *** For�a o uso de transa��o.
			conn.setAutoCommit(false);
			int opcao = JOptionPane.showOptionDialog(null, bundleParam.getString("tela.realizarSaque.confirma"), bundleParam.getString("tela.realizarSaque.titulo"),JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, mensagens, mensagens[1]);
			if (opcao == 0) {
				try {
					Calendar cData= Calendar.getInstance();
					String data = String.format("%tF", cData);
					ArrayList<Notas> listaNotas = this.notas.carregarDados(conn);

					int[] notasUsadas = new int[listaNotas.size()];

					for(int i = 0; i < listaNotas.size();i++){
						if(listaNotas.get(i).getQuantidade() == 0) vazio[i] = true;
					}

					while(vazio[2] == false && 50 <= valor){
						qntNota = listaNotas.get(2).getQuantidade();
						valor = valor - 50;
						notasUsadas[2]++;
						qntNota--;
						if(qntNota == 0) vazio[2] = true;
					}
					while(vazio[1] == false && 20 <= valor){
						qntNota = listaNotas.get(1).getQuantidade();
						valor = valor - 20;
						notasUsadas[1]++;
						qntNota--;
						if(qntNota == 0) vazio[1] = true;
					}
					while(vazio[0] == false && 10 <= valor){
						qntNota = listaNotas.get(0).getQuantidade();
						valor = valor - 10;
						notasUsadas[0]++;
						qntNota--;
						if(qntNota == 0) vazio[0] = true;
					}
					for (int i = 0; i < listaNotas.size(); i++) {
						int qntd =listaNotas.get(i).getQuantidade() - notasUsadas[i];
						if(notasUsadas[i] != 0)notas.atualizarNota(conn, qntd, listaNotas.get(i).getNota());
					}
					if(valor==0){
						//notas.atualizarNota(conn, qntdNota, nota);
						conn.commit();
						saldo = conta.consultaSaldo(conn, Integer.parseInt(conta.getNumConta()), conta.getAgencia().getNumAgencia(), conta.getBanco().getNumBanco());
						if (saldo >= saque.getValor()){
							conta.atualizarSaldo(conn, saldo - saque.getValor(), Integer.parseInt(conta.getNumConta()));
							saque.inserirSaque(conn, saque.getTipoMovimento(), -saque.getValor(),Integer.parseInt(conta.getNumConta()), conta.getAgencia().getNumAgencia(), conta.getBanco().getNumBanco(), data);
							if(saque.selectOperacao(conn, saque.getTipoMovimento(), data).equals(null)){
								saque.insertOperacao(conn, saque.getTipoMovimento(), data, 1);
							}else{
								int quantidade = 1;
								quantidade +=saque.selectQutddOperacao(conn, saque.getTipoMovimento(), data);
								saque.updateOperacao(conn, saque.getTipoMovimento(), data, quantidade++);
								log = new Log();
								log.gravarLog(saque.getTipoMovimento()+" - "+saque.getValor());
							}
							conn.commit();
							JOptionPane.showMessageDialog(null, bundleParam.getString("mensagem.msg01.saqueRealizado"));
						}else{
							JOptionPane.showMessageDialog(null, bundleParam.getString("tela.realizarSaque.sem.saldo"));
							throw new Exception();
						}
					}else JOptionPane.showMessageDialog(null,bundleParam.getString("tela.realizarSaque.erro.nota"));

				} catch (Exception e) {
					conn.rollback();
					JOptionPane.showMessageDialog(null,bundleParam.getString("tela.realizarSaque.erro.nota"));
					e.printStackTrace();
				}finally{
					conn.close();
				}

			}else {
				JOptionPane.showMessageDialog(null, bundleParam.getString("tela.realizarSaque.cancela") + "teste1");
				throw new Exception();
			}

		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,bundleParam.getString("tela.realizarSaque.concela") + " " +
					bundleParam.getString("tela.gerarCodigo.buttonCod") + " " +
					bundleParam.getString("tela.realizarTransferencia.erro.nota"));
			//e1.printStackTrace();
		}
	}
}


