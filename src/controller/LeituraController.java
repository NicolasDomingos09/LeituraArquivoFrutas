package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraController{
    
    public void readDir(String path) throws IOException {
    	File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File file : files) {
				if (file.isFile()) {
					System.out.println("Arquivo: " + file.getName());
				}
			}
		}else {
			throw new IOException("Diretório não existe");
		}
        
    }
    
    public void readFile(String path, String nome) throws IOException {
        File arq = new File(path, nome);
		if(arq.exists() && !arq.isDirectory()) {
			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			
			System.out.printf("%-21s %-25s %-20s%n", "\nFOOD NAME", "SCIENTIFIC NAME", "SUBGROUP\n");
			while(linha != null) {
				
				if(linha.contains("Tropical fruits")) {
					String[] coluna = linha.split(",");
					
					if (coluna.length >= 3) {
	                    String nomeAlimento = coluna[0];
	                    String nomeCientif = coluna[1];
	                    String subgrupo = coluna[2];

	                    System.out.printf("%-20s %-25s %-20s%n", nomeAlimento, nomeCientif, subgrupo);
	                }
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();	
			
		}else {
			throw new IOException("Arquivo não existe");
		}
        
    }

}
