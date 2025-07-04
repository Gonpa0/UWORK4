package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.PremioDTO;
import pe.edu.upc.s3155_uwork4.entities.Premio;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IPremioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/premios")
public class PremioController {

    @Autowired
    private IPremioService premioService;


    @GetMapping
    public List<PremioDTO> listar() {
        return premioService.listar().stream().map(premio -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(premio, PremioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody PremioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Premio premio = modelMapper.map(dto, Premio.class);
        premioService.Registrar(premio);
    }

    @GetMapping("/{id}")
    public PremioDTO listarPorId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        PremioDTO dto = modelMapper.map(premioService.listarporid(id), PremioDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody PremioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Premio premio = modelMapper.map(dto, Premio.class);
        premioService.Modificar(premio);
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        premioService.Eliminar(id);
    }
}
