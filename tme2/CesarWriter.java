package tme2;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter{

	int dec;

	public CesarWriter(Writer out, int dec) {
		super(out);
		
		// Pour les décallage au dessus de 25
		this.dec=dec % 26;
	}

	/* On crypte seulement les lettres */
	@Override
	public void write(String str, int off, int len) throws IOException {
		//char c = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			//On teste si c'est une lettre
			if(( c>='A' && c<='Z') || (c>='a' && c<='z')){
				c = (char) (c + dec);
				//Lors du décallage si on aura un caractère qui n'est pas une
				//lettre on lui soustrait 26
				if(!(( c>='A' && c<='Z') || (c>='a' && c<='z')))
					c = (char) ( c - 26);
			}
			sb.append(c);
		}
		out.write(sb.toString(), off, len);
	}



}
