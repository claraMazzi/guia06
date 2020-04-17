package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testCreditosObtenidos() {
		 Curso c1 = new Curso();
	        Curso c2 = new Curso();
	        c1.setCreditos(5);
	        c2.setCreditos(7);
	        Alumno a = new Alumno("Juan", 1);
	        List<Curso> lista = new ArrayList<Curso>();
	        lista.add(c1);
	        lista.add(c2);
	        a.setAprobados(lista);

	        assertEquals(12, a.creditosObtenidos(), "exito");
	}

	@Test
	void testAprobar() {
		Curso c1 = new Curso();
        c1.setNombre("DIED");
        Curso c2 = new Curso();
        List<Curso> listaAlumno = new ArrayList<Curso>();
        List<Curso> lista1 = new ArrayList<Curso>();
        List<Curso> lista2 = new ArrayList<Curso>();
        listaAlumno.add(c1);
        listaAlumno.add(c2);
        lista1.add(c1);
        lista2.add(c2);
        Alumno a = new Alumno("Juan", 1);
        a.setCursando(listaAlumno);

        a.aprobar(c1);

        assertEquals(lista1, a.getAprobados());
        assertEquals(lista2, a.getCursando());
	}

	@Test
	void testInscripcionAceptada() {
		Curso c1 = new Curso();
        c1.setNombre("DIED");
        List<Curso> lista = new ArrayList<Curso>();
        Alumno a1 = new Alumno("pedro", 1);

        a1.inscripcionAceptada(c1);

        assertTrue(a1.getCursando().contains(c1));
	}

}
