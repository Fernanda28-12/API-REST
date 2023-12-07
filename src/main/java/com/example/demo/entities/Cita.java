package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cita")
public class Cita {
  @EmbeddedId
  private CitaId id;

  @MapsId("idMedico")
  @ManyToOne
  @JoinColumn(name = "id_Medico")
  private Medico medico;

  @MapsId("idNumeroCedula")
  @ManyToOne
  @JoinColumn(name = "id_cedula")
  private Usuario usuario;
}
