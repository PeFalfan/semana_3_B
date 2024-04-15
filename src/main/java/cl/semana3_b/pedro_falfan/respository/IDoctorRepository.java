package cl.semana3_b.pedro_falfan.respository;

import cl.semana3_b.pedro_falfan.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<DoctorModel, Long> {
}
