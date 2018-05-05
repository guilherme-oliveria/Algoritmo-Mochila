import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Carregador {
	protected ArrayList<Item> allItens = new ArrayList<Item>();
	private Mochila[][] matriz = null;
	private int tamanhoItem= 0;
	public void LerItens() {
		Boolean stop = false;
		Scanner entrada = new Scanner(System.in);
		File file = new File("EntradaDeDados.txt");
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			//ler entrada de dados
			while ((line = buffer.readLine()) != null) {
				System.out.println(line );
				String[] splited = line.split("\\s+");
				String nome = splited[0];
				int value = Integer.parseInt(splited[1]);
				int peso = Integer.parseInt(splited[2]);
				allItens.add( new Item(nome, value, peso) );
				tamanhoItem++;
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getTamanhoItem() {
		return tamanhoItem;
	}

	public void setTamanhoItem(int tamanhoItem) {
		this.tamanhoItem = tamanhoItem;
	}

	public Mochila kild(){
		Scanner entrada = new Scanner(System.in);
		System.out.print("Informe o tamanho da mochila:");
		float size = entrada.nextFloat();
		Mochila mochila = new Mochila(size);
		
		for (Item Item: this.allItens) {
			Item maxItem = this.maxItem();
			mochila.In(maxItem);
			maxItem.adicionado = true;
		}
		
		return mochila;
	}
	
	public void Dinamico(Mochila m1){
		System.out.println("***** [Dinamico] ***** ");
		int s = (int) m1.getSize();
		int i = this.getAllItens().size();
		this.matriz = new  Mochila[i][s+1];
		int i1 = 0, i2 =0;
		for(Item item: this.getAllItens()) {
				while(s >= i2) {
					matriz[i1][i2]= DinamicoAlg(item, i2, matriz, i1);
					i2++;
				}
		
			i2 = 0;
			i1++;
		}
	}
	
	public Mochila DinamicoAlg(Item i,float s, Mochila[][] m,int n) {
		Mochila novaMochila = new Mochila(s);
		if(s <= 0 ) 
			return novaMochila;		
		
		if (!novaMochila.In(i) && n != 0)
			return m[n-1][(int) s];
		
		if(n==0)
			return novaMochila;
					
		int resto = (int) (novaMochila.getSize() - novaMochila.pesar());
		novaMochila.Unir(m[n-1][resto]);
	
		Mochila velhaMochila = m[n-1][(int) s];
		
		if((novaMochila.avaliar() > velhaMochila.avaliar()) ) {
			return novaMochila;
		}
		
		return velhaMochila;
	}
	
	public void DinamicoResultado() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("item : ");
		int i = entrada.nextInt();
		System.out.println("Mochila size : ");
		int s = entrada.nextInt();
		try {
			this.printMochila(this.matriz[i-1][s]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("valor do item invalido, insira um valor valido entre 1 e "+ getTamanhoItem());
			DinamicoResultado();
		}
	}	
	
	public Item maxItem() {
		Item maxItem = null;
		for (Item Item: this.allItens) {
			if(!Item.adicionado) {
				if( maxItem == null || (Item.getValue() >= maxItem.getValue()) && !Item.adicionado ){
					maxItem = Item;
				}
			}
			
		}
		return maxItem;
	}
	
	public void printMochila(Mochila mochila) {
		for (Item Item: mochila.Listar()) {
			System.out.print(Item.getName() + ' ');
		}
		System.out.println();
	}
	
	public float getTotalValorMochila(Mochila mochila) {
		float total = 0;
		for (Item Item: mochila.Listar()) {
			total = Item.getValue() + total;
		}
		return total;
	}
	
	public float getTotalPesoMochila(Mochila mochila) {
		float peso = 0;
		for (Item Item: mochila.Listar()) {
			peso = Item.getPeso() + peso;
		}
		return peso;
	}
	
	public  void imprimirMatriz() {
		if(this.matriz == null)
			return ;
		
		for(Mochila[] linha: this.matriz) {
			for(Mochila mochila: linha) {
				System.out.print(" ["+ mochila.avaliar()+"] " );
			}
			System.out.println();
		}
	}
	
	public ArrayList<Item> getAllItens(){
		return this.allItens;
	}

}

