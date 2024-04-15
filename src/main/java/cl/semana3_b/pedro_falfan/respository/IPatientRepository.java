package cl.semana3_b.pedro_falfan.respository;

import cl.semana3_b.pedro_falfan.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<PatientModel, Long> {
}
