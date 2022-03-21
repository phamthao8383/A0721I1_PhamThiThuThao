package fresher.Team3.Services.Imp;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fresher.Team3.Enities.RolesEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.UserRepository;
import fresher.Team3.Services.UserService;
import validation.AppException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
	@Autowired
	private UserRepository userRepository;
	


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		UsersEnity UsersEnity = userRepository.findByEmail(email);
		if (UsersEnity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		else if (UsersEnity.isEnabled()) {
			throw new UsernameNotFoundException("User disblae");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<RolesEnity> roles = UsersEnity.getRolesEnities();
		for (RolesEnity role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(UsersEnity.getEmail(), UsersEnity.getPassword(),
				grantedAuthorities);
	}

	@Override
	public void saveUser(UsersEnity usersEnity) {
		userRepository.save(usersEnity);

	}

	@Override
	public List<UsersEnity> getAllUser() {
		return (List<UsersEnity>) userRepository.findAll();
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public Optional<UsersEnity> findUserById(Integer id) {
		return userRepository.findById(id);
	}

	
	  @Override public List<UsersEnity> findByNameContaining(String name) { return
	  userRepository.findByNameContaining(name); }
	  
	  @Override public Page<UsersEnity> findByNameContaining(String name, Pageable
	  page) { return userRepository.findByNameContaining(name, page); }
	  
	  @Override public Page<UsersEnity> findAll(Pageable pageable) { return
	  userRepository.findAll(pageable); }
	 
}
