import entities.Cliente;
import entities.Conta;
import entities.Telas.TelaOpcoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		new TelaOpcoes(
			new ArrayList<Cliente>(),
			new ArrayList<Conta>(),
			sc
		).imprimirTela();

		sc.close();
	}

}
