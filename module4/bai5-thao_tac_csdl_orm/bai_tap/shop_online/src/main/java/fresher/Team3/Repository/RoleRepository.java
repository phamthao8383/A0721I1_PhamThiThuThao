package fresher.Team3.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import fresher.Team3.Enities.RolesEnity;





public interface RoleRepository extends JpaRepository<RolesEnity, Integer> {

    RolesEnity findByName(String name);

}
