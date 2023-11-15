package desafio.Labirinto;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		Labirinto lab = new Labirinto();
		String filename = "../filename.txt";
		try {
			lab.criaLabirinto(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Labirinto sem resolver");
		lab.iLab();
		lab.percorreLabirinto();
		System.out.println();
		System.out.println();
		System.out.print("Labirinto resolvido");
		lab.iLab();
	}

}
