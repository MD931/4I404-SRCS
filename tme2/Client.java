package tme2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		Socket c = null;
		while(c==null){
			try {
				System.out.println("Tentative de connexion");
				c = new Socket("localhost", 8080);
				System.out.println("Connecté");
				
				BufferedReader br = new BufferedReader(
						new InputStreamReader(System.in));
				BufferedWriter os = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
				String str;
				while((str = br.readLine())!=null){
					if(str.equals("quit")) break;
					os.write(str);
					os.write("\n");
					os.flush();
				}
				c.close();
				
			} catch (UnknownHostException e) {
				System.out.println("Erreur host");
			} catch (IOException e) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
				
			}
		}

	}

}
