package BattleShip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reader {
	
	File file;
	BufferedReader br;
	List<String> listString;
	int element;
	int numElements = 0;
	
	Reader(String recivedFile) throws IOException{
		this.file = new File(recivedFile);
		this.br = new BufferedReader(new FileReader(this.file));
		element = 0;
		
		this.listString = new ArrayList<String>();
		
		String text;
		while ((text = this.br.readLine()) != null) {
			this.numElements++;
			this.listString.add(text);
		}
	}
	
	public List<String> getList() {
		return this.listString;
	}
	
	public String getElement() {
		return this.listString.get(element++);
	}
	
	public int getNumElements() {
		return this.numElements;
	}
}

