package com.cibertec.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial_medico") // Nombre de la tabla en la base de datos
public class HistorialMedico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para autoincremento
    private Long id; // Identificador único para cada registro

    @ManyToOne // Relación con Paciente
    @JoinColumn(name = "paciente_id", nullable = false) // Llave foránea que referencia al paciente
    private Paciente paciente;

    private LocalDate fecha; // Fecha del tratamiento o diagnóstico
    private String diagnostico; // Diagnóstico médico
    private String tratamiento; // Tratamiento indicado
    private String doctor; // Nombre del doctor que atendió al paciente

    // Constructores
    public HistorialMedico() {
    }

    public HistorialMedico(Paciente paciente, LocalDate fecha, String diagnostico, String tratamiento, String doctor) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.doctor = doctor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}