package cl.praxis.reportes_inmobiliaria.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "t_real_state_proyect")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealStateProyect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "real_state_proyect_id")
    private int id;
    private String name;
    private String address;
    private String description;
    private float price;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private String status;
}
