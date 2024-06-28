package SpringMVCappli.presentation;

import SpringMVCappli.dao.entities.Tracker;
import SpringMVCappli.service.TrackerService;
import SpringMVCappli.service.Userservice;
import SpringMVCappli.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/trackers")
public class TrackerController {

    private final TrackerService trackerService;
    private final Userservice userService;
    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public TrackerController(TrackerService trackerService, Userservice userService, VehicleTypeService vehicleTypeService) {
        this.trackerService = trackerService;
        this.userService = userService;
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping
    public String getTrackersPage(Model model) {
        model.addAttribute("trackers", trackerService.getAllTrackers());
        return "trackers";
    }

    @GetMapping("/add")
    public String getAddTrackerPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("vehicleTypes", vehicleTypeService.getAllVehicleTypes());
        return "add_tracker";
    }

    @PostMapping("/add")
    public String addTracker(@RequestParam String name, @RequestParam String status, @RequestParam Long userId, @RequestParam Long vehicleTypeId, @RequestParam double radiusLimit) {
        Tracker tracker = new Tracker();
        tracker.setName(name);
        tracker.setStatus(status);
        tracker.setUser(userService.getUserById(userId));
        tracker.setVehicleType(vehicleTypeService.getVehicleTypeById(vehicleTypeId));
        tracker.setRadiusLimit(radiusLimit);
        trackerService.addTracker(tracker);
        return "redirect:/admin/trackers";
    }

    @GetMapping("/edit/{id}")
    public String getEditTrackerPage(@PathVariable Long id, Model model) {
        Tracker tracker = trackerService.getTrackerById(id);
        model.addAttribute("tracker", tracker);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("vehicleTypes", vehicleTypeService.getAllVehicleTypes());
        return "edit_tracker";
    }

    @PostMapping("/edit")
    public String editTracker(@RequestParam Long id, @RequestParam String name, @RequestParam String status, @RequestParam Long userId, @RequestParam Long vehicleTypeId, @RequestParam double radiusLimit) {
        Tracker tracker = trackerService.getTrackerById(id);
        tracker.setName(name);
        tracker.setStatus(status);
        tracker.setUser(userService.getUserById(userId));
        tracker.setVehicleType(vehicleTypeService.getVehicleTypeById(vehicleTypeId));
        tracker.setRadiusLimit(radiusLimit);
        trackerService.updateTracker(tracker);
        return "redirect:/admin/trackers";
    }

    @GetMapping("/delete/{id}")
    public String deleteTracker(@PathVariable Long id) {
        trackerService.deleteTrackerById(id);
        return "redirect:/admin/trackers";
    }
}
