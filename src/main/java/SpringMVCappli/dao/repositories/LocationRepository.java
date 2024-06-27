package SpringMVCappli.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.dao.entities.Tracker;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByTracker_UserId(Long userId);  // Corrected to refer to Tracker's UserId
    Location findTopByTrackerOrderByTimestampDesc(Tracker tracker);
}
