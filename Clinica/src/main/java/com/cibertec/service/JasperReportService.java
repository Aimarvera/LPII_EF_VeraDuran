package com.cibertec.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Paciente;

import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

	public void exportToPDF(List<Paciente> dataList, HttpServletResponse response) throws Exception {

	    try (InputStream reportStream = this.getClass().getResourceAsStream("/reports/ReportePacientes.jasper")) {
	        if (reportStream == null) {
	            throw new FileNotFoundException("El archivo .jasper no se encontró.");
	        }

	      
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

	        
	        Map<String, Object> parameters = new HashMap<>();
	      

	        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, dataSource);

	      
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=constancia.pdf");

	       
	        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	    } catch (JRException e) {
	        e.printStackTrace(); 
	        throw new Exception("Error al generar el reporte PDF: " + e.getMessage(), e);
	    }
	}
}