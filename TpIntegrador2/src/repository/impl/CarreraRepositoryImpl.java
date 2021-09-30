package repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import entities.Carrera;
import repository.CarreraRepository;
import repository.CrudRepository;

public class CarreraRepositoryImpl implements CarreraRepository {
		EntityManager em;



		public CarreraRepositoryImpl(EntityManager em) {
				super();
				this.em = em;
		}

		@Override
		public void create(Carrera carrera) {
				int id = this.getId(carrera);
				em.getTransaction().begin();
				if (id ==0) {
						em.persist(carrera);

				}else {
						carrera.setIdCarrera(id);
						System.out.println("ya esta guardada");
				}
				em.getTransaction().commit();
				em.clear();


		}

		@Override
		public boolean delete(int id) {
				// TODO Auto-generated method stub
				return false;
		}

		@Override
		public boolean update(Carrera entity, int id) {
				// TODO Auto-generated method stub
				return false;
		}

		@Override
		public Carrera get(int id) {
				// TODO Auto-generated method stub
				return null;
		}

		@Override
		public List<Carrera> getAll() {
				// TODO Auto-generated method stub
				return null;
		}

		@Override
		public int getId(Carrera carrera) {
				String nombre = carrera.getNombre();
				int id = 0;
				try {
						id= (int) em.createQuery("SELECT c.idCarrera FROM Carrera c WHERE c.nombre =?1 ")
										.setParameter(1, nombre)
										.getSingleResult();
						em.clear();
				} catch (Exception e) {
						return 0;
				}
				return id;
		}



}
