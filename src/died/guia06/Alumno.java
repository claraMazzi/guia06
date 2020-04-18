package died.guia06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno(String n, int i) {
		this.nombre=n;
		this.nroLibreta=i;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}

	public Alumno() {
		this.nombre=null;
		this.nroLibreta=null;
	}

	public int creditosObtenidos() { //suma de los créditos que otorgan los cursos que ya aprobó
		int retorno=0;
		for (Curso c : this.aprobados) {
			retorno += c.getCreditos();
		}
		return retorno;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(this.cursando.indexOf(c)); // saco el curso de la lista de cursando 
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
		
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}
	
	public void agregarCurso (Curso c) {
		this.cursando.add(c);
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	@Override
	public boolean equals(Object o) {
	if (o instanceof Alumno) {
		return this.nroLibreta == ((Alumno) o).nroLibreta;
	 }
	 
		return false;
		
	}
	

	public int compareTo(Alumno arg0) {
		
		return Comparators.NOMBRE.compare(this, arg0);
	}

	public static class Comparators {
		public static final Comparator<Alumno> NOMBRE = (Alumno a1, Alumno a2) -> a1.nombre.compareTo(a2.nombre);
		public static final Comparator<Alumno> LIBRETA = (Alumno a1, Alumno a2) -> a1.nroLibreta.compareTo(a2.nroLibreta);
		public static final Comparator<Alumno> CREDITOS = (Alumno a1, Alumno a2)-> Integer.compare(a1.creditosObtenidos(), a2.creditosObtenidos());
				
			
	}

	

}
