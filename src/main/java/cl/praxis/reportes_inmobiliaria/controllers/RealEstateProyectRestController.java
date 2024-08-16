package cl.praxis.reportes_inmobiliaria.controllers;

import cl.praxis.reportes_inmobiliaria.models.entities.RealStateProyect;
import cl.praxis.reportes_inmobiliaria.models.services.RealStateProyectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/projects")
public class RealEstateProyectRestController {

    private final RealStateProyectService realStateProyectService;

    public RealEstateProyectRestController(RealStateProyectService realStateProyectService){
        this.realStateProyectService = realStateProyectService;
    }

    private static final Logger logger = LoggerFactory.getLogger(RealEstateProyectRestController.class);

    @GetMapping
    public ResponseEntity<List<RealStateProyect>> findAll() {
        List<RealStateProyect> projects = realStateProyectService.findAll();

        if (projects == null || projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealStateProyect> findOne(@PathVariable("id") int id) {
        RealStateProyect rsp = realStateProyectService.findById(id);

        if (rsp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RealStateProyect> create(@RequestBody RealStateProyect realStateProyect) {
        try {
            RealStateProyect rsp = realStateProyectService.create(realStateProyect);
            return new ResponseEntity<>(rsp, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al crear proyecto inmobiliario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RealStateProyect> update(@RequestBody RealStateProyect realStateProyect, @PathVariable("id") int id) {
        try {
            realStateProyect.setId(id);
            RealStateProyect rsp = realStateProyectService.update(realStateProyect);

            if (rsp == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(rsp, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al actualizar proyecto inmobiliario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            realStateProyectService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            logger.error("Proyecto no encontrado con id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DataAccessException e) {
            logger.error("Error al eliminar proyecto inmobiliario: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
