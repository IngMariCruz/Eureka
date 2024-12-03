package mcg.usuario.repository;

import com.mcg.commonsService.usuario.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
