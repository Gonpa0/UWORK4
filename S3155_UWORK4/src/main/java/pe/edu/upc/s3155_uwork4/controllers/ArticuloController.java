package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ArticuloDTO;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioDTO;
import pe.edu.upc.s3155_uwork4.entities.Articulo;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArticuloService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private IArticuloService articuloService;

    @GetMapping
    public List<ArticuloDTO> Listar() {
        return articuloService.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ArticuloDTO.class);
        }).collect(Collectors.toList());
    }

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

    @PutMapping
    public void Modificar(@RequestBody ArticuloDTO dto){
        ModelMapper m = new ModelMapper();
        Articulo ar = m.map(dto,Articulo.class);
        articuloService.Modificar(ar);
    }

    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        articuloService.Eliminar(id);
    }

}
