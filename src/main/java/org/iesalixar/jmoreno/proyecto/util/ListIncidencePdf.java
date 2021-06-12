package org.iesalixar.jmoreno.proyecto.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.jmoreno.proyecto.model.Incidence;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("listincidenceroot")
public class ListIncidencePdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Incidence> listadoIncidencias = (List<Incidence>) model.get("listincidence");
		//Tamaños y colores de cada seccion
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16,Color.BLUE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLUE);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 40, 20);
		document.open();
		PdfPCell celda = null;
		
		//Tabla para el titulo del PDF
		PdfPTable tablaTitulo = new PdfPTable(1);
		
				
		celda = new PdfPCell(new Phrase("Listado de incidencias", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(20);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaIncidencias = new PdfPTable(5);
		tablaIncidencias.setWidths(new float[] {0.8f, 2f, 3.5f, 2.f, 1.5f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIncidencias.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Fecha", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIncidencias.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Descripción", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIncidencias.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Trabajador", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIncidencias.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Estado", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaIncidencias.addCell(celda);
		
		for(Incidence incidence : listadoIncidencias) {
			celda = new PdfPCell(new Phrase(incidence.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaIncidencias.addCell(celda);
			
			celda = new PdfPCell(new Phrase(incidence.getFecha(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaIncidencias.addCell(celda);
			
			celda = new PdfPCell(new Phrase(incidence.getDescripcion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaIncidencias.addCell(celda);
			
			celda = new PdfPCell(new Phrase(incidence.getUsers().getNombre(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaIncidencias.addCell(celda);
			
			celda = new PdfPCell(new Phrase(incidence.getEstado(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaIncidencias.addCell(celda);
		}		
		
		
		document.add(tablaTitulo);
		document.add(tablaIncidencias);
		
		
	}

}
