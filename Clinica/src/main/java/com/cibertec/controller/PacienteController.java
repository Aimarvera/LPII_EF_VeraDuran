package com.cibertec.controller;

import com.cibertec.entity.Paciente;
import com.cibertec.service.JasperReportService;
import com.cibertec.service.PacienteService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registrarPaciente";
    }

    @PostMapping("/registrar")
    public String registrarPaciente(@ModelAttribute("paciente") Paciente paciente, Model model) {
        // Registrar el paciente
        pacienteService.registrarPaciente(paciente);

        // Redirigir a la lista de pacientes con mensaje de éxito
        model.addAttribute("mensaje", "Paciente registrado exitosamente.");
        return "redirect:/pacientes/listar"; 
    }

    @GetMapping("/listar")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", pacientes);
        
        // Mensaje opcional
        return "listarPacientes";
    }

    @GetMapping("/historial/{id}")
    public String verHistorial(@PathVariable("id") Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        model.addAttribute("paciente", paciente);
        return "historialMedico";
    }
    
    @GetMapping("/reporte/{id}")
    public void generarReporte(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            Paciente paciente = pacienteService.obtenerPacientePorId(id);
            if (paciente != null) {
                System.out.println(paciente); // Verificar que el paciente no es null y tiene datos
                List<Paciente> dataList = new ArrayList<>();
                dataList.add(paciente); // Agregar el paciente a la lista

                jasperReportService.exportToPDF(dataList, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Paciente no encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al generar el reporte");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }}
