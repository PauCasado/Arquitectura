package repository;

import entities.Carrera;
import entities.Estudiante;
import entities.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula>{

	void update(Matricula matricula, int idEstudiante, int idCarrera);
	Matricula getMatricula(int idEstudiante, int idCarrera);

}
