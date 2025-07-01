package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ArchivoDTO;
import pe.edu.upc.s3155_uwork4.dtos.FormatoArchivoDTO;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IFormatoArchivoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formatoArchivo")
public class FormatoArchivoController {
    @Autowired
    private IFormatoArchivoService faS;
    @GetMapping
    public List<FormatoArchivoDTO> Listar() {
        return faS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,FormatoArchivoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void Registrar(@RequestBody FormatoArchivoDTO dto){
        ModelMapper m = new ModelMapper();
        FormatoArchivo fa = m.map(dto,FormatoArchivo.class);
        faS.Registrar(fa);
    }
    @GetMapping("/{id}")
    public FormatoArchivoDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        FormatoArchivoDTO dto = m.map(faS.listarporid(id),FormatoArchivoDTO.class);
        return dto;
    }
    @PutMapping
    public void Modificar(@RequestBody FormatoArchivo dto){
        ModelMapper m = new ModelMapper();
        FormatoArchivo fa = m.map(dto,FormatoArchivo.class);
        faS.Modificar(fa);

    }
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        faS.Eliminar(id);
    }

}
