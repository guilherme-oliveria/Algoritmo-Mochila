
public class Item {
	private float value;
	private float peso;
	private String name;
	public Boolean adicionado = false;
	
	public Item( String name,float value, float peso) {
		this.name = name;
		this.value = value;
		this.peso = peso;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

}
