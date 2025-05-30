package com.prathmesh.bookmyticket.Service;

import java.io.ByteArrayOutputStream;
import java.util.Optional;



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

import jakarta.persistence.EntityNotFoundException;

@Service
public class TicketGeneration_Service {

	 @Autowired
	    private PDFGeneration_Repository pdfgenerationRepository;
	    
	    public byte[] generateTicketPDF(Integer bookingId) {
	        
	        // Find the PDFGeneration entity by booking ID
	        Optional<PDFGeneration> pdfGenerationOptional = pdfgenerationRepository.findByBookingId(bookingId);
	        
	        // Handle the case where PDFGeneration with the given bookingId does not exist
	        if (pdfGenerationOptional.isEmpty()) {
	            throw new EntityNotFoundException("PDFGeneration not found for Booking ID: " + bookingId);
	        }
	        
	        PDFGeneration pdfGeneration = pdfGenerationOptional.get();
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        
	        try (PdfWriter writer = new PdfWriter(outputStream);
	             PdfDocument pdfDocument = new PdfDocument(writer);
	             Document document = new Document(pdfDocument)) {

	            // Header section
	            Paragraph header = new Paragraph("***** BUS TICKET *****")
	                    .setFontSize(16)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setMarginBottom(15);
	            document.add(header);
	            
	            // Operator Information
	            Paragraph operatorInformation = new Paragraph("Operator : " + pdfGeneration.getBus().getOperator())
	                    .setFontSize(10)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setMarginBottom(10);
	            document.add(operatorInformation);
	            
	            // Ticket Number And Date
	            document.add(new Paragraph("Ticket No : " + pdfGeneration.getId())
	                    .setFontSize(10)
	                    .setBold()
	                    .setTextAlignment(TextAlignment.LEFT));
	            document.add(new Paragraph("Date : " + pdfGeneration.getSchedule().getDate())
	                    .setFontSize(10)
	                    .setTextAlignment(TextAlignment.RIGHT));
	            
	            // Divider Line
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
	                    .setTextAlignment(TextAlignment.CENTER));
	            
	            // Passenger Details Section 
	            String fullName = pdfGeneration.getUser().getFirst_name() + " " + pdfGeneration.getUser().getLast_name();
	            document.add(new Paragraph("Passenger Details")
	                    .setFontSize(12)
	                    .setBold()
	                    .setMarginBottom(5));
	            document.add(new Paragraph("Name : " + fullName));
	            document.add(new Paragraph("Gender : " + pdfGeneration.getUser().getGender()));
	            
	            // Divider Line
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
	                    .setTextAlignment(TextAlignment.CENTER));
	            
	            // Travel Details and Booking Details (two-column layout)
	            Table table = new Table(new float[]{1, 1}); // Equal column widths
	            table.setWidth(UnitValue.createPercentValue(100)); // Full-width table

	            // Travel Details Column
	            Cell travelDetailsCell = new Cell()
	                    .add(new Paragraph("Travel Details").setFontSize(12).setBold())
	                    .add(new Paragraph("Bus Name : " + pdfGeneration.getBus().getName()))
	                    .add(new Paragraph("From : " + pdfGeneration.getBus().getSource() + " To : " + pdfGeneration.getBus().getDestination()))
	                    .add(new Paragraph("Date : " + pdfGeneration.getSchedule().getDate() + " Time : " + pdfGeneration.getSchedule().getTime()))
	                    .setBorder(com.itextpdf.layout.borders.Border.NO_BORDER)
	                    .setTextAlignment(TextAlignment.LEFT);
	            table.addCell(travelDetailsCell);
	            
	            // Booking Details Column
	            Cell bookingDetailsCell = new Cell()
	                    .add(new Paragraph("Booking Details").setFontSize(12).setBold())
	                    .add(new Paragraph("Selected seats : " + pdfGeneration.getBooking().getSelectedSeats()))
	                    .add(new Paragraph("Fare per Seat : ₹" + pdfGeneration.getSchedule().getFare()))
	                    .add(new Paragraph("Total Amount : ₹" + pdfGeneration.getBooking().getTotal_amount())) 
	                    .add(new Paragraph("Status : " + pdfGeneration.getBooking().getStatus()))
	                    .setBorder(com.itextpdf.layout.borders.Border.NO_BORDER)
	                    .setTextAlignment(TextAlignment.LEFT);
	            table.addCell(bookingDetailsCell);
	            
	            document.add(table);
	            
	            // Divider Line
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------")
	                    .setTextAlignment(TextAlignment.CENTER));
	            
	            // Footer section
	            document.add(new Paragraph("Thank You For Traveling with Us!!!")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setMarginTop(20));
	            document.add(new Paragraph("Helpline : 8055447567 | Email : support@busticket.com")
	                    .setFontSize(10)
	                    .setTextAlignment(TextAlignment.CENTER));
	            
	            // Update PDF Status
	            pdfGeneration.setPdfStatus("GENERATED");
	            pdfgenerationRepository.save(pdfGeneration);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            pdfGeneration.setPdfStatus("FAILED");
	            pdfgenerationRepository.save(pdfGeneration);
	        }
	        
	        return outputStream.toByteArray();
	    }
}
