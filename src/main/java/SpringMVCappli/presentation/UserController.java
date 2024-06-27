package SpringMVCappli.presentation;

import SpringMVCappli.dao.entities.User;
import SpringMVCappli.service.Userservice;
import SpringMVCappli.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private Userservice userService;

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public String getUsersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String getAddUserPage(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.getAllVehicleTypes());
        return "add_user";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String status, @RequestParam Long vehicleTypeId) {
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setStatus(status);
        user.setVehicleType(vehicleTypeService.getVehicleTypeById(vehicleTypeId));
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditUserPage(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("vehicleTypes", vehicleTypeService.getAllVehicleTypes());
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam Long id, @RequestParam String name, @RequestParam String phoneNumber, @RequestParam String status, @RequestParam Long vehicleTypeId) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setStatus(status);
        user.setVehicleType(vehicleTypeService.getVehicleTypeById(vehicleTypeId));
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}
