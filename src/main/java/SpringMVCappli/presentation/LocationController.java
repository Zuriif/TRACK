package SpringMVCappli.presentation;

import SpringMVCappli.dao.entities.Location;
import SpringMVCappli.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private Userservice userService;

    @GetMapping
    public List<Location> getUserLocations(@RequestParam Long userId) {
        return userService.getUserLocations(userId);
    }
}
