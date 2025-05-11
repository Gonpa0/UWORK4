package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ComentarioArticuloDTO;
import pe.edu.upc.s3155_uwork4.entities.ComentarioArticulo;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IComentarioArticuloService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentariosarticulo")
public class ComentarioArticuloController {
    @Autowired
    private IComentarioArticuloService comentarioArticuloService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public List<ComentarioArticuloDTO> Listar() {
        return comentarioArticuloService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ComentarioArticuloDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Registrar(@RequestBody ComentarioArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        ComentarioArticulo cA = m.map(dto,ComentarioArticulo.class);
        comentarioArticuloService.Registrar(cA);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public ComentarioArticuloDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ComentarioArticuloDTO dto = m.map(comentarioArticuloService.listarporid(id),ComentarioArticuloDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Modificar(@RequestBody ComentarioArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        ComentarioArticulo cA = m.map(dto,ComentarioArticulo.class);
        comentarioArticuloService.Modificar(cA);

    }
    @DeleteMapping( "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Eliminar(@PathVariable("id") int id){
        comentarioArticuloService.Eliminar(id);
    }
}
