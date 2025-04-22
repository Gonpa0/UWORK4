package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioPremioDTO;
import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioPremioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuariopremio")
public class UsuarioPremioController {

    @Autowired
    private IUsuarioPremioService uPS;

    // Listar todos los registros de UsuarioPremio
    @GetMapping
    public List<UsuarioPremioDTO> Listar() {
        return uPS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioPremioDTO.class);
        }).collect(Collectors.toList());
    }

    // Registrar un nuevo UsuarioPremio
    @PostMapping
    public void Registrar(@RequestBody UsuarioPremioDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioPremio uP = m.map(dto, UsuarioPremio.class);
        uPS.Registrar(uP);
    }

    // Obtener un registro de UsuarioPremio por id
    @GetMapping("/{id}")
    public UsuarioPremioDTO Listarporid(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioPremioDTO dto = m.map(uPS.listarporid(id), UsuarioPremioDTO.class);
        return dto;
    }

    // Modificar un registro existente de UsuarioPremio
    @PutMapping
    public void Modificar(@RequestBody UsuarioPremioDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioPremio uP = m.map(dto, UsuarioPremio.class);
        uPS.Modificar(uP);
    }

    // Eliminar un registro de UsuarioPremio por id
    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") int id) {
        uPS.Eliminar(id);
    }
}
