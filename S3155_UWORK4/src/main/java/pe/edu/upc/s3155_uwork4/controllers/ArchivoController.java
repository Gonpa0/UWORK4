package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.s3155_uwork4.dtos.ArchivoDTO;
import pe.edu.upc.s3155_uwork4.entities.Archivo;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IArchivoService;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {
    @Autowired
    private IArchivoService aS;

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping
    public List<ArchivoDTO> Listar() {
        return aS.listar().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ArchivoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
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
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @PutMapping
    public void Modificar(@RequestBody Archivo dto){
        ModelMapper m = new ModelMapper();
        Archivo arch = m.map(dto, Archivo.class);
        aS.Modificar(arch);

    }
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN')")
    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        aS.Eliminar(id);
    }


    // Subir un archivo local desde el frontend y guarda sus metadatos (nombre, fecha, usuario,
    // asesoría, formato) en la BD.
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> subirArchivo(
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("idUsuario") int idUsuario,
            @RequestParam("idAsesoria") int idAsesoria,
            @RequestParam("idFormato") int idFormato
    ) {
        try {
            Archivo nuevo = new Archivo();
            nuevo.setNombreArchivo(archivo.getOriginalFilename());
            nuevo.setFechaSubida(LocalDate.now());

            Usuario u = new Usuario();
            u.setIdUsuario(idUsuario);
            nuevo.setUsuario(u);

            Asesoria a = new Asesoria();
            a.setIdAsesoria(idAsesoria);
            nuevo.setAsesoria(a);

            FormatoArchivo f = new FormatoArchivo();
            f.setId(idFormato);
            nuevo.setFormatoArchivo(f);

            // Opcional: guardar archivo físico
            // Path path = Paths.get("uploads/" + archivo.getOriginalFilename());
            // Files.write(path, archivo.getBytes());

            aS.Registrar(nuevo); // Guarda solo los metadatos


            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Archivo subido correctamente");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error al subir archivo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    // Lista los archivos subidos para una asesoría específica (por idAsesoria)
    // para mostrarlos en el chat DEL FRONTEND.
    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping("/asesoria/{id}")
    public List<ArchivoDTO> listarPorAsesoria(@PathVariable("id") int idAsesoria) {
        return aS.listarPorAsesoria(idAsesoria).stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, ArchivoDTO.class);
        }).collect(Collectors.toList());
    }

}