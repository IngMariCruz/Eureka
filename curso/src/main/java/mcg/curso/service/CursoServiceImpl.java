package mcg.curso.service;

import com.mcg.common.service.CommonServiceImpl;
import com.mcg.commonsService.usuario.models.entity.Curso;
import mcg.curso.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService{

}
