package cl.praxis.reportes_inmobiliaria.models.services;

import cl.praxis.reportes_inmobiliaria.models.entities.RealStateProyect;
import cl.praxis.reportes_inmobiliaria.models.repositories.RealStateProyectRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RealStateProyectServiceImpl implements RealStateProyectService {

    private final RealStateProyectRepository realStateProyectRepository;

    public RealStateProyectServiceImpl(RealStateProyectRepository realStateProyectRepository) {
        this.realStateProyectRepository = realStateProyectRepository;
    }

    @Override
    public List<RealStateProyect> findAll() throws DataAccessException {
        try {
            return realStateProyectRepository.findAll();
        } catch (DataAccessException e) {
            System.err.println("Error al obtener todos los proyectos inmobiliarios: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public RealStateProyect findById(Integer id) throws NoSuchElementException, DataAccessException {
        try {
            return realStateProyectRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Proyecto inmobiliario no encontrado con id: " + id));
        } catch (DataAccessException e) {
            System.err.println("Error al buscar proyecto inmobiliario por ID: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public RealStateProyect create(RealStateProyect realStateProyect) throws DataAccessException {
        try {
            return realStateProyectRepository.save(realStateProyect);
        } catch (DataAccessException e) {
            System.err.println("Error al crear proyecto inmobiliario: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public RealStateProyect update(RealStateProyect realStateProyect) throws DataAccessException {
        try {
            return realStateProyectRepository.save(realStateProyect);
        } catch (DataAccessException e) {
            System.err.println("Error al actualizar proyecto inmobiliario: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Integer id) throws NoSuchElementException, DataAccessException {
        try {
            boolean exist = realStateProyectRepository.existsById(id);
            if (!exist) {
                throw new NoSuchElementException("Proyecto inmobiliario no encontrado con id: " + id);
            }
            realStateProyectRepository.deleteById(id);
        } catch (DataAccessException e) {
            System.err.println("Error al eliminar proyecto inmobiliario: " + e.getMessage());
            throw e;
        }
    }
}