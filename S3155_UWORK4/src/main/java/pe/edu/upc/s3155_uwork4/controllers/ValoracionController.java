package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ValoracionDTO;
import pe.edu.upc.s3155_uwork4.entities.Valoracion;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IValoracionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    private IValoracionService vS;

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping
    public List<ValoracionDTO> Listar(){
        return vS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ValoracionDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @PostMapping
    public void Registrar(@RequestBody ValoracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Valoracion v = m.map(dto, Valoracion.class);
        vS.Registrar(v);
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @GetMapping("/{id})")
    public ValoracionDTO ListarporId(@PathVariable ("id") int id) {
        ModelMapper m = new ModelMapper();
        ValoracionDTO dto = m.map(vS.listarporid(id), ValoracionDTO.class);
        return dto;
    }


    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void Modificar(@RequestBody ValoracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Valoracion v = m.map(dto, Valoracion.class);
        vS.Modificar(v);
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable ("id") int id) {
        vS.Eliminar(id);
    }

}
