package SpringMVCappli.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringMVCappli.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
