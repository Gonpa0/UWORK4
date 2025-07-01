package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ArchivoDTO;
import pe.edu.upc.s3155_uwork4.entities.Archivo;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArchivoService;

import java.util.Optional;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {
    @Autowired
    private IArchivoService aS;
    @GetMapping
    public List<ArchivoDTO> Listar() {
        return aS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ArchivoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void Registrar(@RequestBody ArchivoDTO dto){
        ModelMapper m = new ModelMapper();
        Archivo arch = m.map(dto,Archivo.class);
        aS.Registrar(arch);
    }
    @GetMapping("/{id}")
    public ArchivoDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ArchivoDTO dto = m.map(aS.listarporid(id),ArchivoDTO.class);
        return dto;
    }
    @PutMapping
    public void Modificar(@RequestBody Archivo dto){
        ModelMapper m = new ModelMapper();
        Archivo arch = m.map(dto, Archivo.class);
        aS.Modificar(arch);

    }
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        aS.Eliminar(id);
    }

    //QUERYS

    // Buscar archivos por id y fecha de subida
    @GetMapping("/idUsuario/{id}/fechaSubida/{fechaSubida}")
    public List<ArchivoDTO> ObtenerIDYFecha(@PathVariable("id") int idUsuario,
                                              @PathVariable("fechaSubida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaSubida) {
        return aS.buscarPorIDYFecha(idUsuario, fechaSubida).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArchivoDTO.class);
        }).collect(Collectors.toList());
    }
}

