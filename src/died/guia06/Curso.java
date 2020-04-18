package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer id, String n, Integer ciclo, Integer cupo, Integer creditos, Integer credReq) {
		this.id = id;
		this.nombre = n;
		this.cicloLectivo = ciclo;
		this.cupo = cupo;
		this.creditos = creditos; 		
		this.creditosRequeridos = credReq;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	public Registro getLog() {
		return log;
	}


	public void setLog(Registro log) {
		this.log = log;
	}


	/**
	 * Este mÃ©todo, verifica si el alumno se puede inscribir y si es asÃ­ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que estÃ¡ inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno estÃ¡ inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultÃ¡neo a no mÃ¡s de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		
		if (a.creditosObtenidos()>= this.creditosRequeridos) {//Verifico que tenga los creditos necesarios 
			if (this.inscriptos.size()<this.cupo) { //verifico si quedan cupos disponibles 
				if ((a.getCursando()).size()<3) { //verifico que no esté inscripto al menos en 3 cursos
					try {
						log.registrar(this, "inscribir ",a.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.inscriptos.add(a);
					a.agregarCurso(this);
					return true;
				} else return false;
			} else return false;
			
		} else return false;
		
		
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptosPorNombre() {
		List<Alumno> lista = this.inscriptos;
		Collections.sort(lista, Alumno.Comparators.NOMBRE);
		System.out.println("alumnos por orden alfabetico: \n");
		for (Alumno a: lista) {
			System.out.println(a.getNombre());
		}
		
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirInscriptosPorLibreta() {
		List<Alumno> lista = this.inscriptos;
		Collections.sort(lista, Alumno.Comparators.LIBRETA);
		System.out.println("alumnos ordenados por n° de libreta \n");
		for (Alumno a: lista) {
			System.out.println(a.getNroLibreta() + " " + a.getNombre() + "\n");
		}
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void imprimirInscriptosPorCreditos() {
		List<Alumno> lista = this.inscriptos;
		Collections.sort(lista, Alumno.Comparators.CREDITOS);
		System.out.println("alumnos ordenados por creditos obtenidos \n");
		for (Alumno a: lista) {
			System.out.println(a.creditosObtenidos() + " " + a.getNombre()+ "\n");
		}
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/*
	 * Agregar a curso el método
		- public void inscribirAlumno(Alumno a) { … }
		Este método ejecutará correctamente si el alumno se pudo inscribir. Caso contrario lanzará una excepción personalizada para cada una de las siguientes situaciones:
			- Una excepción si el alumno no tiene los creditos requeridos
			- Una excepción que represente que el curso tiene el cupo cubierto
			- Una excepción que represente que el alumno ya tiene todas las materias de cursado regular.
			- Además este método debe capturar la excepción de entrada salida de la clase registro y en caso de que ocurra relanzarla como una nueva excepción del tipo personalizado “RegistroAuditoriaException”
	 */
	
public void inscribirAlumno(Alumno a) throws Exception {
		
		if (a.creditosObtenidos()< this.creditosRequeridos) {//Verifico que no tenga los creditos necesarios 
			throw new creditosIncecesarios("CREDITOS INECESARIOS");
		} else if (this.inscriptos.size()>this.cupo) { //verifico si quedan cupos disponibles 
					throw new NoHayCuposDisponibles("NO HAY CUPOS DISPONIBLES");
				}
				else if ((a.getCursando()).size()>=3) { //verifico que no esté inscripto al menos en 3 cursos
			throw new InscriptoEnMasDe3Cursos("ALUMNO INSCRIPTO EN MAS DE 3 CURSOS");
				} else this.inscribir(a);
					
		try {
		log.registrar(this, "inscribir ",a.toString());
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RegistroAuditoriaException();
		}
		this.inscriptos.add(a);
		a.agregarCurso(this);	
	}
	
	

}
