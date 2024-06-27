package SpringMVCappli.dao.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private Double latitude;
    private Double longitude;
    private LocalDateTime lastUpdated;
    private Double radiusLimit;

    @ManyToOne
    private User user;

    @ManyToOne
    private VehicleType vehicleType;

    // Getters and Setters
}
