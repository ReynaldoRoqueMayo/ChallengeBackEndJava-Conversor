package pe.com.enums;

import java.util.ArrayList;

public  enum Monedas {

	SOL("PEN"),DOLAR("USD"),EURO("EUR"),LIBRA_ESTERLINA("GBP"),
	YEN_JAPONES("JPY"),WON_KOREANO("KRW");
	
	public String codigo;
	Monedas(String cod) {
		codigo=cod;
	}
	public String getCod() {
		return codigo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
