package SpringMVCappli.service;

import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.dao.entities.Tracker;
import SpringMVCappli.dao.entities.User;
import SpringMVCappli.dao.repositories.LocationRepository;
import SpringMVCappli.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<Location> getUserLocations(Long userId) {
        return locationRepository.findByTracker_UserId(userId);
    }

    public Location getLastLocation(Long trackerId) {
        Tracker tracker = new Tracker();
        tracker.setId(trackerId);
        return locationRepository.findTopByTrackerOrderByTimestampDesc(tracker);
    }

    public List<User> getAllUsersWithTrackers() {
        // Assuming all users have trackers for simplicity
        return userRepository.findAll();
    }
}
