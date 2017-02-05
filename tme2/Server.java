package tme2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		Socket c = null;
		ServerSocket s = null;
		try {
			s = new ServerSocket(8080);
			c  = s.accept();

			System.out.println("Utilisateur connecté port : "+c.getLocalPort());
			BufferedReader br = new BufferedReader(
					new InputStreamReader(c.getInputStream()));

			String str;

			while((str=br.readLine()) != null){
				System.out.println("Message reçu : "+str);
			}
		} catch (IOException e) {

		}finally{
			try{
				if(s != null)
					s.close();
				if(c != null)
					c.close();
			}catch(IOException e){

			}
		}

	}
}
