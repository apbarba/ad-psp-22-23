package com.salesianostriana.dam.springdata;

import com.salesianostriana.dam.springdata.model.Alumno;
import com.salesianostriana.dam.springdata.model.Curso;
import com.salesianostriana.dam.springdata.repos.AlumnoRepository;
import com.salesianostriana.dam.springdata.service.AlumnoService;
import com.salesianostriana.dam.springdata.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final AlumnoService service;
    private final CursoService cursoService;

    @PostConstruct
    public void test() {

        Curso dam2 = Curso.builder()
                .nombre("2º DAM")
                .tutor("Luismi")
                .alumnos(new ArrayList<>())
                .build();

        cursoService.save(dam2);

        Alumno alumno = Alumno.builder()
                .nombre("Luismi")
                .apellidos("López")
                .email("luismi.lopez@salesianos.edu")
                //.curso(dam2)
                .build();

        //dam2.getAlumnos().add(alumno);

        alumno.addCurso(dam2);

        service.save(alumno);

        System.out.printf("%s, %s\n", alumno.getNombre(), alumno.getCurso().getNombre());

        System.out.println("Nº de alumnos en el curso:" + dam2.getAlumnos().size());

        alumno.removeCurso(dam2);

        service.save(alumno);

        System.out.printf("%s, %s\n", alumno.getNombre(), alumno.getCurso() != null ? alumno.getCurso().getNombre() : "Sin curso");

        System.out.println("Nº de alumnos en el curso:" + dam2.getAlumnos().size());

        System.out.println(dam2);

    }

}
