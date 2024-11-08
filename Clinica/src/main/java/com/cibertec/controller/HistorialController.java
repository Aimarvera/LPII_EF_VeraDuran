package com.cibertec.controller;

import com.cibertec.entity.Paciente;
import com.cibertec.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/historial/{id}")
    public String verHistorial(@PathVariable("id") Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        if (paciente == null) {
            return "errorPacienteNoEncontrado"; 
        }
        model.addAttribute("paciente", paciente);
        return "historialMedico";
    }

}
