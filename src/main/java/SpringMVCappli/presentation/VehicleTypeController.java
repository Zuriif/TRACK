package SpringMVCappli.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringMVCappli.dao.entities.VehicleType;
import SpringMVCappli.service.VehicleTypeService;

@Controller
@RequestMapping("/admin/vehicles")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping
    public String getVehicleTypesPage(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.getAllVehicleTypes());
        return "vehicle_types";
    }

    @GetMapping("/add")
    public String getAddVehicleTypePage(Model model) {
        return "add_vehicle_type";
    }

    @PostMapping("/add")
    public String addVehicleType(@RequestParam String typeName) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName(typeName);
        vehicleTypeService.addVehicleType(vehicleType);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String getEditVehicleTypePage(@PathVariable Long id, Model model) {
        VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
        model.addAttribute("vehicleType", vehicleType);
        return "edit_vehicle_type";
    }

    @PostMapping("/edit")
    public String editVehicleType(@RequestParam Long id, @RequestParam String typeName) {
        VehicleType vehicleType = vehicleTypeService.getVehicleTypeById(id);
        vehicleType.setTypeName(typeName);
        vehicleTypeService.updateVehicleType(vehicleType);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicleType(@PathVariable Long id) {
        vehicleTypeService.deleteVehicleTypeById(id);
        return "redirect:/admin/vehicles";
    }
}
