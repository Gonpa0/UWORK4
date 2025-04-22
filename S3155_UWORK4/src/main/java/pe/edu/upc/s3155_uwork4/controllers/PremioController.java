package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.PremioDTO;
import pe.edu.upc.s3155_uwork4.entities.Premio;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IPremioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/premio")
public class PremioController {
    @Autowired
    private IPremioService pS;
    @GetMapping
    public List<PremioDTO> listar() {
        return pS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PremioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody PremioDTO dto) {
        ModelMapper m = new ModelMapper();
        Premio p = m.map(dto, Premio.class);
        pS.Registrar(p);
    }

    @GetMapping("/{id}")
    public PremioDTO listarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PremioDTO dto = m.map(pS.listarporid(id), PremioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody PremioDTO dto) {
        ModelMapper m = new ModelMapper();
        Premio p = m.map(dto, Premio.class);
        pS.Modificar(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        pS.Eliminar(id);
    }
}
