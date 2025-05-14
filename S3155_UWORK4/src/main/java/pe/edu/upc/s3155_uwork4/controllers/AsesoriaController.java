package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.AsesoriaDTO;
import pe.edu.upc.s3155_uwork4.dtos.AsesoriadespuesdeciertafechaDTO;
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

    @GetMapping ("/asesoriaporfecha")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR')")
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

    @GetMapping ("/asesoriadespuesdeciertafecha")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','PROGRAMADOR','ESTUDIANTE SUPERIOR','ESTUDIANTE INFERIOR')")
    public List<AsesoriadespuesdeciertafechaDTO> asesoriadespuesdeciertafecha()
    {
        List<String[]> lista = aS.Asesoriadespuesdeciertafecha();
        List<AsesoriadespuesdeciertafechaDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            AsesoriadespuesdeciertafechaDTO dto=new AsesoriadespuesdeciertafechaDTO();
            dto.setId_asesoria(Integer.parseInt(columna[1]));
            dto.setFecha_Asesoria(LocalDate.parse(columna[2]));
            dto.setNombre_asesroia(columna[3]);
            dto.setId_usuario_inferior(Integer.parseInt(columna[4]));
            dto.setId_usuario_superior(Integer.parseInt(columna[5]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
}
