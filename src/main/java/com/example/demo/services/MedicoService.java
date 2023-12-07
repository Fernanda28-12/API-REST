package com.example.demo.services;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.MedicoModel;
import com.example.demo.repositories.MedicoRepository;

@Service

public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;
    
    public ArrayList<MedicoModel> obtenerUsuarios(){
        return (ArrayList<MedicoModel>) medicoRepository.findAll();
    }

    public MedicoModel guardarUsuario(MedicoModel usuario){
        Object medico;
        return medicoRepository.save(medico);
    }

    public ArrayList<MedicoModel> obtenerPorCedula(String cedula){
        return medicoRepository.findById(cedula);
    }

     public boolean eliminarUsuario(Long id) {
        try{
            medicoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<MedicoModel> obtenerPorId(Long id) {
        return null;
    }

    public ArrayList<MedicoModel> obtenerMedico() {
        return null;
    }

    public MedicoModel guardarMedico(MedicoModel medico) {
        return null;
    }


    
}
