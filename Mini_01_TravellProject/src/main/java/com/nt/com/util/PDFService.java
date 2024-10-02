package com.nt.com.util;

import java.awt.Color;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.com.dto.CourseDTO;
import com.nt.com.dto.SearcInputhDTO;
import com.nt.com.service.CourseService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@Component
public class PDFService {
	public void downloadPDF(HttpServletResponse response, List<CourseDTO> courses) {
	    Document document = new Document(PageSize.A4);
	    String header = "Training Details Report"; 
	    String footer = "Page "; 
	    try {
	        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
	        writer.setPageEvent(new HeaderFooterPageEvent(header, footer));
	        
	        document.open();
	        
	        addTitle(document, "Filtered Training Details-1");
	        addCoursesTable(document, courses);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        document.close();
	    }
	}

	private void addCoursesTable(Document document, List<CourseDTO> courses) throws DocumentException {
		   PdfPTable table = createTable();
		    int counter = 0;
		    
		    for (CourseDTO course : courses) {
		        counter++;
		        table.addCell(course.getCourseName());
		        table.addCell(course.getTrainingMode());
		        table.addCell(course.getCourseStartDate() != null ? course.getCourseStartDate().toString() : "");
		        
		        // Check if the current row count reaches a certain limit (e.g., 25)
		        if (counter % 25 == 0) {
		            document.add(table); // Add the current table to the document
		            document.newPage(); // Start a new page
		            table = createTable(); // Create a new table for the next page
		            document.add(new Paragraph("                                            ")); // Add a blank paragraph for spacing
		            document.add(new Paragraph("                                            "));
		            document.add(new Paragraph("                                            "));
		        }
		    }
		    
		    // Add any remaining rows that didn't fill a complete page
		    if (counter % 25 != 0) {
		        document.add(table);
		    }
	}

	private PdfPTable createTable() throws DocumentException {
	    PdfPTable table = new PdfPTable(3);
	    table.setWidthPercentage(100f);
	    table.setWidths(new int[] {3, 3, 3});
	    // Set default spacing before the table
	    table.setSpacingBefore(40);

	    // Header row
	    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Color.WHITE);
	    PdfPCell cell = new PdfPCell();
	    cell.setBackgroundColor(Color.BLUE);
	    cell.setPadding(5);
	    
	    cell.setPhrase(new Phrase("Course Name", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Training Mode", font));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Course Start Date", font));
	    table.addCell(cell);

	    return table;
	}

    private void addTitle(Document document, String title) throws DocumentException {
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20);
        Paragraph paragraph = new Paragraph(title, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
    }

    private class HeaderFooterPageEvent extends PdfPageEventHelper {
        private String header;
        private String footer;

        public HeaderFooterPageEvent(String header, String footer) {
            this.header = header;
            this.footer = footer;
        }

        @Override
        @SneakyThrows
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            
            // Adding a Base64 image to the header
            String base64Image = "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";
            Image headerImage = null;
            try {
                byte[] imageBytes = Base64.getDecoder().decode(base64Image);
                headerImage = Image.getInstance(Image.getInstance(imageBytes));
                headerImage.scaleToFit(50, 50); // Adjust size as needed
                headerImage.setAbsolutePosition(document.leftMargin(), document.top() - headerImage.getScaledHeight() - 5);
                cb.addImage(headerImage);
            } catch (IOException | BadElementException e) {
                e.printStackTrace(); // Handle exceptions appropriately
            }

            // Adding header with larger font size and color
            Font headerFont = new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLUE);
            Phrase headerPhrase = new Phrase(header, headerFont);
            float headerWidth = ColumnText.getWidth(headerPhrase);
            float headerX = (document.right() - document.left()) / 2 + document.leftMargin() - headerWidth / 2;
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, headerPhrase, headerX, document.top() - headerImage.getScaledHeight() - 5, 0);
            // Adding footer
            String pageNumber = "Page " + writer.getPageNumber();
            float footerX = (document.right() + document.left()) / 2;
            String address = "1234 Address St, City, State, 12345"; // Replace with your actual address
          
            float footerY = document.bottomMargin() - 10;
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(pageNumber), footerX, document.bottomMargin() - 10, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase(address), footerX, footerY - 15, 0); // Adjust Y position as needed
            // Underline the footer
            cb.moveTo(footerX - 30, document.bottomMargin() - 12);
            cb.lineTo(footerX + 30, document.bottomMargin() - 12);
            cb.setLineWidth(1f);
            cb.stroke();
        }
    }

}
