package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import pe.edu.upc.s3155_uwork4.entities.Archivo;

import java.util.List;

public interface IArchivoService {
    public List<Archivo> listar();
    public void Registrar(Archivo arch);
    public Archivo listarporid(int id);
    public void Modificar(Archivo arch);
    public void Eliminar(int id);

    //LISTAR ARCHIVOS POR ID DE ASESORIA - SERVIRA PARA MI COMPONENTE CHAT ASESORIA DEL FRONT END

    public List<Archivo> listarPorAsesoria(int idAsesoria);

}