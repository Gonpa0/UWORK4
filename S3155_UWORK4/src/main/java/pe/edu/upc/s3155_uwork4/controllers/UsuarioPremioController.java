package pe.edu.upc.s3155_uwork4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioPremioDTO;
import pe.edu.upc.s3155_uwork4.entities.Premio;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioPremioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuariopremio")
public class UsuarioPremioController {

    @Autowired
    private IUsuarioPremioService uPS;

    // Listar todos los registros
    @GetMapping
    public List<UsuarioPremioDTO> listar() {
        return uPS.listar().stream().map(up -> {
            UsuarioPremioDTO dto = new UsuarioPremioDTO();
            dto.setId(up.getId());
            dto.setUsuario(up.getUsuario());
            dto.setPremio(up.getPremio());
            return dto;
        }).collect(Collectors.toList());
    }

    // Registrar un nuevo registro
    @PostMapping
    public void registrar(@RequestBody UsuarioPremioDTO dto) {
        // Crear la entidad UsuarioPremio
        UsuarioPremio uP = new UsuarioPremio();

        // Establecer el usuario desde el DTO
        Usuario u = new Usuario();
        u.setIdUsuario(dto.getUsuario().getIdUsuario()); // Suponiendo que solo se pasa el ID
        uP.setUsuario(u);

        // Establecer el premio desde el DTO
        Premio p = new Premio();
        p.setId(dto.getPremio().getId()); // Suponiendo que solo se pasa el ID
        uP.setPremio(p);

        // Registrar la entidad
        uPS.Registrar(uP);
    }

    // Buscar por id
    @GetMapping("/{id}")
    public UsuarioPremioDTO listarPorId(@PathVariable("id") int id) {
        UsuarioPremio up = uPS.listarporid(id);
        UsuarioPremioDTO dto = new UsuarioPremioDTO();
        dto.setId(up.getId());
        dto.setUsuario(up.getUsuario());
        dto.setPremio(up.getPremio());
        return dto;
    }

    // Modificar un registro existente
    @PutMapping
    public void modificar(@RequestBody UsuarioPremioDTO dto) {
        UsuarioPremio uP = new UsuarioPremio();
        uP.setId(dto.getId());

        Usuario u = new Usuario();
        u.setIdUsuario(dto.getUsuario().getIdUsuario());
        uP.setUsuario(u);

        Premio p = new Premio();
        p.setId(dto.getPremio().getId());
        uP.setPremio(p);

        uPS.Modificar(uP);
    }

    // Eliminar un registro
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        uPS.Eliminar(id);
    }
}


