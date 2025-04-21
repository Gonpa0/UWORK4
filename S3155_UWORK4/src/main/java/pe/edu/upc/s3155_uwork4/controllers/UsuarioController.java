package pe.edu.upc.s3155_uwork4.controllers;

import jakarta.persistence.SequenceGenerators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioDTO;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @GetMapping
    public List<UsuarioDTO> Listar() {
        return uS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void Registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        uS.Registrar(u);

    }
    @GetMapping("/{id}")
    public UsuarioDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarporid(id),UsuarioDTO.class);
        return dto;
    }
    @PutMapping
    public void Modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        uS.Modificar(u);

    }
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        uS.Eliminar(id);
    }

}
