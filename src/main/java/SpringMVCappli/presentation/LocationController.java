package SpringMVCappli.presentation;

import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getUserLocations(@RequestParam Long userId) {
        return locationService.getUserLocations(userId);
    }

    @GetMapping("/latest")
    public Location getLatestLocation(@RequestParam Long userId) {
        return locationService.getLatestLocation(userId);
    }
}
