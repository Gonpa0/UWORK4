package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.MensajeDTO;
import pe.edu.upc.s3155_uwork4.entities.Mensaje;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    @Autowired
    private IMensajeService mS;
    @GetMapping
    public List<MensajeDTO> Listar() {
        return mS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MensajeDTO.class);

        }).collect(Collectors.toList());
    }
    @PostMapping
    public void Registrar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje me = m.map(dto, Mensaje.class);
        mS.Registrar(me);
    }
    @GetMapping("/{id}")
    public MensajeDTO Listarporid(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MensajeDTO dto = m.map(mS.listarporid(id), MensajeDTO.class);
        return dto;

    }
    @PutMapping
    public void Modificar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje me = m.map(dto,Mensaje.class);
        mS.Modificar(me);
    }
    @DeleteMapping("{/id}")
    public void Eliminar(@PathVariable("id") int id) {
        mS.Eliminar(id);
    }
}
