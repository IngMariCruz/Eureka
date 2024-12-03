package mcg.usuario.service;

import com.mcg.common.service.CommonService;
import com.mcg.commonsService.usuario.models.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno> {
    public Alumno save(Alumno alumno);
    public void deletedById (Long id);
}
