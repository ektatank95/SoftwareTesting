package com.company.varnaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class appointmentServiceTest {
    @Autowired
    private appointmentService service;

    @Autowired
    private appointmentRepository repository;

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
    public void givenAppointmentSavedInDB() {
        appointment obj = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj);
        assertEquals(save.getPatientName(), obj.getPatientName());
        assertEquals(save.getDoctorName(), obj.getDoctorName());
        assertEquals(save.getDate(), obj.getDate());
        assertEquals(save.getPrescription(), obj.getPrescription());
        assertEquals(save.getConfirmed(), obj.getConfirmed());
    }

    @Test
    public void givenAppointmentIdDeleteFromDB() {
        appointment obj = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj);
        assertEquals(save.getAppointmentId(), obj.getAppointmentId());
        service.delete(save.getAppointmentId());
        appointment deleted = repository.findById(save.getAppointmentId()).orElse(null);
        assertNull(deleted);
    }


    @Test
    public void ListAllAppointmentStoredInDB() {
        appointment obj1 = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save1 = service.save(obj1);
        appointment   obj2 = new appointment("Bakul", "Kabir", "16/12/2020", "Give Temiflu", "Not Nconfirmed");
        appointment save2 = service.save(obj2);
        appointment  obj3 = new appointment("Naman", "sharad", "17/12/2020", "Give Fluvir", "confirmed");
        appointment save3 = service.save(obj3);
        List<appointment> appointments = service.listAll();
        assertEquals(save1.getPatientName(), obj1.getPatientName());
        assertEquals(save1.getDoctorName(), obj1.getDoctorName());
        assertEquals(save1.getDate(), obj1.getDate());
        assertEquals(save1.getPrescription(), obj1.getPrescription());
        assertEquals(save1.getConfirmed(), obj1.getConfirmed());
        assertEquals(save2.getPatientName(), obj2.getPatientName());
        assertEquals(save2.getDoctorName(), obj2.getDoctorName());
        assertEquals(save2.getDate(), obj2.getDate());
        assertEquals(save2.getPrescription(), obj2.getPrescription());
        assertEquals(save2.getConfirmed(), obj2.getConfirmed());
        assertEquals(save3.getPatientName(), obj3.getPatientName());
        assertEquals(save3.getDoctorName(), obj3.getDoctorName());
        assertEquals(save3.getDate(), obj3.getDate());
        assertEquals(save3.getPrescription(), obj3.getPrescription());
        assertEquals(save3.getConfirmed(), obj3.getConfirmed());
    }

    @Test
    public void getAppointmentByIdStoredInDB() {
        appointment obj1 = new appointment("Akash", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        appointment obj=service.get(save.getAppointmentId()).orElse(null);
        assertEquals(save.getPatientName(), obj.getPatientName());
        assertEquals(save.getDoctorName(), obj.getDoctorName());
        assertEquals(save.getDate(), obj.getDate());
        assertEquals(save.getPrescription(), obj.getPrescription());
        assertEquals(save.getConfirmed(), obj.getConfirmed());
    }

    @Test
    public void getAppointmentByDoctorNameStoredInDB() {
        appointment obj1 = new appointment("Pavan", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        appointment obj=service.findByDoctorName(obj1.getDoctorName()).get(0);
        assertEquals(save.getPatientName(), obj.getPatientName());
        assertEquals(save.getDoctorName(), obj.getDoctorName());
        assertEquals(save.getDate(), obj.getDate());
        assertEquals(save.getPrescription(), obj.getPrescription());
        assertEquals(save.getConfirmed(), obj.getConfirmed());
    }

    @Test
    public void getAppointmentByPatientNameStoredInDB() {
        appointment obj1 = new appointment("Raju", "Sumit", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        appointment obj=service.findByPatientName(obj1.getPatientName()).get(0);
        assertEquals(save.getPatientName(), obj.getPatientName());
        assertEquals(save.getDoctorName(), obj.getDoctorName());
        assertEquals(save.getDate(), obj.getDate());
        assertEquals(save.getPrescription(), obj.getPrescription());
        assertEquals(save.getConfirmed(), obj.getConfirmed());
    }

    @Test
    public void setAppointmentConfirmationStoredInDB() {
        appointment obj1 = new appointment("Man", "Naman", "20/12/2020", "Give Paracetamol", "not-confirmed");
        appointment save = service.save(obj1);
        assertEquals(save.getConfirmed(), obj1.getConfirmed());
        String confirmStatus="confirmed";
        service.setConfirmation(confirmStatus, save.getAppointmentId());
        appointment modified = repository.findById(save.getAppointmentId()).orElse(null);
        assertEquals(confirmStatus, modified.getConfirmed());
    }

    @Test
    public void setAppointmentPrescriptionStoredInDB() {
        appointment obj1 = new appointment("Man", "Naman", "20/12/2020", "Give Paracetamol", "not-confirmed");
        appointment save = service.save(obj1);
        assertEquals(save.getPrescription(), obj1.getPrescription());
        String prescription="Give Medicine for Maleria";
        service.setPrescription(prescription,save.getAppointmentId());
        appointment modified = repository.findById(save.getAppointmentId()).orElse(null);
        assertEquals(prescription, modified.getPrescription());
    }

    @Test
    public void getAppointmentByDateStoredInDB() {
        appointment obj1 = new appointment("kamal", "Ramesh", "25/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        appointment obj=service.findByDate("25/12/2020",obj1.getDoctorName()).get(0);
        assertEquals(save.getPatientName(), obj.getPatientName());
        assertEquals(save.getDoctorName(), obj.getDoctorName());
        assertEquals(save.getDate(), obj.getDate());
        assertEquals(save.getPrescription(), obj.getPrescription());
        assertEquals(save.getConfirmed(), obj.getConfirmed());
    }
}
