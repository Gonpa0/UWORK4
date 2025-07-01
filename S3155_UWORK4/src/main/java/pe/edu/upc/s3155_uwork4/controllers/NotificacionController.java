package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.NotificacionDTO;
import pe.edu.upc.s3155_uwork4.dtos.PromedioNotificacionesDTO;
import pe.edu.upc.s3155_uwork4.entities.Notificacion;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.INotificacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public List<NotificacionDTO> Listar() {
        return nS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Registrar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto,Notificacion.class);
        nS.Registrar(n);

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public NotificacionDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listarporid(id),NotificacionDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto,Notificacion.class);
        nS.Modificar(n);

    }
    @DeleteMapping( "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Eliminar(@PathVariable("id") int id){
        nS.Eliminar(id);
    }


    @GetMapping ("/promedio_notificacion")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public List<PromedioNotificacionesDTO> ComparacionPorGrupoCicloPromedioNotificaciones()
    {
        List<String[]> lista= nS.ComparacionPorGrupoCicloPromedioNotificaciones();
        List<PromedioNotificacionesDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            PromedioNotificacionesDTO dto=new PromedioNotificacionesDTO();
            dto.setGrupo_ciclo((columna[0]));
            dto.setTotal_notificaciones(Integer.parseInt(columna[1]));
            dto.setTotal_usuarios(Integer.parseInt(columna[2]));
            dto.setPromedioNotificacionUsuario(Double.parseDouble(columna[3]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
}
