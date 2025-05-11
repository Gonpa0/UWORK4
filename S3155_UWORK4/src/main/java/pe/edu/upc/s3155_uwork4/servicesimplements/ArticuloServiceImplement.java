package pe.edu.upc.s3155_uwork4.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.entities.Articulo;
import pe.edu.upc.s3155_uwork4.repositories.IArticuloRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArticuloService;

import java.util.List;

@Service
public class ArticuloServiceImplement implements IArticuloService {

    @Autowired
    private IArticuloRepository articuloRepository;

    @Override
    public List<Articulo> listar() {
        return articuloRepository.findAll();
    }

    @Override
    public void Registrar(Articulo ar) {
    articuloRepository.save(ar);
    }

    @Override
    public Articulo listarporid(int id) {
        return articuloRepository.findById(id).orElse(new Articulo());
    }

    @Override
    public void Modificar(Articulo ar) {
    articuloRepository.save(ar);
    }

    @Override
    public void Eliminar(int id) {
    articuloRepository.deleteById(id);
    }

    //QUERYS

    @Override
    public List<Articulo> buscarPorPalabraClave(String keyword) {
        return articuloRepository.buscarPorPalabraClave(keyword);
    }

}
