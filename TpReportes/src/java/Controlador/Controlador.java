/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.City;
import Modelo.Country;
import Modelo.CountryLanguage;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellUtil;


/**
 *
 * @author Georgi
 */
public class Controlador extends HttpServlet {

  private Country country = new Country();
  private City city = new City();
  private ArrayList<City> cities = new ArrayList();
  private CountryLanguage language = new CountryLanguage();
  private ArrayList<CountryLanguage> languages = new ArrayList();
  private static final String FILE = "C:\\Users\\Georgi\\Desktop\\FirstPdf1.pdf";
 private final String PHP_URL = "http://localhost/TPReportes/reporte.php";

  
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
 
            
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
            processRequest(request, response);
            String action = request.getParameter("action");
            String code = request.getParameter("codigo").toUpperCase();
          
            country = country.traePais(code);
            cities =city.traeCiudades(code);
            languages = language.traeLenguajes(code);
           if(action.equalsIgnoreCase("Reporte Itext")){
                try {
                    llenaReporteItext();
                } catch (DocumentException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               if(action.equalsIgnoreCase(("Reporte POI"))){
                   llenaReportePOI(response);
               }else{
                   if(action.equalsIgnoreCase("Reporte tcpdf")){
                 response.sendRedirect(PHP_URL + "?code=" + code);
                   }
               }
           }
    

           
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
 

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
  public void llenaReporteItext() throws FileNotFoundException, DocumentException{
  Document doc = new Document();
  PdfWriter.getInstance(doc, new FileOutputStream(FILE));
  doc.open();
        doc.add(new Paragraph("Pais: " + country.getName()));
        doc.add(new Paragraph("Superficie: " + country.getSurfaceArea().toString()));
        doc.add(new Paragraph("Población: " + country.getPopulation().toString()));

        doc.add(new Paragraph("\n"));
        doc.add(new Paragraph("Lenguajes: "));
        doc.add(new Paragraph("\n"));

        PdfPTable langTable = new PdfPTable(2);
        langTable.setWidthPercentage(100);
        langTable.setHeaderRows(2);
        langTable.addCell(new Phrase("Lenguaje"));
        langTable.addCell(new Phrase("Porcentaje"));
        for (CountryLanguage language1 : languages) {
          
      
            langTable.addCell(new Phrase(language1.getLanguage()));
            langTable.addCell(new Phrase(language1.getPercentage().toString()));
        }
        doc.add(langTable);
        
        doc.add(new Paragraph("\n"));
       doc.add(new Paragraph("Ciudades Principales: "));
        doc.add(new Paragraph("\n"));

        PdfPTable citiesTable = new PdfPTable(3);
        citiesTable.setWidthPercentage(100);
        citiesTable.setHeaderRows(3);
        citiesTable.addCell(new Phrase("Nombre"));
        citiesTable.addCell(new Phrase("Distrito"));
        citiesTable.addCell(new Phrase("Población"));
        for (City city1 : cities) {
            citiesTable.addCell(new Phrase(city1.getName()));
            citiesTable.addCell(new Phrase(city1.getDistrict()));
            citiesTable.addCell(new Phrase(city1.getPopulation()).toString());
        }
        doc.add(citiesTable);
        doc.close();
  }
    
 public void llenaReportePOI(HttpServletResponse response) throws IOException{
       HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row;
        HSSFCell cell;
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 3500);
        sheet.setColumnWidth(2, 3500);

        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Pais: ");
        cell = row.createCell(1);
        cell.setCellValue(country.getName());

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("Superficie: ");
        cell = row.createCell(1);
        cell.setCellValue(country.getSurfaceArea());

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue("Población: ");
        cell = row.createCell(1);
        cell.setCellValue(country.getPopulation());

        row = sheet.createRow(3);
        cell = row.createCell(0);
        cell.setCellValue("");

        row = sheet.createRow(4);
        cell = row.createCell(0);
        cell.setCellValue("Lenguajes: ");

        int i = 5;
        for (CountryLanguage language : this.languages) {

            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(language.getLanguage() + ": ");
            cell = row.createCell(1);
            cell.setCellValue(language.getPercentage());
            i++;
        }
        row = sheet.createRow(i);
        cell = row.createCell(0);
        cell.setCellValue("");

        row = sheet.createRow(++i);
        cell = row.createCell(0);
    

        row = sheet.createRow(++i);
        cell = row.createCell(0);
        cell.setCellValue("Ciudades Principales: ");

        row = sheet.createRow(++i);
        cell = row.createCell(0);
        cell.setCellValue("Nombre");
        cell = row.createCell(1);
        cell.setCellValue("Distrito");
        cell = row.createCell(2);
        cell.setCellValue("Población");

        for (City city : cities) {
            row = sheet.createRow(++i);
            cell = row.createCell(0);
            cell.setCellValue(city.getName());
            cell = row.createCell(1);
            cell.setCellValue(city.getDistrict());
            cell = row.createCell(2);
            cell.setCellValue(city.getPopulation());
            CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);
        }

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        wb.write(outByteStream);
        byte[] outArray = outByteStream.toByteArray();
        response.setContentType("application/ms-excel");
        response.setContentLength(outArray.length);
        response.setHeader("Expires:", "0");
        response.setHeader("Content-Disposition", "attachment; filename=PoiReport.xls");

     
        File archivo = new File("C:\\Users\\Georgi\\Desktop\\ejemplo.xls");
            FileOutputStream out = new FileOutputStream(archivo);
            wb.write(out);
            out.close();
 }
}
