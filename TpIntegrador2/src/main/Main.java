package main;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dto.ReporteCarrera;
import entities.Carrera;
import entities.Direccion;
import entities.Estudiante;
import entities.Matricula;
import repository.CarreraRepository;
import repository.DireccionRepository;
import repository.EstudianteRepository;
import repository.MatriculaRepository;
import repository.impl.CarreraRepositoryImpl;
import repository.impl.DireccionRepositoryImpl;
import repository.impl.EstudianteRepositoryImpl;
import repository.impl.MatriculaRepositoryImpl;

public class Main {

		public static void main(String[] args) {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Facultad");
				EntityManager em = emf.createEntityManager();

				Direccion dir1 = new Direccion("Roca", 168, "Bolivar", "Bs", "Arg");
				Direccion dir2 = new Direccion("Alvear", 555, "Bolivar", "Bs", "Arg");
				Direccion dir3 = new Direccion("Necochea", 26, "Bolivar", "Bs", "Arg");
				Direccion dir4 = new Direccion("Simon Bolivar", 0, "Bolivar", "Bs", "Arg");
				Estudiante es1 = new Estudiante("Pedrito Lopez", 21, "Masc", 5, dir1, 1234 );
				Estudiante es2 = new Estudiante("Ana Montana", 19, "Fem", 6, dir1, 567 );
				Estudiante es3 = new Estudiante("Carla Chocana", 19, "Fem", 7, dir1, 1111 );
				Estudiante es4 = new Estudiante("Carlitos Casanova", 35, "Masc", 8, dir1, 222 );
				Estudiante es5 = new Estudiante("Juan Casanova", 20, "Masc", 9, dir4, 222 );
				
				Carrera car1 = new Carrera("TUDAI");
				Carrera car2 = new Carrera("Ingenieria");
				Carrera car3 = new Carrera("Veterinaria");
				Matricula mat1 = new Matricula(es1,car2);
				Matricula mat2 = new Matricula(es2,car2);
				Matricula mat3 = new Matricula(es3,car3);
				Matricula mat4 = new Matricula(es4,car3);
				Matricula mat5 = new Matricula(es5,car3);
				

				DireccionRepository dirRepo = new DireccionRepositoryImpl(em);

				EstudianteRepository estRepo = new EstudianteRepositoryImpl(em);
				estRepo.create(es2);


				CarreraRepository carrRepo = new CarreraRepositoryImpl(em);
				carrRepo.create(car2);
				

				MatriculaRepository matRepo = new MatriculaRepositoryImpl(em);
				matRepo.create(mat3);
				matRepo.create(mat1);
				matRepo.create(mat2);
				matRepo.create(mat4);
				
				
				
				mat3.setFechaEgreso(1);
				matRepo.update(mat3, 7,3);
				
				System.out.println(matRepo.getMatricula(7, 3));
				
				List<Estudiante> estudiantes = new ArrayList<Estudiante>();
				estudiantes=estRepo.getAll();
				estudiantes.forEach(e -> System.out.println(e));
				
				List<Matricula> matriculas = new ArrayList<Matricula>();
				matriculas=matRepo.getAll();
				matriculas.forEach(e -> System.out.println(e));
				
				List<Carrera> carreras= new ArrayList<Carrera>();
				carreras=carrRepo.getCantidadDeInscriptosPorCarrea();
				carreras.forEach(c->System.out.println(c));

				List<Carrera> matriculasOrdenadas = new ArrayList<Carrera>();
				matriculasOrdenadas = carrRepo.getCantidadDeInscriptosPorCarrea();
				matriculasOrdenadas.forEach(m->System.out.println(m));

				List<Estudiante> estudiantesCarreraCiudad = new ArrayList<>();
				estudiantesCarreraCiudad = estRepo.getPorCiudad(car3,"bolivar" );
				estudiantesCarreraCiudad.forEach(e->System.out.println(e));
				
				List<ReporteCarrera> reporteList = (ArrayList<ReporteCarrera>) matRepo.reporteCarreras();
				for(ReporteCarrera s: reporteList) {
					System.out.println(s);
				}
				
				
				



		}

}
