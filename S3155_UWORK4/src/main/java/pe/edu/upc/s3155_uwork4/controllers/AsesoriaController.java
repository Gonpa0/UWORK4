package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.AsesoriaDTO;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IAsesoriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asesoria")
public class AsesoriaController {
    @Autowired
    private IAsesoriaService aS;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public List<AsesoriaDTO> Listar() {
        return aS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AsesoriaDTO.class);

        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Registrar(@RequestBody AsesoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Asesoria a = m.map(dto, Asesoria.class);
        aS.Registrar(a);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
    public AsesoriaDTO Listarporid(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AsesoriaDTO dto = m.map(aS.listarporid(id), AsesoriaDTO.class);
        return dto;

    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Modificar(@RequestBody AsesoriaDTO dto){
        ModelMapper m = new ModelMapper();
        Asesoria a = m.map(dto,Asesoria.class);
        aS.Modificar(a);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public void Eliminar(@PathVariable("id") int id) {
        aS.Eliminar(id);
    }
}
