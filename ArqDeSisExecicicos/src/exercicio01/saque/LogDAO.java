package exercicio01.saque;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogDAO {
	public LogDAO(){

	}

	public void gravarLog(String texto){

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		File arq = new File("Log.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(arq,true));
			if(arq.canWrite()){
				bw.write(texto + " Data: " + dateFormat.format(date));
				bw.newLine();
				bw.flush();
				bw.close();
			}
		}catch (IOException e){}
	}

}
