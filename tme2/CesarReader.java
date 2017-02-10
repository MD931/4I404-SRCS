package tme2;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CesarReader extends FilterReader{

	int dec;

	Reader in;
	public CesarReader(Reader in, int dec) {
		super(in);
		this.in = in;
		// Pour les décallage au dessus de 25
		this.dec=dec % 26;
	}

	/* On crypte seulement les lettres */
	@Override
	public int read(char buf[]) throws IOException {
		//char c = 0;
		in.read(buf);
		for(int i = 0; i< buf.length ; i++){
			char c = buf[i];
			//On teste si c'est une lettre
			if(( c>='A' && c<='Z') || (c>='a' && c<='z')){
				c = (char) (c - dec);
				//Lors du décallage si on aura un caractère qui n'est pas une
				//lettre on lui soustrait 26
				if(!(( c>='A' && c<='Z') || (c>='a' && c<='z')))
					c = (char) ( c + 26);
			}
			buf[i] = c;
		}
		return 1;
	}



}
