package com.example.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MedicoService;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

  @Autowired
  private CitaService citaService;

  @Autowired
  private MedicoService doctorService;

  @Autowired
  private UsuarioService pacienteService;

    @GetMapping("")
  public ResponseEntity <Set<Cita>> getCitas(){
    Set<Cita> citas = citaService.findAll();

    return new ResponseEntity<>(citas, HttpStatus.OK);
  }

  //Uso de parametros query en este endpoint
  @GetMapping("/one-cita")
  public ResponseEntity <Cita> getCita(@RequestParam Long idUsuario,
  @RequestParam Long idMedico, @RequestParam LocalDateTime fecha_hora){

    CitaId citaId = new CitaId(idDoctor, idPaciente, fecha_hora);

    Cita cita = citaService.findById(citaId);

    return new ResponseEntity<>(cita, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity <CitaId> addCita(@RequestBody CitaId citaId){
    Medico medico = MedicoService.findById(citaId.getIdMedico());
    Usuario usuario = UsuarioService.findById(citaId.getIdCedula());

    Cita newCita = new Cita();

    newCita.setId(citaId);
    newCita.setMedico(medico);
    newCita.setUsuario(usuario);

    Cita addedCita = citaService.addCita(citaId, newCita);

    return new ResponseEntity<>(addedCita.getId(), HttpStatus.CREATED);
  }

  @PutMapping("")
  public ResponseEntity <Cita> modifyCita(@RequestBody CitaId citaId, @RequestParam Long idUsuario,
  @RequestParam Long idMedico, @RequestParam LocalDateTime fecha_hora){

    CitaId oldCita = new CitaId(idMedico, idUsuario, fecha_hora);

    Cita modifyCita = citaService.modifyCita(oldCita, citaId);

    return new ResponseEntity<>(modifyCita, HttpStatus.OK);
  }

  @DeleteMapping("")
  public ResponseEntity <Void> deleteCita(@RequestBody CitaId id){
    citaService.deleteCita(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}