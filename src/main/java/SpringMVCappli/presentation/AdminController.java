package SpringMVCappli.presentation;

import SpringMVCappli.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Userservice userService;

    @Autowired
    public AdminController(Userservice userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAdminPage(Model model) {
        model.addAttribute("users", userService.getAllUsersWithTrackers());
        return "admin";
    }
}
