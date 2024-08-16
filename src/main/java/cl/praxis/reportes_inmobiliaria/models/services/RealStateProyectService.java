package cl.praxis.reportes_inmobiliaria.models.services;

import cl.praxis.reportes_inmobiliaria.models.entities.RealStateProyect;

import java.util.List;

public interface RealStateProyectService {
    List<RealStateProyect> findAll();
    RealStateProyect findById(Integer id);
    RealStateProyect create(RealStateProyect realStateProyect);
    RealStateProyect update(RealStateProyect realStateProyect);
    void delete(Integer id);
}
