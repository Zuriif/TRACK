package SpringMVCappli.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringMVCappli.dao.entities.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
