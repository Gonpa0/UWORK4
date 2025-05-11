package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.RolDTO;
import pe.edu.upc.s3155_uwork4.entities.Rol;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping( "/rol")
public class RolController {
    @Autowired
    private IRolService rS;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<RolDTO> Listar() {
        return rS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RolDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void Registrar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto,Rol.class);
        rS.Registrar(r);

    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public RolDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.listarporid(id),RolDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void Modificar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto,Rol.class);
        rS.Modificar(r);

    }
    @DeleteMapping( "/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void Eliminar(@PathVariable("id") int id){
        rS.Eliminar(id);
    }
}
