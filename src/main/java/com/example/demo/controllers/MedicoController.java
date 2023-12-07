package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.MedicoModel;
import com.example.demo.services.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private static final String MedicoService = null;
    @Autowired
     MedicoService medicoService;
     
     @GetMapping()
      public ArrayList<MedicoModel> obtenerMedicos(){
        return medicoService.obtenerMedico();
    
}

  @PostMapping()
    public MedicoModel guardarUsuario(@RequestBody MedicoModel medico){
        return this.medicoService.guardarMedico(medico);
    }

    @GetMapping( path = "/{id}")
    public Optional<MedicoModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.MedicoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<MedicoModel> obtenerUsuarioPorCedula(@RequestParam("Cedula") String Cedula){
        return this.medicoService.obtenerPorCedula(Cedula);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.medicoService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
