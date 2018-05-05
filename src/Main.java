/*Data 30/04/2018 
 * Guilherme
 * */

public class Main {

	public static void main(String[] args) {
		Carregador carregador = new Carregador();
		carregador.LerItens();
		Mochila m1 = carregador.kild();
		carregador.printMochila(m1);
		
		carregador.Dinamico(m1);
		
		carregador.imprimirMatriz();
		System.out.println("Tamanho total de item "+ carregador.getTamanhoItem());
		while(true) {
			carregador.DinamicoResultado();
		}
	}
	


}