package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas;
	
	public Estudiante(String cedula, String nombre, String apellido) {
		notas = new ArrayList<Nota>();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota nuevaNota) {
		String codMateriaNotaNueva = nuevaNota.getMateria().getCodigo();
		String notaCod;
		// verificar que la nota ya no este agregada a alguna materia
		for (int i = 0; i < notas.size(); i++) {
			notaCod = notas.get(i).getMateria().getCodigo();
			if ((nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10)
					&& !codMateriaNotaNueva.equals(notaCod)) {
				notas.add(nuevaNota);
				i++;
			}
		}
		
		if(notas.size() == 0) {
			notas.add(nuevaNota);
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		String notaCod;
		Nota nota;
		// verificar que la nota ya no este agregada a alguna materia
		for (int i = 0; i < notas.size(); i++) {
			nota = notas.get(i);
			notaCod = notas.get(i).getMateria().getCodigo();
			if ((nuevaNota >= 0 && nuevaNota <= 10) && codigo.equals(notaCod)) {
				nota.setCalificacion(nuevaNota);
			}
		}
	}

	public double calcularPromedioNotasEstudiante() {
		double promedio = 0.0;
		double suma = 0.0;
		double calificacion;
		for (int i = 0; i < notas.size(); i++) {
			calificacion = notas.get(i).getCalificacion();
			suma = suma + calificacion;
		}
		if(notas.size() > 0) {
			promedio = suma / notas.size();
		}
		return promedio;
	}
	
	public void mostrar() {
		Nota nota;
		String infoEstudiante = "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula;
		infoEstudiante += ", notas=[";
		for(int i=0;i<notas.size();i++) {
			nota = notas.get(i);
			infoEstudiante += nota.getMateria().getNombre() + ":" + nota.getCalificacion();
			if(i!= (notas.size()-1)) {
				infoEstudiante += ", ";
			}
		}
		infoEstudiante += "]";
		System.out.println(infoEstudiante);
	}
}
