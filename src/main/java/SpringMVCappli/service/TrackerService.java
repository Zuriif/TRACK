package SpringMVCappli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCappli.dao.entities.Tracker;
import SpringMVCappli.dao.repositories.TrackerRepository;

@Service
public class TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;

    public List<Tracker> getAllTrackers() {
        return trackerRepository.findAll();
    }

    public Tracker addTracker(Tracker tracker) {
        return trackerRepository.save(tracker);
    }

    public Tracker getTrackerById(Long id) {
        return trackerRepository.findById(id).orElse(null);
    }

    public Tracker updateTracker(Tracker tracker) {
        return trackerRepository.save(tracker);
    }

    public void deleteTrackerById(Long id) {
        trackerRepository.deleteById(id);
    }

    public List<Tracker> getTrackersByUserId(Long userId) {
        return trackerRepository.findByUserId(userId);
    }
}