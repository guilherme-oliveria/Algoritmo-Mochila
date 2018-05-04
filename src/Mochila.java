import java.util.ArrayList;

public class Mochila {
	  private  ArrayList<Item> Itens = new ArrayList<Item>();
	  private float size;
	  
	  public Mochila(float size) {
		  this.size = size;
	  }
	  
	  public ArrayList<Item> Listar(){
		  return this.Itens;
	  }
	  
	  public Boolean In(Item i){
		  if(this.Cabe(i)) {
			  this.Itens.add(i);
			  return true;
		  }
		  return false;
	  }
	  
	  public Boolean Out(Item i){
		  int id = 0;
		  for (Item Item: Itens) {
			    if(i.getName() == Item.getName()){
			    	this.Itens.remove(id);
			    	return true;
			    }
			    id++;
		  }
		  return false;
	  }
	  
	  /**
	   * Este método uni duas mochilas
	   * @param m Mochila
	   * @return Bolean 
	   */
	  public Boolean Unir(Mochila m){
		  //System.out.println("uni " + (this.size - this.pesar()) + " " + m.pesar());
		  if((this.size - this.pesar()) >= m.pesar()) {
			  for (Item Item: m.Listar()) {
				    this.In(Item);
			  }
			  return true;
		  }
		  return false;
	  }
	  
	  private Boolean Cabe(Item i){
		  float tPeso = i.getPeso() + this.pesar();
		  return tPeso <= this.size;
	  }
	  
	  public float pesar() {
		  float tPeso = 0;
		  for (Item Item: this.Itens) {
			    tPeso = tPeso + Item.getPeso();
		  }
		  return tPeso;
	  }
	  
	  public float avaliar() {
		  float tValor = 0;
		  for (Item Item: this.Itens) {
			    tValor = tValor + Item.getValue();
		  }
		  return tValor;
	  }
	  
	  public float getSize() {
		  return this.size;
	  }
}
