package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes;

	public Curso() {
		estudiantes = new ArrayList<Estudiante>();
	}
	
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String buscarEstudiante(Estudiante estudiante) {
		String mensaje = null;
		String cedulaEstudiante;
		for (int i = 0; i < estudiantes.size(); i++) {
			cedulaEstudiante = estudiantes.get(i).getCedula();
			if (cedulaEstudiante.equals(estudiante.getCedula())) {
				mensaje = "Estudiante esta en el curso";
			}
		}
		return mensaje;
	}
	
	public void matricularEstudiante(Estudiante estudiante) {
		String estudianteMatriculado = buscarEstudiante(estudiante);
		if(estudianteMatriculado == null) {
			estudiantes.add(estudiante);
		}
	}
	
	public double calcularPromedioCurso() {
		double promedio = 0.0;
		double suma = 0.0;
		for(int i=0;i<estudiantes.size();i++) {
			suma += estudiantes.get(i).calcularPromedioNotasEstudiante();
		}
		if(estudiantes.size() > 0) {
			promedio = suma / estudiantes.size();
		}
		return promedio;
	}
	
	public void mostrar() {
		for(int i=0; i<estudiantes.size();i++) {
			estudiantes.get(i).mostrar();
		}
	}
}
