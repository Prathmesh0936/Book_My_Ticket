package com.prathmesh.bookmyticket.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathmesh.bookmyticket.Service.TicketGeneration_Service;

@Controller
@RequestMapping("/tickets")
public class Ticket_Controller {
	
	@Autowired
	private TicketGeneration_Service ticketGeneration_Service;

	@GetMapping("/generate/{id}")
	public ResponseEntity<byte[]> generateTicket(@PathVariable Integer id){
		
		byte[] pdfbytes = ticketGeneration_Service.generateTicketPDF(id);
		
		return ResponseEntity.ok()
				 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ticket.pdf")
				 .contentType(MediaType.APPLICATION_PDF)
				 .body(pdfbytes);
		
	}
	
}
