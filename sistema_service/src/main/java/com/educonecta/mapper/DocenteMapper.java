package com.educonecta.mapper;

import com.educonecta.dto.DocenteRequest;
import com.educonecta.dto.DocenteResponse;
import com.educonecta.entity.Docente;
import org.springframework.stereotype.Component;

@Component
public class DocenteMapper {

    public Docente toEntity(DocenteRequest req) {
        Docente d = new Docente();
        d.setDni(req.getDni());
        d.setNombre(req.getNombre());
        d.setApellido(req.getApellido());
        d.setEspecialidad(req.getEspecialidad());
        d.setTelefono(req.getTelefono());
        d.setEmail(req.getEmail());
        return d;
    }

    public void updateEntity(Docente d, DocenteRequest req) {
        d.setDni(req.getDni());
        d.setNombre(req.getNombre());
        d.setApellido(req.getApellido());
        d.setEspecialidad(req.getEspecialidad());
        d.setTelefono(req.getTelefono());
        d.setEmail(req.getEmail());
    }

    public DocenteResponse toResponse(Docente d) {
        DocenteResponse r = new DocenteResponse();
        r.setDocenteId(d.getDocenteId());
        r.setDni(d.getDni());
        r.setNombre(d.getNombre());
        r.setApellido(d.getApellido());
        r.setEspecialidad(d.getEspecialidad());
        r.setTelefono(d.getTelefono());
        r.setEmail(d.getEmail());
        r.setFechaContratacion(d.getFechaContratacion());
        r.setIsActive(d.getIsActive());
        return r;
    }
}