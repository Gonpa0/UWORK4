package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ArticuloDTO;
import pe.edu.upc.s3155_uwork4.entities.Articulo;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArticuloService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public List<ArticuloDTO> Listar() {
        return articuloService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ArticuloDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Registrar(@RequestBody ArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        Articulo ar = m.map(dto,Articulo.class);
        articuloService.Registrar(ar);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public ArticuloDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ArticuloDTO dto = m.map(articuloService.listarporid(id),ArticuloDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Modificar(@RequestBody ArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        Articulo ar = m.map(dto,Articulo.class);
        articuloService.Modificar(ar);
    }

    @DeleteMapping( "/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Eliminar(@PathVariable("id") int id){
        articuloService.Eliminar(id);
    }


    //QUERYS

    // Buscar artículos por palabra clave
    @GetMapping("/buscar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public List<ArticuloDTO> buscarPorPalabra(@RequestParam("keyword") String keyword) {
        return articuloService.buscarPorPalabraClave(keyword).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArticuloDTO.class);
        }).collect(Collectors.toList());
    }
}
