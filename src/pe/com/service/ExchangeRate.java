package pe.com.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class ExchangeRate {

	public String urlBase;
	
	
	
	public ExchangeRate () {
		
		this.urlBase="https://v6.exchangerate-api.com/v6/85396b2069cb8d8c7e0d15eb/pair/";
		
	}
	
	public String consultarCambio(String monedaOrigen,String MonedaCambio,Double monto) {
		
		try {
			
			System.out.println(monedaOrigen+"  "+MonedaCambio);
			URL url= new URL(urlBase+monedaOrigen+"/"+MonedaCambio+"/"+monto);
			HttpURLConnection conexion= (HttpURLConnection)url.openConnection();
			conexion.setRequestMethod("GET");
			conexion.connect();
			
			int codigoRespuesta= conexion.getResponseCode();
			
			if(codigoRespuesta!=200) {
				throw new RuntimeException("Error de conexion :"+ codigoRespuesta);
			}else {
				StringBuilder cadenaInformativa= new StringBuilder();
				Scanner escaner= new Scanner(url.openStream());
				
				while (escaner.hasNext()) {
					cadenaInformativa.append(escaner.nextLine());
				}
				escaner.close();
				
				JSONObject jo= new JSONObject(cadenaInformativa.toString());
				
				String cambio = (jo.getBigDecimal("conversion_result")).toString() ;
				
				return cambio;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
}
