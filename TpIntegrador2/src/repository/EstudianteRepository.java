package repository;

import java.util.List;

import entities.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante>{

		Estudiante getEstudianteByLibreta(int libreta);
		List<Estudiante> getEstudianteByGenero(String genero);
		int getId(Estudiante e);


}
