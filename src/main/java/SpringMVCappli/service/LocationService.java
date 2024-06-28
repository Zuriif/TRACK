package SpringMVCappli.service;

import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.dao.entities.User;
import SpringMVCappli.dao.repositories.LocationRepository;
import SpringMVCappli.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    public List<Location> getUserLocations(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return locationRepository.findByUser(user);
    }

    public Location getLatestLocation(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return locationRepository.findTopByUserOrderByTimestampDesc(user);
    }

    public Location getLatestLocationByTracker(Long trackerId) {
        return locationRepository.findTopByTrackerIdOrderByTimestampDesc(trackerId);
    }
}
