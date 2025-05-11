package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Notificacion;
import pe.edu.upc.s3155_uwork4.repositories.INotificacionRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.INotificacionService;

import java.util.List;

@Service
public class    NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepository nR;
    @Override
    public List<Notificacion> listar() {
        return nR.findAll();
    }

    @Override
    public void Registrar(Notificacion n) {
        nR.save(n);
    }

    @Override
    public Notificacion listarporid(int id) {
        return nR.findById(id).orElse(new Notificacion());
    }

    @Override
    public void Modificar(Notificacion n) {
        nR.save(n);
    }

    @Override
    public void Eliminar(int id) {
        nR.deleteById(id);
    }

    @Override
    public List<String[]> ComparacionPorGrupoCicloPromedioNotificaciones() {
        return nR.ComparacionPorGrupoCicloPromedioNotificaciones();
    }


}
