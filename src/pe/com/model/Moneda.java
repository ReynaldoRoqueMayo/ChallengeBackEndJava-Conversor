package pe.com.model;

public class Moneda {

	
	public String nombre;
	public String pais;
	
	public Moneda(String nombre, String pais) {

		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
