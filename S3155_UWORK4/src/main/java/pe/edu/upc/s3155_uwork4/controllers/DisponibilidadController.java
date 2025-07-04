package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.DisponibilidadDTO;
import pe.edu.upc.s3155_uwork4.entities.Disponibilidad;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IDisponibilidadService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private IDisponibilidadService iDisponibilidadService;

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTEINFERIOR')or hasAuthority('ESTUDIANTESUPERIOR')")
    @GetMapping
    public List<DisponibilidadDTO> Listar() {
        return iDisponibilidadService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,DisponibilidadDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR')")
    @PostMapping
    public void Registrar(@RequestBody DisponibilidadDTO dto){
        ModelMapper m = new ModelMapper();
        Disponibilidad d = m.map(dto, Disponibilidad.class);
        iDisponibilidadService.Registrar(d);

    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR')")
    @GetMapping("/{id}")
    public DisponibilidadDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        DisponibilidadDTO dto = m.map(iDisponibilidadService.listarporid(id),DisponibilidadDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR')")
    @PutMapping
    public void Modificar(@RequestBody DisponibilidadDTO dto){
        ModelMapper m = new ModelMapper();
        Disponibilidad d = m.map(dto,Disponibilidad.class);
        iDisponibilidadService.Modificar(d);

    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR')")
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        iDisponibilidadService.Eliminar(id);
    }


    //METODO PARA EL QUERY BUSCAR POR FECHA Y USUARIO
    @GetMapping("/usuario/{id}/fecha/{fecha}")
    public List<DisponibilidadDTO> obtenerDisponibilidadesPorFecha(@PathVariable("id") int idUsuario,
                                                                   @PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return iDisponibilidadService.buscarPorUsuarioYFecha(idUsuario, fecha).stream().map(d -> {
            ModelMapper m = new ModelMapper();
            return m.map(d, DisponibilidadDTO.class);
        }).collect(Collectors.toList());
    }

}
