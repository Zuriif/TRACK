package SpringMVCappli.dao.repositories;

import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUser(User user);
    Location findTopByUserOrderByTimestampDesc(User user); // Ajoutez cette méthode
    Location findTopByTrackerIdOrderByTimestampDesc(Long trackerId); // Ajoutez cette méthode
}
