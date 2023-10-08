package pkg;

public class Empleado {
	public enum TipoEmpleado{Vendedor, Encargado}
		
	public static float calculoNominaBruta(TipoEmpleado tipo, float ventaMes, float horasExtras) {
		float salariobase=0, primas=0, extras=0;
		
		if(tipo==TipoEmpleado.Encargado)
			salariobase=2500;
		else if(tipo==TipoEmpleado.Vendedor)
			salariobase=2000;
		
		if(ventaMes>=1500)
			primas=200;
		else if(ventaMes>=1000)
			primas=100;
		
		extras=horasExtras*30;
		
		return salariobase+primas+extras;
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion=0;
		
		if(nominaBruta>=2500)
			retencion=0.18f;
		else if(nominaBruta>2100)
			retencion=0.15f;
		
		return nominaBruta*(1-retencion);
	}

	
}
