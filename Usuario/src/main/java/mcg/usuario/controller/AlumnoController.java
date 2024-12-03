package mcg.usuario.controller;

import com.mcg.common.controller.CommonController;
import com.mcg.commonsService.usuario.models.entity.Alumno;
import mcg.usuario.service.AlumnoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("alumno", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        Optional<Alumno> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){

        Optional<Alumno> ob = service.findById(id);
        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoBd = ob.get();
        alumnoBd.setNombre(alumno.getNombre());
        alumnoBd.setApellido(alumno.getApellido());
        alumnoBd.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoBd));
    }

    
}
