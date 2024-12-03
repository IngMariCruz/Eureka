package mcg.curso.controller;

import com.mcg.common.controller.CommonController;
import com.mcg.commonsService.usuario.models.entity.Alumno;
import com.mcg.commonsService.usuario.models.entity.Curso;
import mcg.curso.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}/asignar-alumno")
    public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumno, @PathVariable Long id){
        Optional<Curso> ob = service.findById(id);

        if(ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();
        alumno.forEach(a -> {
                cursoBd.addAlumno(a);

        });

        // Guardar el curso con los nuevos alumnos
        Curso cursoGuardado = service.save(cursoBd);

        // Devolver el curso con la lista de alumnos y un mensaje
        return ResponseEntity.status(HttpStatus.CREATED).body("Alumno añadido");
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();

        cursoBd.removeAlumnos(alumno);

        // Guardar el curso con los nuevos alumnos
        Curso cursoGuardado = service.save(cursoBd);

        // Obtener la lista de alumnos del curso actualizado
        List<Alumno> listaAlumnos = cursoGuardado.getListaAlumno();

        // Devolver el curso con la lista de alumnos y un mensaje
        return ResponseEntity.status(HttpStatus.CREATED).body("Alumno eliminado"
        );
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Optional<Curso> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){

        Optional<Curso> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Curso cursoBd = ob.get();
        cursoBd.setNombre(alumno.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
    }
}
