package com.educonecta.mapper;

import com.educonecta.dto.LegalGuardianRequest;
import com.educonecta.dto.LegalGuardianResponse;
import com.educonecta.entity.LegalGuardian;
import org.springframework.stereotype.Component;

@Component
public class LegalGuardianMapper {

    public LegalGuardian toEntity(LegalGuardianRequest req) {
        LegalGuardian g = new LegalGuardian();
        g.setDni(req.getDni());
        g.setNombre(req.getNombre());
        g.setApellido(req.getApellido());
        g.setTelefono(req.getTelefono());
        g.setEmail(req.getEmail());
        g.setDireccion(req.getDireccion());
        return g;
    }

    public void updateEntity(LegalGuardian g, LegalGuardianRequest req) {
        g.setDni(req.getDni());
        g.setNombre(req.getNombre());
        g.setApellido(req.getApellido());
        g.setTelefono(req.getTelefono());
        g.setEmail(req.getEmail());
        g.setDireccion(req.getDireccion());
    }

    public LegalGuardianResponse toResponse(LegalGuardian g) {
        LegalGuardianResponse r = new LegalGuardianResponse();
        r.setLegalGuardianId(g.getLegalGuardianId());
        r.setDni(g.getDni());
        r.setNombre(g.getNombre());
        r.setApellido(g.getApellido());
        r.setTelefono(g.getTelefono());
        r.setEmail(g.getEmail());
        r.setDireccion(g.getDireccion());
        r.setFechaRegistro(g.getFechaRegistro());
        r.setIsActive(g.getIsActive());
        return r;
    }
}