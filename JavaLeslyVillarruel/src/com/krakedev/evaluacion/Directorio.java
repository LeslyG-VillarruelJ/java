package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;
	
	public Directorio() {
		contactos = new ArrayList<Contacto>();
		this.fechaModificacion = new Date();
		correctos = new ArrayList<Contacto>();
		incorrectos = new ArrayList<Contacto>();
	}
	
	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}

	public boolean agregarContacto(Contacto cont) {
		boolean retorno = false;
		Contacto contacto = buscarPorCedula(cont.getCedula());
		if (contacto == null) {
			contactos.add(cont);
			retorno = true;
		}
		return retorno;
	}

	public Contacto buscarPorCedula(String cedula) {
		Contacto cont = null;
		String cedulaElementoContacto;
		for (int i = 0; i < contactos.size(); i++) {
			cedulaElementoContacto = contactos.get(i).getCedula();
			if (cedula.equals(cedulaElementoContacto)) {
				cont = contactos.get(i);
			}
		}

		return cont;
	}

	public String consultarUltimaModificacion() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = sdf.format(fechaModificacion);
		return dateString;
	}

	public int contarPerdidos() {
		Contacto elementoContacto;
		int perdidos = 0;
		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);
			if (elementoContacto.getDireccion() == null) {
				perdidos++;
			}
		}
		return perdidos;
	}

	public int contarFijos() {
		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
		int fijos = 0;
		for (int i = 0; i < contactos.size(); i++) {
			telefonos = contactos.get(i).getTelefonos();
			for (int j = 0; j < telefonos.size(); j++) {
				if(telefonos.get(j).getEstado().equals("C") && telefonos.get(j).getTipo().equals("Convencional")) {
					fijos++;
				}
			}
		}
		return fijos;
	}
	
	public void depurar(){
		Contacto elementoContacto;
		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);
			if (elementoContacto.getDireccion() != null) {
				correctos.add(elementoContacto);
			} else {
				incorrectos.add(elementoContacto);
			}
		}
		contactos.clear();
	}
}
