package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.NotificacionDTO;
import pe.edu.upc.s3155_uwork4.entities.Notificacion;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;
    @GetMapping
    public List<NotificacionDTO> Listar() {
        return nS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void Registrar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto,Notificacion.class);
        nS.Registrar(n);

    }
    @GetMapping("/{id}")
    public NotificacionDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listarporid(id),NotificacionDTO.class);
        return dto;
    }
    @PutMapping
    public void Modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto,Notificacion.class);
        nS.Modificar(n);

    }
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        nS.Eliminar(id);
    }
}
