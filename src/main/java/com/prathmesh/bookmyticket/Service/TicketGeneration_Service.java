package com.prathmesh.bookmyticket.Service;

import java.io.ByteArrayOutputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.prathmesh.bookmyticket.Repository.PDFGeneration_Repository;
import com.prathmesh.bookmyticket.entity.PDFGeneration;

@Service
public class TicketGeneration_Service {

	@Autowired
	private PDFGeneration_Repository pdfgeneration_Repository;
	
	public byte[] generateTicketPDF(Integer pdfGenerationId) {
		
		PDFGeneration pdfGeneration = pdfgeneration_Repository.findById(pdfGenerationId).orElseThrow(
				() -> new RuntimeException("PDFGeneration not found with ID : " + pdfGenerationId)
				);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		try(PdfWriter writer = new PdfWriter(outputStream);
				PdfDocument pdfDocument = new PdfDocument(writer);
				Document document = new Document(pdfDocument)){
			
			//header section
			Paragraph header = new Paragraph("***** BUS TICKET *****")
					.setFontSize(16)
					.setBold()
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER)
					.setMarginBottom(15);
			document.add(header);
			
			//operator Information
			Paragraph operatorInformation = new Paragraph("Operator : " + pdfGeneration.getBus().getOperator())
					.setFontSize(10)
					.setBold()
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER)
					.setMarginBottom(10);
			document.add(operatorInformation);
			
			// Ticket Number And Date
			document.add(new Paragraph("Ticket No : " + pdfGeneration.getId())
					.setFontSize(10)
					.setBold()
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT));
			document.add(new Paragraph("Date : " + pdfGeneration.getSchedule().getDate())
					.setFontSize(10)
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.RIGHT));
			
			// Divider Line
			document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));
			
			// Passenger Details Section 
			String FullName = pdfGeneration.getUser().getFirst_name() + pdfGeneration.getUser().getLast_name();
			document.add(new Paragraph("Passenger Details")
					.setFontSize(12)
					.setBold()
					.setMarginBottom(5));
			document.add(new Paragraph("Name : " + FullName));
			document.add(new Paragraph("Gender : " + pdfGeneration.getUser().getGender()));
			
			// Divider Line
			document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));
			
			// Travel Details and Booking Details here we are using two column layout
			Table table = new Table(new float[]{1, 1}); // Equal column widths
			table.setWidth(UnitValue.createPercentValue(100)); // Full-width table
			// use full width of the page ************
			 
			 // travel Details column
			Cell travelDetailsCell = new Cell()
					.add(new Paragraph("Travel Details").setFontSize(12).setBold())
					.add(new Paragraph("Bus Name : " + pdfGeneration.getBus().getName()))
					.add(new Paragraph("From : " + pdfGeneration.getBus().getSource() + " To : " + pdfGeneration.getBus().getDestination()))
					.add(new Paragraph("Date : " + pdfGeneration.getSchedule().getDate() + " Time : " + pdfGeneration.getSchedule().getTime()))
					.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER) // Remove cell borders
			        .setTextAlignment(TextAlignment.LEFT);
			table.addCell(travelDetailsCell);
			
			// Booking Details Column
			Cell bookingDetailsCell = new Cell()
					.add(new Paragraph("Booking Details").setFontSize(12).setBold())
					.add(new Paragraph("Selected seats : " + pdfGeneration.getBooking().getSelectedSeats()))
					.add(new Paragraph("Fare per Seat : ₹" + pdfGeneration.getSchedule().getFare()))
					.add(new Paragraph("Total Amount : ₹" + pdfGeneration.getBooking().getTotal_amount())) 
					.add(new Paragraph("Status : " + pdfGeneration.getBooking().getStatus()))
					.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER) // Remove cell borders
					.setTextAlignment(com.itextpdf.layout.properties.TextAlignment.LEFT);
			 table.addCell(bookingDetailsCell);
			
			 document.add(table);
			 
			 // Divider Line
			 document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
			 .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));
			 
			 // Footer section
			 document.add(new Paragraph("Thank You For Traveling with Us!!!")
					 .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER)
					 .setMarginTop(20));
			 document.add(new Paragraph("Helpline : 8055447567 | Email : support@busticket.com")
					 .setFontSize(10)
					 .setTextAlignment(com.itextpdf.layout.properties.TextAlignment.CENTER));
			 
			 // Update PDF Status
			 pdfGeneration.setPdfStatus("GENERATED");
			 pdfgeneration_Repository.save(pdfGeneration);
			 
		}catch(Exception e) {
			
			e.printStackTrace();
			pdfGeneration.setPdfStatus("FAILED");
			pdfgeneration_Repository.save(pdfGeneration);
		}
		
		return outputStream.toByteArray();
		
	}
	
}
