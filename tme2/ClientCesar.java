package tme2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCesar {

	public static void main(String[] args) {

		Socket c = null;
		CesarWriter os = null;
		Writer w = null;
		while(c==null){
			try {
				System.out.println("Tentative de connexion");
				c = new Socket("localhost", 8080);
				System.out.println("Connecté");

				BufferedReader br = new BufferedReader(
						new InputStreamReader(System.in));
				w = new OutputStreamWriter(c.getOutputStream());
				os = new CesarWriter(w, 5);
				String str;
				while((str = br.readLine())!=null){
					if(str.equals("quit")) break;
					os.write(str);
					//os.write("\n");
					os.flush();
				}


			} catch (UnknownHostException e) {
				System.out.println("Erreur host");
			} catch (IOException e) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	

			}finally{
				try {
					if(c != null)
						c.close();
					if(w != null)
						w.close();
					if(os != null)
						os.close();
				}catch(IOException e){
					System.out.println("Could not close socket");
				}
			}
		}

	}

}
