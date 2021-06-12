package org.iesalixar.jmoreno.proyecto.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.jmoreno.proyecto.model.User;
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

@Component("listusecrol")
public class ListUsersPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<User> listadoUsers = (List<User>) model.get("listusecrol");
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
		
		celda = new PdfPCell(new Phrase("Listado de usuarios dado de alta", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(20);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		
		PdfPTable tablaUsers = new PdfPTable(4);
		tablaUsers.setWidths(new float[] {0.8f, 2f, 2f, 3.5f});
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsers.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsers.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Apellidos", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsers.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Correo", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaUsers.addCell(celda);		
		
		
		for(User users : listadoUsers) {
			celda = new PdfPCell(new Phrase(users.getId().toString(),fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsers.addCell(celda);
			
			celda = new PdfPCell(new Phrase(users.getNombre(),fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsers.addCell(celda);
			
			celda = new PdfPCell(new Phrase(users.getApellidos(),fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsers.addCell(celda);
			
			celda = new PdfPCell(new Phrase(users.getEmail(),fuenteDataCeldas));
			celda.setPadding(5);
			tablaUsers.addCell(celda);		
			
		}
		
		document.add(tablaTitulo);
		document.add(tablaUsers);
	}

}
