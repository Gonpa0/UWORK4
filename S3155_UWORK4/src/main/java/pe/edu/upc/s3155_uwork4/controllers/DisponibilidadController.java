package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.DisponibilidadDTO;
import pe.edu.upc.s3155_uwork4.entities.Disponibilidad;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IDisponibilidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private IDisponibilidadService iDisponibilidadService;

    @GetMapping
    public List<DisponibilidadDTO> Listar() {
        return iDisponibilidadService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,DisponibilidadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void Registrar(@RequestBody DisponibilidadDTO dto){
        ModelMapper m = new ModelMapper();
        Disponibilidad d = m.map(dto, Disponibilidad.class);
        iDisponibilidadService.Registrar(d);

    }

    @GetMapping("/{id}")
    public DisponibilidadDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        DisponibilidadDTO dto = m.map(iDisponibilidadService.listarporid(id),DisponibilidadDTO.class);
        return dto;
    }
    @PutMapping
    public void Modificar(@RequestBody DisponibilidadDTO dto){
        ModelMapper m = new ModelMapper();
        Disponibilidad d = m.map(dto,Disponibilidad.class);
        iDisponibilidadService.Modificar(d);

    }
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        iDisponibilidadService.Eliminar(id);
    }

}
