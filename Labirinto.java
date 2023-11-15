package desafio.Labirinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

	private char[][] lab;
	private int filas;
	private int colunas;

	public void setLab(char[][] lab) {
		this.lab = lab;
	}

	public void criaLabirinto(String filename) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String li = br.readLine();
			colunas = li.length();

			while (li != null) {
				filas++;
				li = br.readLine();
			}

			br.close();

			br = new BufferedReader(new FileReader(filename));

			char[][] file = new char[filas][colunas];

			li = br.readLine();
			for (int i = 0; i < file.length && (li != null); i++) {
				file[i] = li.toCharArray();
				li = br.readLine();
			}

			setLab(file);

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void iLab() {
		for (int i = 0; i < filas; i++) {
			System.out.println();
			for (int j = 0; j < colunas; j++) {
				System.out.print(lab[i][j]);
			}

		}
		return;
	}

	public boolean rec(int linha, int coluna) {
		if (linha >= 0 && linha < filas && coluna >= 0 && coluna < colunas) {
			return lab[linha][coluna] == ' ' || lab[linha][coluna] == 'D';
		}
		return false;
	}

	public boolean percorreLabirinto() throws IllegalArgumentException {
		if (lab == null) {
			throw new IllegalArgumentException();
		}
		return percorreLabirinto(0, 0);
	}

	private boolean percorreLabirinto(int fila, int coluna) {
		if (rec(fila, coluna)) {
			if (this.lab[fila][coluna] == 'D') {
				lab[fila][coluna] = 'S';
				return true;
			}

			lab[fila][coluna] = 'V';
			boolean mov = percorreLabirinto(fila + 1, coluna);
			if (!mov) {
				mov = percorreLabirinto(fila - 1, coluna);
			}
			if (!mov) {
				mov = percorreLabirinto(fila, coluna + 1);
			}
			if (!mov) {
				mov = percorreLabirinto(fila, coluna - 1);
			}
		}
		return false;
	}
}
