package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Disponibilidad;
import pe.edu.upc.s3155_uwork4.repositories.IDisponibilidadRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IDisponibilidadService;

import java.util.List;

@Service
public class DisponibilidadServiceImplement implements IDisponibilidadService {

    @Autowired
    private IDisponibilidadRepository iDisponibilidadRepository;

    @Override
    public List<Disponibilidad> listar() {
        return iDisponibilidadRepository.findAll();
    }

    @Override
    public void Registrar(Disponibilidad disponibilidad) {
    iDisponibilidadRepository.save(disponibilidad);
    }

    @Override
    public Disponibilidad listarporid(int id) {
        return iDisponibilidadRepository.findById(id).orElse(new Disponibilidad());
    }

    @Override
    public void Modificar(Disponibilidad disponibilidad) {
    iDisponibilidadRepository.save(disponibilidad);
    }

    @Override
    public void Eliminar(int id) {
    iDisponibilidadRepository.deleteById(id);
    }
}
