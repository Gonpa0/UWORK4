package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.AsesoriaDTO;
import pe.edu.upc.s3155_uwork4.dtos.AsesoriaporfechaDTO;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IAsesoriaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asesoria")
public class AsesoriaController {
    @Autowired
    private IAsesoriaService aS;

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping
    public List<AsesoriaDTO> Listar() {
        return aS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AsesoriaDTO.class);

        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PostMapping
    public void Registrar(@RequestBody AsesoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Asesoria a = m.map(dto, Asesoria.class);
        aS.Registrar(a);
    }
    @GetMapping("/{id}")
    public AsesoriaDTO Listarporid(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AsesoriaDTO dto = m.map(aS.listarporid(id), AsesoriaDTO.class);
        return dto;

    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void Modificar(@RequestBody AsesoriaDTO dto){
        ModelMapper m = new ModelMapper();
        Asesoria a = m.map(dto,Asesoria.class);
        aS.Modificar(a);
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") int id) {
        aS.Eliminar(id);
    }


    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTEINFERIOR')")

    @GetMapping ("/asesoriaporfecha")
    public List<AsesoriaporfechaDTO> Asesoriaporfecha()
    {
        List<String[]> lista = aS.Asesoriaporfecha();
        List<AsesoriaporfechaDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            AsesoriaporfechaDTO dto=new AsesoriaporfechaDTO();
            dto.setFecha_Asesoria(LocalDate.parse(columna[1]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }

    @GetMapping("/usuario/{id}")
    public List<Asesoria> listarPorUsuario(@PathVariable("id") Integer id) {
        return aS.listarPorUsuario(id);
    }
}
