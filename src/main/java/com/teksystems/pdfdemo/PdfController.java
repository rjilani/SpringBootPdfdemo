package com.teksystems.pdfdemo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

   
    /**This is itext code, see the GeneratePdfIText.java too
     *
     * @return
     */
    @RequestMapping(value = "/getpdfitext", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        List<City> cities = CityService.getCities();

        ByteArrayInputStream bis = GeneratePdfIText.citiesReport(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    /**
     * This is Pdfbox
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getpdfbox", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getpdfboxreports() throws IOException {

        List<City> cities = CityService.getCities();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        ResponseEntity<byte[]> response = new ResponseEntity<>(GeneratePdfBox.getReport().toByteArray(), headers, HttpStatus.OK);
        return response;
    }

    /**This is OpenPdf code, see the GeneratePdfOpenPdf.java too
     *
     * @return
     */
    @RequestMapping(value = "/getpdfopenpdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getOpenPdfReports() {

        List<City> cities = CityService.getCities();

        ByteArrayInputStream bis = GeneratePdfOpenPdf.getOpenPdfReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
