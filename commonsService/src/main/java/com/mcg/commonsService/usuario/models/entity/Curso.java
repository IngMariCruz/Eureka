package com.mcg.commonsService.usuario.models.entity;

import com.mcg.commonsService.usuario.models.entity.Alumno;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @PrePersist
    private void prePersist(){
        this.createAt = new Date();
    }
    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> listaAlumno;

    public Curso() {
        this.listaAlumno = new ArrayList<>();
    }
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setListaAlumno(List<Alumno> listaAlumno){
        this.listaAlumno = listaAlumno;
    }

    public List<Alumno> getListaAlumno() {
        return listaAlumno;
    }

    public void addAlumno(Alumno alumno){
        this.listaAlumno.add(alumno);
    }

    public void removeAlumnos(Alumno alumno){
        this.listaAlumno.remove(alumno);
    }

}
