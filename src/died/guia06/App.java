package died.guia06;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Curso c1 = new Curso(1, "DIED", 2019, 2, 6, 2); // id, nombre, ciclo, cupos, creditos, credReq
		
		Curso c2 = new Curso(2, "AppMoviles", 2019, 2, 2, 1); //2 cupos
		Curso c3 = new Curso(3, "Economia", 2019, 3, 6, 3);   // 3 cupos
		Curso c4 = new Curso(4, "Legislacion", 2019, 2, 6, 4); // 2 cupos
		Curso c5 = new Curso(5, "Algoritmos", 2019, 2, 5,1); //2 cupos 
		Curso c6 = new Curso(6, "AMI", 2019, 2, 3, 0);
		Curso c7 = new Curso(7, "AGA", 2019, 2, 3, 0);
		Curso c8 = new Curso(8, "FISICA", 2019, 3, 3, 0);
		
		Alumno a1 = new Alumno("Pedro", 2);
		List<Curso> aprobados1 = new ArrayList<Curso>();
		aprobados1.add(c4);
		aprobados1.add(c5);
		a1.setAprobados(aprobados1);
		c1.inscribir(a1);
		c3.inscribir(a1);
		c6.inscribir(a1);
		
		System.out.println("creditos obtenidos por alumno Pedro NL:2 : " + a1.creditosObtenidos());
		
		Alumno a2= new Alumno("Pablo", 3);
		List<Curso> aprobados2 = new ArrayList<Curso>();
		aprobados2.add(c5);
		c6.inscribir(a2);
		c7.inscribir(a2);
		c8.inscribir(a2);
		
		Alumno a3 = new Alumno ("Julia", 4);
		List<Curso> aprobados3 = new ArrayList<Curso>();
		aprobados3.add(c6);
		c7.inscribir(a3);
		c8.inscribir(a3);
		
		Alumno a4 = new Alumno("Maria", 5);
		List<Curso> aprobados4 = new ArrayList<Curso>();
		aprobados4.add(c4);
		aprobados4.add(c5);
		a1.setAprobados(aprobados4);
		c1.inscribir(a4);
		c7.inscribir(a4);
		c8.inscribir(a4);	
		
		System.out.println("Creditos obtenidos por el alumno Pablo, NL:3 :" + a2.creditosObtenidos());
		
		a1.aprobar(c1);
		a1.aprobar(c3);
		a2.aprobar(c6);
		a2.aprobar(c7);
		
		c6.imprimirInscriptosPorNombre();
		c1.imprimirInscriptosPorLibreta();
		c7.imprimirInscriptosPorCreditos();
		
		
	}
}
