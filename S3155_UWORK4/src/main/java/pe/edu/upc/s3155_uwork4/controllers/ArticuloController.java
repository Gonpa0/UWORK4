package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ArticuloDTO;
import pe.edu.upc.s3155_uwork4.dtos.BuscarporAutorDTO;
import pe.edu.upc.s3155_uwork4.entities.Articulo;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArticuloService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;

    //LIBRE NO NECESITAS NI LOGUEARTE PARA ESTE METODO
    @GetMapping
    public List<ArticuloDTO> Listar() {
        return articuloService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ArticuloDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') ")
    @PostMapping
    public void Registrar(@RequestBody ArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        Articulo ar = m.map(dto,Articulo.class);
        articuloService.Registrar(ar);
    }

    @GetMapping("/{id}")
    public ArticuloDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ArticuloDTO dto = m.map(articuloService.listarporid(id),ArticuloDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') ")
    @PutMapping
    public void Modificar(@RequestBody ArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        Articulo ar = m.map(dto,Articulo.class);
        articuloService.Modificar(ar);
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') ")
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        articuloService.Eliminar(id);
    }


    //QUERYS

    //ESTE METODO ESTA LIBRE NO NECESITA NI LOGUEARSE PARA ACCEDER ESTA LIBRE COMO EL LOGIN
    // Buscar artículos por palabra clave
    @GetMapping("/buscar")
    public List<ArticuloDTO> buscarPorPalabra(@RequestParam("keyword") String keyword) {
        return articuloService.buscarPorPalabraClave(keyword).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArticuloDTO.class);
        }).collect(Collectors.toList());
    }
    // ESTE METODO ESTA LIBRE NO NECESITA NI LOGUEARSE PARA ACCEDER ESTA LIBRE COMO EL LOGIN
    //Buscar articulo por autor
    @GetMapping ("/articulo_autor")
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    public List<BuscarporAutorDTO> buscarporAutor(@RequestParam("nombreAutor") String nombreAutor) {
        return articuloService.buscarporAutor(nombreAutor).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BuscarporAutorDTO.class);
        }).collect(Collectors.toList());

    }
}
