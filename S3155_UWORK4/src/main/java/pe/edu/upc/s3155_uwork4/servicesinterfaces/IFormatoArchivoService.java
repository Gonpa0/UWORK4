package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;

import java.util.List;

public interface IFormatoArchivoService {
    public List<FormatoArchivo> listar();
    public void Registrar(FormatoArchivo fa);
    public FormatoArchivo listarporid(int id);
    public void Modificar(FormatoArchivo fa);
    public void Eliminar(int id);
}
