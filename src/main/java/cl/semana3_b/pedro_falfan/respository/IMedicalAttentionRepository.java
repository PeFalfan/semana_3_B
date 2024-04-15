package cl.semana3_b.pedro_falfan.respository;

import cl.semana3_b.pedro_falfan.models.MedicalAttentionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalAttentionRepository extends JpaRepository<MedicalAttentionModel, Long> {
}
