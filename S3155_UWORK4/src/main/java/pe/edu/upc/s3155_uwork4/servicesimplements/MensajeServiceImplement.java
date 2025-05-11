package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Mensaje;
import pe.edu.upc.s3155_uwork4.repositories.IMensajeRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IMensajeService;

import java.util.List;
@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajeRepository mR;

    @Override
    public List<Mensaje> listar() {
        return mR.findAll();
    }

    @Override
    public void Registrar(Mensaje me){
        mR.save(me);
    }

    @Override
    public Mensaje listarporid(int id){
        return mR.findById(id).orElse(new Mensaje());
    }

    @Override
    public void Modificar(Mensaje me){
        mR.save(me);
    }

    @Override
    public void Eliminar(int id){
        mR.deleteById(id);
    }

    @Override
    public List<String[]> BusquedaPalabraMensajes() {
        return mR.BusquedaPalabraMensajes();
    }

    @Override
    public List<String[]> Mensajetarea() {
        return mR.Mensajetarea();
    }
}
