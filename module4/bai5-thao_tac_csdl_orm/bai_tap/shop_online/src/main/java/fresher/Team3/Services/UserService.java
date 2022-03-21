package fresher.Team3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import fresher.Team3.Enities.UsersEnity;


@Service
public interface UserService {
	
	List<UsersEnity> getAllUser();

	void saveUser(UsersEnity usersEnity);

	void deleteUser(Integer id);

	Optional<UsersEnity> findUserById(Integer id);

	Page<UsersEnity> findAll(Pageable pageable);

	Page<UsersEnity> findByNameContaining(String name, Pageable page);

	List<UsersEnity> findByNameContaining(String name);

}
