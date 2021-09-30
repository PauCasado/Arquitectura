package repository;

import entities.Carrera;

public interface CarreraRepository extends CrudRepository<Carrera> {
		int getId(Carrera carrera);

}
