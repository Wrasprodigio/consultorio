package consultorio.com.repositories;

import consultorio.com.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    Paciente findByNome(String nome);
}
