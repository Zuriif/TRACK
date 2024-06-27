package SpringMVCappli.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringMVCappli.dao.entities.Tracker;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {
    List<Tracker> findByUserId(Long userId);
}
