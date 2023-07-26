package pe.com.service;

public class ExchangeTemperature {

	public double convertirTemperatura(int opcion,double temperatura) {

		double temperaturaConvertida=0;
		switch (opcion) {
		case 1: {
			
			temperaturaConvertida=(temperatura*(9/5))+32;
			
			break;
		}
		case 2: {
		
			temperaturaConvertida=temperatura+273.15;
			break;
		}
		case 3: {
			temperaturaConvertida=(temperatura-32)/1.8;
			break;
		}
		case 4: {
			temperaturaConvertida=temperatura-273.15;
			break;
		}
		case 5: {
			temperaturaConvertida=(temperatura-273.15)+32;
			break;
		}
		default:
			throw new IllegalArgumentException("No se esperaba el valor" + opcion);
		}
		
		return temperaturaConvertida;
	}

}
