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
		Curso c6 = new Curso(6, "AMI", 2019, 2, 1, 0);
		
		Alumno a1 = new Alumno("Pedro", 2);
		List<Curso> cursando1 = new ArrayList<Curso>();
		List<Curso> aprobados1 = new ArrayList<Curso>();
		cursando1.add(c3);
		cursando1.add(c6);
		aprobados1.add(c4);
		aprobados1.add(c5);
		a1.setCursando(cursando1);
		a1.setAprobados(aprobados1);
		
		
		Alumno a2= new Alumno("Pablo", 3);
		List<Curso> cursando2 = new ArrayList<Curso>();
		List<Curso> aprobados2 = new ArrayList<Curso>();
		cursando2.add(c2);
		cursando2.add(c3);
		cursando2.add(c4);
		aprobados2.add(c5);		
		
		//alumno que le faltan creditos
		Alumno a3 = new Alumno ("Julia", 4);
		List<Curso> aprobados3 = new ArrayList<Curso>();
		aprobados3.add(c6);
		
		Alumno a4 = new Alumno("Maria", 5);
		List<Curso> cursando4 = new ArrayList<Curso>();
		List<Curso> aprobados4 = new ArrayList<Curso>();
		cursando4.add(c3);
		cursando4.add(c6);
		aprobados4.add(c4);
		aprobados4.add(c5);
		a1.setCursando(cursando4);
		a1.setAprobados(aprobados4);

		
		//alumno que cumple los requisitos y no hay cupo 
		Alumno a5 = new Alumno("Clara", 6);
		List<Curso> cursando5 = new ArrayList<Curso>();
		List<Curso> aprobados5 = new ArrayList<Curso>();
		cursando5.add(c3);
		cursando5.add(c6);
		aprobados5.add(c4);
		aprobados5.add(c5);
		a1.setCursando(cursando5);
		a1.setAprobados(aprobados5);
		
		
	}
}
