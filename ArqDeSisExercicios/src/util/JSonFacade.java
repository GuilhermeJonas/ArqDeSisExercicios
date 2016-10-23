package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Extrato;
import model.Saque;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import to.ExtratoTO;

public class JSonFacade {

	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}
//Extrato
	public static String listToJSon(ArrayList<ExtratoTO> lista) {
		JSONArray vetor = new JSONArray();
		for (ExtratoTO to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("idMovimento", to.getIdMovimento());
				object.put("tipoMovimento", to.getTipoMovimento());
				object.put("valor", to.getValor());
				object.put("data", to.getData());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Extrato jSonToExtrato(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int idMovimento = registro.getInt("idMovimento");
			int tipoMovimento = registro.getInt("tipoMovimento");
			double valor = registro.getDouble("valor");
			String data = registro.getString("data");
			return new Extrato(idMovimento, tipoMovimento, valor, data);
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String extratoToJSon(Extrato extrato) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("idMovimento", extrato.getIdMovimento());
			object.put("tipoMovimento", extrato.getTipoMovimento());
			object.put("valor", extrato.getValor());
			object.put("data", extrato.getData());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
// Saque
	public static Saque jSonToSaque(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int tipoMovimento = registro.getInt("tipoMovimento");
			double valor = registro.getDouble("valor");
			int numConta = registro.getInt("numConta");
			int numAgencia = registro.getInt("numAgencia");
			int numBanco = registro.getInt("numBanco");
			String data = registro.getString("data");
			return new Saque(tipoMovimento, valor, numConta, numAgencia, numBanco, data);
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}

	public static String saqueToJSon(Saque saque) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("tipoMovimento", saque.getTipoMovimento());
			object.put("valor", saque.getValor());
			object.put("numConta", saque.getNumConta());
			object.put("numAgencia", saque.getNumAgencia());
			object.put("numBanco", saque.getNumBanco());
			object.put("data", saque.getData());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
