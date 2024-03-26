package com.cmc.evaluacion.entidades;

public class CalculadoraAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
		double cuota;
		double co = prestamo.getMonto();
		double interesMensual = prestamo.getInteres() / (100 * 12);
		double n = prestamo.getPlazo();
		cuota = (co * interesMensual) / (1 - (Math.pow((1 + interesMensual), -n)));
		return cuota;
	}

	public static void generarTabla(Prestamo prestamo) {
		Cuota elementoCuota;
		int plazo = prestamo.getPlazo();
		double cuota = calcularCuota(prestamo);
		double inicio = prestamo.getMonto();
		double interes = prestamo.getInteres() / (100 * 12);
		for (int i = 1; i <= plazo; i++) {
			elementoCuota = calcularValoresCuota(interes, inicio, cuota, i);
			if (i == plazo) {
				cuota = cuota + elementoCuota.getSaldo();
				elementoCuota.setCuota(cuota);
			}
			prestamo.getCuotas().add(elementoCuota);
			inicio = elementoCuota.getSaldo();
		}
	}

	public static Cuota calcularValoresCuota(double interes, double inicio, double cuota, int numero) {
		Cuota cuotaObjeto = new Cuota(numero);
		double interesGenerado;
		double abonoCapital;
		double saldo;
		// obtener los valores de la cuota
		interesGenerado = inicio * interes;
		abonoCapital = cuota - interesGenerado;
		saldo = inicio - abonoCapital;
		// setearlos en la cuota
		cuotaObjeto.setCuota(cuota);
		cuotaObjeto.setInicio(inicio);
		cuotaObjeto.setInteres(interesGenerado);
		cuotaObjeto.setAbonoCapital(abonoCapital);
		cuotaObjeto.setSaldo(saldo);
		// retorna el objeto cuota para con el trabajar más adelante
		return cuotaObjeto;
	}

	public static void mostrarTabla(Prestamo prestamo) {
		Cuota elementoCuota;
		// primero colocamos un encabezado
		System.out.println("Numero | Cuota  | Inicio  | Interés | Abono | Saldo |");
		for (int i = 0; i < prestamo.getCuotas().size(); i++) {
			elementoCuota = prestamo.getCuotas().get(i);
			elementoCuota.mostrarPrestamo();
		}

	}
}
