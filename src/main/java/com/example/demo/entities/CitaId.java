package com.example.demo.entities;


import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CitaId implements Serializable {
  private long idMedico;
  private long idCedula;
  private LocalDateTime fechaHora;
}
