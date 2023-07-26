package principal;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import pe.com.enums.Monedas;
import pe.com.model.Moneda;
import pe.com.service.ExchangeRate;
import pe.com.service.ExchangeTemperature;

public class Principal {

	List<Moneda> monedas = new ArrayList<Moneda>();

	Moneda monedaPeruana = new Moneda("Sol", "Peru");
	Moneda monedaAmericana = new Moneda("Dolar", "Estados Unidos");
	Moneda monedaEuropea = new Moneda("Euro", "Union Europea");
	Moneda monedaRusa = new Moneda("Libras Esterlinas", "Reino unido");
	Moneda monedaJaponesa = new Moneda("Yen", "Japon");
	Moneda monedaKorena = new Moneda("won", "surKorea");

	public static void main(String[] args) {

		boolean continuarUso = true;
		
		JOptionPane saludo = new JOptionPane();

		saludo.showMessageDialog(null, "Bienvenido al conversor de monedas y temperatura !!");
		
		while (continuarUso) {
		

			String[] opcionesInicio = { "MONEDAS", "TEMPERATURA" };
			String seleccionPrincipal = (String) JOptionPane.showInputDialog(null, "Seleccione tipo de conversion",
					"Menu principal", JOptionPane.QUESTION_MESSAGE, null, opcionesInicio, "Seleccion");

			System.out.println(seleccionPrincipal);

			if (seleccionPrincipal == "MONEDAS") {

				String seleccionMonedaOrigen = (String) JOptionPane.showInputDialog(null,
						"Seleccione moneda de origen para el cambio", "Cambio de moneda", JOptionPane.QUESTION_MESSAGE,
						null, Arrays.asList(Monedas.values()).toArray(), "Seleccion").toString();

				Double montoCambio = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese monto a cambiar:"));

				String seleccionMonedaDestino = (String) JOptionPane.showInputDialog(null,
						"Seleccione moneda de destino para el cambio", "Cambio de moneda", JOptionPane.QUESTION_MESSAGE,
						null, Arrays.asList(Monedas.values()).toArray(), "Seleccion").toString();

				ExchangeRate exr = new ExchangeRate();

				String cambio = exr.consultarCambio(Monedas.valueOf(seleccionMonedaOrigen).getCod().toString(),
						Monedas.valueOf(seleccionMonedaDestino).getCod().toString(), montoCambio);

				JOptionPane.showMessageDialog(null, "Monto cambiado es :" + cambio, "Cambio realizado", 1);
				
				int continuar=JOptionPane.showConfirmDialog(null,"¿Realizara otra conversion?");
				
				if(JOptionPane.OK_OPTION ==continuar) {
					continuarUso=true;
				}else {
					continuarUso=false;
					JOptionPane.showMessageDialog(null, "Gracias por usar la aplicacion");
				}

			}else {
				
			
				
				Map<String, Integer> cambiosTemperatura= new Hashtable<String, Integer>();
				cambiosTemperatura.put("Grados Celcius a Grados Farenheit", 1);
				cambiosTemperatura.put("Grados Celcius a Kelvin", 2);
				cambiosTemperatura.put("Grados Farenheit a Grados Celcius", 3);
				cambiosTemperatura.put("Kelvin a Grados Celcius", 4);
				cambiosTemperatura.put("Kelvin a Grados Farenheit", 5);
				
				
				
				Double temperaturaCambio = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese temperatura a cambiar:"));
				String seleccionCambioTemperatura = (String) JOptionPane.showInputDialog(null,
						"Seleccione opcion para cambio de temperatura", "Cambio de temperatura", JOptionPane.QUESTION_MESSAGE,
						null,  (String[]) cambiosTemperatura.keySet().toArray(new String[0]) , "Seleccion").toString();

				ExchangeTemperature et= new ExchangeTemperature();
		
				
				JOptionPane.showMessageDialog(null,"El resultado es: "+ 		et.convertirTemperatura(cambiosTemperatura.get(seleccionCambioTemperatura),temperaturaCambio ));
				
			}

		}

	}

}
