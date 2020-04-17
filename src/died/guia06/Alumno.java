package died.guia06;

import java.util.List;


public class Alumno implements Comparable{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}

	public void inscripcionAceptada(Curso c) {
		//
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
	

	public int compareTo(Object arg0) {
		int retorno=3; 
		if(arg0 instanceof Alumno) {
			
			if(this.nombre.compareTo(((Alumno) arg0).getNombre())==0 ) {
				retorno = 0;
			}
			else if(this.nombre.compareTo(((Alumno) arg0).getNombre())>0) {
				retorno = 1;
			} else {
				retorno=-1;
			}
		}
		return retorno;
	}
	
	

}
