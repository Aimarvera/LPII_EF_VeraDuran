package com.cibertec.service;

import com.cibertec.entity.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
    Paciente obtenerPacientePorId(Long id);
}
