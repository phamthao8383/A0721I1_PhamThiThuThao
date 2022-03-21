package fresher.Team3.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import fresher.Team3.Enities.UsersEnity;

public interface UserRepository extends JpaRepository<UsersEnity, Integer> {

	UsersEnity findByEmail(String email);

	List<UsersEnity> findByNameContaining(String name);

	Page<UsersEnity> findByNameContaining(String name, Pageable page);

}
