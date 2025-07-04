package pe.edu.upc.s3155_uwork4.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.BusquedaPalabraMensajesDTO;
import pe.edu.upc.s3155_uwork4.dtos.MensajeDTO;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.Mensaje;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IMensajeService;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void Modificar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje me = m.map(dto,Mensaje.class);
        mS.Modificar(me);
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void Eliminar(@PathVariable("id") int id) {
        mS.Eliminar(id);
    }


    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping ("/BusquedaPalabraMensajes")
    public List<BusquedaPalabraMensajesDTO> BusquedaPalabraMensajes()
    {
        List<String[]> lista = mS.BusquedaPalabraMensajes();
        List<BusquedaPalabraMensajesDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            BusquedaPalabraMensajesDTO dto=new BusquedaPalabraMensajesDTO();
            dto.setId_mensaje(Integer.parseInt(columna[0]));
            dto.setOrden(Integer.parseInt(columna[1]));
            dto.setContenido(columna[2]);
            dto.setFecha_mensaje(LocalDate.parse(columna[3]));
            dto.setId_asesoria(Integer.parseInt(columna[4]));
            dto.setId_usuario(Integer.parseInt(columna[5]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping("/asesoria/{id}")
    public List<MensajeDTO> listarPorAsesoria(@PathVariable("id") int idAsesoria) {
        return mS.listarPorAsesoriaId(idAsesoria)
                .stream()
                .map(mensaje -> new ModelMapper().map(mensaje, MensajeDTO.class))
                .collect(Collectors.toList());
    }
}
