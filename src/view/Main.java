package view;

import java.io.IOException;
import controller.LeituraController;

public class Main {
    public static void main(String[] args) {
    	LeituraController cont = new LeituraController();
		String dir = "C:\\temp";
		String path = "C:\\temp";
		String nome = "generic_food.csv";
		
		try {
			cont.readDir(dir);
			cont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
