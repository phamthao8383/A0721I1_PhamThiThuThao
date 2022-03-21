package fresher.Team3.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import fresher.Team3.Enities.CategoriesEnity;

@Service
public class CategoriesService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<CategoriesEnity> findAll() {
		 return entityManager.createQuery("Select t from " + CategoriesEnity.class.getSimpleName() + " t").getResultList();
	}

}
