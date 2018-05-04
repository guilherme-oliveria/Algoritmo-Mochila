import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Carregador carregador = new Carregador();
		carregador.LerItens();
		Mochila m1 = carregador.Guloso();
		carregador.printMochila(m1);
		
		carregador.Dinamico(m1);
		
		carregador.imprimirMatriz();
		
		while(true) {
			carregador.DinamicoResultado();
		}
	}
	


}