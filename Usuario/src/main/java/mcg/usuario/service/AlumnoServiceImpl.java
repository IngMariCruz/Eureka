package mcg.usuario.service;

import jakarta.transaction.Transactional;
import com.mcg.commonsService.usuario.models.entity.Alumno;
import mcg.usuario.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    AlumnoRepository dao;
    @Override
    @Transactional
    public Iterable<Alumno> findAll(){
        return dao.findAll();
    }

    @Override
    @Transactional
    public Optional<Alumno> findById(Long id){
        return dao.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return dao.save(alumno);
    }

    @Override
    @Transactional
    public void deletedById(Long id) {
        dao.deleteById(id);
    }

}
