package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void configurarMaquina(String codCelda1, String codCelda2, String codCelda3, String codCelda4) {
		celda1 = new Celda(codCelda1);
		celda2 = new Celda(codCelda2);
		celda3 = new Celda(codCelda3);
		celda4 = new Celda(codCelda4);
	}

	public void mostrarConfiguracion() {
		System.out.println("CELDA 1: " + celda1.getCodigo());
		System.out.println("CELDA 2: " + celda2.getCodigo());
		System.out.println("CELDA 3: " + celda3.getCodigo());
		System.out.println("CELDA 4: " + celda4.getCodigo());
	}

	public Celda buscarCelda(String codCelda) {
		if (celda1.getCodigo() == codCelda) {
			return celda1;
		} else if (celda2.getCodigo() == codCelda) {
			return celda2;
		} else if (celda3.getCodigo() == codCelda) {
			return celda3;
		} else if (celda4.getCodigo() == codCelda) {
			return celda4;
		} else {
			return null;
		}
	}

	public void cargarProducto(Producto producto, String codCelda, int stock) {
		Celda celdaRecuperada = buscarCelda(codCelda);
		if (celdaRecuperada != null) {
			celdaRecuperada.ingresarProducto(producto, stock);
		}
	}

	public void mostrarProductos() {
		System.out.println("**********CELDA " + celda1.getCodigo());
		System.out.println(" Stock:" + celda1.getStock());
		if (celda1.getProducto() != null) {
			System.out.println(" Nombre Producto: " + celda1.getProducto().getNombre());
			System.out.println(" Precio Producto: " + celda1.getProducto().getPrecio());
			System.out.println(" Código Producto: " + celda1.getProducto().getCodigo());
		} else {
			System.out.println(" La celda no tiene producto!!!");
		}
		System.out.println("**********CELDA " + celda2.getCodigo());
		System.out.println(" Stock:" + celda2.getStock());
		if (celda2.getProducto() != null) {
			System.out.println(" Nombre Producto: " + celda2.getProducto().getNombre());
			System.out.println(" Precio Producto: " + celda2.getProducto().getPrecio());
			System.out.println(" Código Producto: " + celda2.getProducto().getCodigo());
		} else {
			System.out.println(" La celda no tiene producto!!!");
		}
		System.out.println("**********CELDA " + celda3.getCodigo());
		System.out.println(" Stock:" + celda3.getStock());
		if (celda3.getProducto() != null) {
			System.out.println(" Nombre Producto: " + celda3.getProducto().getNombre());
			System.out.println(" Precio Producto: " + celda3.getProducto().getPrecio());
			System.out.println(" Código Producto: " + celda3.getProducto().getCodigo());
		} else {
			System.out.println(" La celda no tiene producto!!!");
		}
		System.out.println("**********CELDA " + celda4.getCodigo());
		System.out.println(" Stock:" + celda4.getStock());
		if (celda4.getProducto() != null) {
			System.out.println(" Nombre Producto: " + celda4.getProducto().getNombre());
			System.out.println(" Precio Producto: " + celda4.getProducto().getPrecio());
			System.out.println(" Código Producto: " + celda4.getProducto().getCodigo());
		} else {
			System.out.println(" La celda no tiene producto!!!");
		}
		System.out.println("Saldo: " + this.saldo);
	}
	
	public Producto buscarProductoEnCelda(String codCelda) {
		if (celda1.getCodigo() == codCelda) {
			return celda1.getProducto();
		} else if (celda2.getCodigo() == codCelda) {
			return celda2.getProducto();
		} else if (celda3.getCodigo() == codCelda) {
			return celda3.getProducto();
		} else if (celda4.getCodigo() == codCelda) {
			return celda4.getProducto();
		} else {
			return null;
		}
	}
	
	public double consultarPrecio(String codCelda) {
		Celda celda = buscarCelda(codCelda);
		if (celda != null) {
			return celda.getProducto().getPrecio();
		} else {
			System.out.println("No existe producto");
			return 0.0;
		}
	}
	
	public Celda buscarCeldaProducto(String codProducto) {
		if (celda1.getProducto() != null) {
			if (celda1.getProducto().getCodigo() == codProducto) {
				return celda1;
			} else {
				return null;
			}
		} else if (celda2.getProducto() != null) {
			if (celda2.getProducto().getCodigo() == codProducto) {
				return celda2;
			} else {
				return null;
			}
		} else if (celda3.getProducto() != null) {
			if (celda3.getProducto().getCodigo() == codProducto) {
				return celda3;
			} else {
				return null;
			}
		} else if (celda4.getProducto() != null) {
			if (celda4.getProducto().getCodigo() == codProducto) {
				return celda4;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void incrementarProductos(String codProducto, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codProducto);
		if (celdaEncontrada != null) {
			int stockNuevo = celdaEncontrada.getStock() + items;
			celdaEncontrada.setStock(stockNuevo);
		}
	}

	public void vender(String codCelda) {
		Celda celdaEncontrada = buscarCelda(codCelda);
		if (celdaEncontrada != null) {
			celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
			this.saldo = this.saldo + celdaEncontrada.getProducto().getPrecio();
		}
	}

	public double venderConCambio(String codCelda, double dineroIngresado) {
		double vuelto;
		Celda celda = buscarCelda(codCelda);
		vender(codCelda);
		vuelto = dineroIngresado - celda.getProducto().getPrecio();
		return vuelto;
	}
}