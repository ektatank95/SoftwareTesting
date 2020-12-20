package com.company.varnaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class invoiceserviceTest {

    @Autowired
    private invoiceservice invoiceservice;

    @Autowired
    private invoiceRepository repository;

    @BeforeClass
    private void beforeClass(){
        repository.deleteAll();
        repository.flush();
    }
    @AfterClass
    private void afterClass(){
        repository.deleteAll();
        repository.flush();
    }

    @BeforeEach
    private void before(){
        repository.deleteAll();
        repository.flush();
    }

    @After
    private void after(){
        repository.deleteAll();
        repository.flush();
    }


    @Test
    void GivenInvoiceVerifysavedInDB() {
        invoice invoice = new invoice("Naman",1234,"invoice");
        invoice save = repository.save(invoice);
        invoice byID = repository.findById(save.getInvoiceID()).orElse(null);
        assertEquals(invoice.getAppointmentID(),byID.getAppointmentID());
        assertEquals(invoice.getPatientName(),byID.getPatientName());
        assertEquals(invoice.getInvoice(),byID.getInvoice());
    }
    @Test
    void GivenInvoiceVerifysavedInDB_negative() {
        invoice invoice = new invoice("Naman",1234,"invoice");
       // invoice save = repository.save(invoice);
        invoice byID = repository.findById(1).orElse(null);
        assertNull(byID);

    }

    @Test
    void GivenInvoiceViewsavedInDB() {
        invoice invoice = new invoice("Bhautik1",123,"invoice1");
        invoice invoice1 = new invoice("Bhautik1",123,"invoice1");
        invoice invoice2 = new invoice("Bhautik2",1234,"invoice2");

        invoiceservice.save(invoice);
        invoiceservice.save(invoice1);
        invoiceservice.save(invoice2);
        List<invoice> invoiceList= invoiceservice.view();

        System.out.println("size - "+invoiceList.size());
        for(int i=0;i<invoiceList.size();i++){
            System.out.println(invoiceList.get(i).getInvoiceID());
        }
        assertEquals(invoice.getInvoiceID(),invoiceList.get(0).getInvoiceID());
        assertEquals(invoice.getAppointmentID(),invoiceList.get(0).getAppointmentID());
        assertEquals(invoice.getPatientName(),invoiceList.get(0).getPatientName());
        assertEquals(invoice.getInvoice(),invoiceList.get(0).getInvoice());

        assertEquals(invoice1.getInvoiceID(),invoiceList.get(1).getInvoiceID());
        assertEquals(invoice1.getAppointmentID(),invoiceList.get(1).getAppointmentID());
        assertEquals(invoice1.getPatientName(),invoiceList.get(1).getPatientName());
        assertEquals(invoice1.getInvoice(),invoiceList.get(1).getInvoice());

        assertEquals(invoice2.getInvoiceID(),invoiceList.get(2).getInvoiceID());
        assertEquals(invoice2.getAppointmentID(),invoiceList.get(2).getAppointmentID());
        assertEquals(invoice2.getPatientName(),invoiceList.get(2).getPatientName());
        assertEquals(invoice2.getInvoice(),invoiceList.get(2).getInvoice());
    }

    @Test
    void GivenInvoiceViewsavedInDB_negative() {
        invoice invoice = new invoice("Bhautik1",123,"invoice1");
        invoice invoice1 = new invoice("Bhautik1",123,"invoice1");
        invoice invoice2 = new invoice("Bhautik2",1234,"invoice2");

        invoiceservice.save(invoice);
        invoiceservice.save(invoice1);
        invoiceservice.save(invoice2);
        List<invoice> invoiceList= invoiceservice.view();

        System.out.println("size - "+invoiceList.size());
        for(int i=0;i<invoiceList.size();i++){
            System.out.println(invoiceList.get(i).getInvoiceID());
        }
        assertNotEquals(10,invoiceList.get(0).getInvoiceID());
        assertNotEquals(10,invoiceList.get(0).getAppointmentID());
        assertNotEquals("Sheetal",invoiceList.get(0).getPatientName());
        assertNotEquals("not inserted invoice",invoiceList.get(0).getInvoice());

        assertNotEquals(10,invoiceList.get(1).getInvoiceID());
        assertNotEquals(10,invoiceList.get(1).getAppointmentID());
        assertNotEquals("Sheetal",invoiceList.get(1).getPatientName());
        assertNotEquals("not inserted invoice",invoiceList.get(1).getInvoice());

        assertNotEquals(10,invoiceList.get(2).getInvoiceID());
        assertNotEquals(10,invoiceList.get(2).getAppointmentID());
        assertNotEquals("Sheetal",invoiceList.get(2).getPatientName());
        assertNotEquals("not inserted invoice",invoiceList.get(2).getInvoice());
    }
}