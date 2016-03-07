package exercicio01.saque;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
//import java.util.Scanner;

public class AcessoDAO {
	private Formatter output;
	private int quantidadeLinha;
	private int [][] contaesenha;
	private boolean flagCodigo;
	//metodos
	public void abrirArquivo(String nome){
		try{
			output = new Formatter(nome);
		}
		catch(SecurityException securityException){
			System.err.println("Voc� nao tem permiss�o para escrever neste arquivo");
			System.exit(1);
		}
		catch(FileNotFoundException fileNotFoundException){
			System.err.println("Erro ao criar o arquivo");
			System.exit(1);
		}
	}
	public void adicionaRegistro(String conta, String senha){
		try{
			output.format("%s;%s*\r\n", conta, senha);
		}
		catch (FormatterClosedException formatterClosedException){
			System.err.print("Erro ao escrever no arquivo");
		}
		catch(NoSuchElementException noSuchElementException){
			System.err.println("Entrada invalida.Tente novamente");
		}
	}
	//Sobrecarga utilizada para gravar o arquivo criptografado
	public void adicionaRegistro(String criptografado){
                                                                   		try{
			output.format("%s", criptografado);
		}
		catch (FormatterClosedException formatterClosedException){
			System.err.print("Erro ao escrever no arquivo");
		}
		catch(NoSuchElementException noSuchElementException){
			System.err.println("Entrada invalida.Tente novamente");
		}
	}

	public String carregaRegistro(String file){
		//Scanner ler = new Scanner(System.in);
		String conteudo = "";
		int qtd =0;
		try{
			//String nome = ler.nextLine();
			FileReader arq  = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(arq);
			String msg = lerArq.readLine();
			conteudo = msg;
			while(msg != null){
				msg = lerArq.readLine();
				qtd ++;
				if(msg != null)
					conteudo += msg;
			}
			setQuantidaDeLinha(qtd);
			arq.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return conteudo;
	}
	public void fecharArquivo(){
		if(output!=null)
			output.close();
	}
	public void geraMatriz(){
		AcessoDAO txt = new AcessoDAO();

		String saida = txt.carregaRegistro("AcessoDescriptografado.txt");
		contaesenha = new int [txt.getQuantidaDeLinha()][2];
		boolean conta = true;
		String buffer = "";
		int s = 0;

		for(int i=0; i<saida.length(); i++){
			if(saida.charAt(i) != ';' & conta == true){
				buffer+=saida.charAt(i);
			}else if(saida.charAt(i) == ';'){
				contaesenha[s][0] = Integer.parseInt(buffer);
				//System.out.println("conta"+buffer);
				conta = false;
				buffer = "";

			}else if(saida.charAt(i) != '*' && conta == false){
				buffer += saida.charAt(i);
			}else if(saida.charAt(i) == '*'){
				contaesenha[s++][1] = Integer.parseInt(buffer);
				//System.out.println("senha"+buffer);
				conta = true;
				buffer = "";
			}
		}
		setContaSenha(contaesenha);
	}
	public static boolean buscaBinaria(int vet[][],int conta, int senha) {
		final int n = vet.length;
		int inicio=0,fim=n-1,meio;
		while (inicio<=fim){
			meio=(inicio+fim)/2;
			if (conta == vet[meio][0] && senha == vet[meio][1])
				return true;
			else
				if (vet[meio][0] < conta)
					inicio = meio+1;
				else
					fim = meio-1;
		}
		return false;
	}
	public int[][] getContaesenha() {
		return contaesenha;
	}
	public void setContaSenha(int[][] contaesenha) {
		this.contaesenha = contaesenha;
	}
	public int getQuantidaDeLinha() {
		return quantidadeLinha;
	}
	public void setQuantidaDeLinha(int quantidadeLinha) {
		this.quantidadeLinha = quantidadeLinha;
	}

}
