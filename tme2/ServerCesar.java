package tme2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCesar {

	public static void main(String[] args) {

		Socket c = null;
		ServerSocket s = null;
		try {
			s = new ServerSocket(8080);
			c  = s.accept();

			System.out.println("Utilisateur connecté port : "+c.getLocalPort());
			Reader r = new InputStreamReader(c.getInputStream());
			CesarReader br = new CesarReader(r,5);

			char buf[] = new char[100];
			while(!c.isClosed()){
				br.read(buf);
				System.out.println(buf);
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
