package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	
	private float value1; //ventasMes
	private float value2; //horasExtras
	private float value3; //nominaBruta
	//private TipoEmpleado value3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		value1=1500.0f;
		value2=10.0f;
		value3=3000.0f;
		System.out.println("Before each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After each");
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		float expected=3000.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Encargado, value1, value2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected=2500.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, value1, value2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaOtro() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesNegativa() {
		value1=-1.0f;
		fail("Not yet implemented");
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMenor1000() {
		value1=900.0f;
		float expected=2800.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Encargado, value1, value2 );
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesEntre1000y1500() {
		value1=1200.0f;
		float expected=2900.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Encargado, value1, value2 );
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMayor1500() {
		value1=1600.0f;
		float expected=3000.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Encargado, value1, value2 );
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		float expected=2500.0f;
		float actual=Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, value1, value2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		value2=-1.0f;
	}
	

	@Test
	void testCalculoNominaNetaNegativa() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCalculoNominaNetaPositiva() {
		float expected=2460.0f;
		float actual=Empleado.calculoNominaNeta(value3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		float expected=3000.0f;
		float actual=Empleado.calculoNominaNeta(value3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		float expected=2550.0f;
		float actual=Empleado.calculoNominaNeta(value3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		float expected=2460.0f;
		float actual=Empleado.calculoNominaNeta(value3);
		assertEquals(expected, actual);
	}

}
