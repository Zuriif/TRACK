package SpringMVCappli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVCappli.dao.entities.VehicleType;
import SpringMVCappli.dao.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType addVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType getVehicleTypeById(Long id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public VehicleType updateVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public void deleteVehicleTypeById(Long id) {
        vehicleTypeRepository.deleteById(id);
    }
}
