package Euclides.mate;

import java.util.ArrayList;
import java.util.List;

public class Euclides {
	
	public List<Integer> lResiduo = new ArrayList<Integer>();
	public List<Integer> lDividendo = new ArrayList<Integer>();
	public List<Integer> lCociente = new ArrayList<Integer>();

	public int algoritmo(Double dividendo,Double divisor){
		lDividendo.add(dividendo.intValue());//Se agrega el dividendo

		while (divisor > 0){//si el divisor es mayor a cero seguimos con el algoritmo, cumpliendo la precondicion
			Double residuo =  dividendo % divisor; //Se obtiene el residuo
			Double cociente = Math.floor(dividendo/divisor);// Se obtiene un cociente mas exacto

			lDividendo.add(divisor.intValue()); //Se agrega el divisor actual
			lResiduo.add(residuo.intValue()); //Se agrega el residuo de la division
			lCociente.add(cociente.intValue());// Se agrega el cociente de la division

			dividendo =  divisor;
			divisor = residuo;

		}

		return  lDividendo.get(lDividendo.size() - 1);//El ultimo dividendo es la respuesa (cmd)
	}
	
	public List<Integer> getlResiduo() {//retorna los residuos
		return lResiduo;
	}

	public List<Integer> getlDividendo() {//retorna los dividendo
		return lDividendo;
	}

	public List<Integer> getlCociente() {//retorna los cocientes
		return lCociente;
	}
}
