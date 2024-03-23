package com.krakedev.evaluacion;

public class Direccion {
	private String callePrincipal;
	private String calleSecundaria;
	private String tipo;
	
	public Direccion(String callePrincipal, String calleSecundaria) {
		this.callePrincipal = callePrincipal;
		this.calleSecundaria = calleSecundaria;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public String getCalleSecundaria() {
		return calleSecundaria;
	}
	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
