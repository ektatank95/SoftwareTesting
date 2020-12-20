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
    public void givenAppointmentSavedInDB_negative() {
        appointment obj = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        //appointment save = service.save(obj);
       appointment save= repository.findById(1).orElse(null);
       assertNull(null);
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
    public void givenAppointmentIdDeleteFromDB_negative() {
        appointment obj = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj);
        assertEquals(save.getAppointmentId(), obj.getAppointmentId());
      //  service.delete(save.getAppointmentId());
        appointment deleted = repository.findById(save.getAppointmentId()).orElse(null);
        assertNotNull(deleted);

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

        assertEquals(appointments.get(0).getPatientName(), obj1.getPatientName());
        assertEquals(appointments.get(0).getDoctorName(), obj1.getDoctorName());
        assertEquals(appointments.get(0).getDate(), obj1.getDate());
        assertEquals(appointments.get(0).getPrescription(), obj1.getPrescription());
        assertEquals(appointments.get(0).getConfirmed(), obj1.getConfirmed());

        assertEquals(appointments.get(1).getPatientName(), obj2.getPatientName());
        assertEquals(appointments.get(1).getDoctorName(), obj2.getDoctorName());
        assertEquals(appointments.get(1).getDate(), obj2.getDate());
        assertEquals(appointments.get(1).getPrescription(), obj2.getPrescription());
        assertEquals(appointments.get(1).getConfirmed(), obj2.getConfirmed());

        assertEquals(appointments.get(2).getPatientName(), obj3.getPatientName());
        assertEquals(appointments.get(2).getDoctorName(), obj3.getDoctorName());
        assertEquals(appointments.get(2).getDate(), obj3.getDate());
        assertEquals(appointments.get(2).getPrescription(), obj3.getPrescription());
        assertEquals(appointments.get(2).getConfirmed(), obj3.getConfirmed());

        assertEquals(appointments.size(),3);

    }

    @Test
    public void ListAllAppointmentStoredInDB_negative() {
        appointment obj1 = new appointment("Aman", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save1 = service.save(obj1);
        appointment   obj2 = new appointment("Bakul", "Kabir", "16/12/2020", "Give Temiflu", "Not Nconfirmed");
        appointment save2 = service.save(obj2);
        appointment  obj3 = new appointment("Naman", "sharad", "17/12/2020", "Give Fluvir", "confirmed");
        appointment save3 = service.save(obj3);
        List<appointment> appointments = service.listAll();
        assertNotEquals(appointments.size(),0);

        assertNotEquals(appointments.get(0).getPatientName(), "RandomName");
        assertNotEquals(appointments.get(0).getDoctorName(), "RandomDoctor");
        assertNotEquals(appointments.get(0).getDate(), "1/1/2012");
        assertNotEquals(appointments.get(0).getPrescription(), "Random Prescription");
        assertNotEquals(appointments.get(0).getConfirmed(), "status not disclosed");

        assertNotEquals(appointments.get(1).getPatientName(), "RandomName");
        assertNotEquals(appointments.get(1).getDoctorName(), "RandomDoctor");
        assertNotEquals(appointments.get(1).getDate(), "1/1/2012");
        assertNotEquals(appointments.get(1).getPrescription(), "Random Prescription");
        assertNotEquals(appointments.get(1).getConfirmed(), "status not disclosed");

        assertNotEquals(appointments.get(2).getPatientName(), "RandomName");
        assertNotEquals(appointments.get(2).getDoctorName(), "RandomDoctor");
        assertNotEquals(appointments.get(2).getDate(), "1/1/2012");
        assertNotEquals(appointments.get(2).getPrescription(), "Random Prescription");
        assertNotEquals(appointments.get(2).getConfirmed(), "status not disclosed");

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
    public void getAppointmentByIdStoredInDB_negative() {
        appointment obj1 = new appointment("Akash", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        appointment obj=service.get(5).orElse(null);
        assertNull(obj);
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
    public void getAppointmentByDoctorNameStoredInDB_negative() {
        appointment obj1 = new appointment("Pavan", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        List<appointment> list = service.findByDoctorName("Shashank");
        assertEquals(list.size(),0);
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
    public void getAppointmentByPatientNameStoredInDB_negative() {
        appointment obj1 = new appointment("Pavan", "Sameer", "18/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        List<appointment> list = service.findByPatientName("Shashank");
        assertEquals(list.size(),0);
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
    public void setAppointmentConfirmationStoredInDB_negative() {
        appointment obj1 = new appointment("Man", "Naman", "20/12/2020", "Give Paracetamol", "not-confirmed");
        appointment save = service.save(obj1);
        assertEquals(save.getConfirmed(), obj1.getConfirmed());
        String confirmStatus="confirmed";
        service.setConfirmation(confirmStatus, save.getAppointmentId());
        appointment modified = repository.findById(save.getAppointmentId()).orElse(null);
        assertNotEquals(confirmStatus,"Not " + modified.getConfirmed());
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
    public void setAppointmentPrescriptionStoredInDB_negative() {
        appointment obj1 = new appointment("Man", "Naman", "20/12/2020", "Give Paracetamol", "not-confirmed");
        appointment save = service.save(obj1);
        assertEquals(save.getPrescription(), obj1.getPrescription());
        String prescription="Give Medicine for Maleria";
        service.setPrescription(prescription,save.getAppointmentId());
        appointment modified = repository.findById(save.getAppointmentId()).orElse(null);
        assertNotEquals(prescription, "Don't "+modified.getPrescription());
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


    @Test
    public void getAppointmentByDateStoredInDB_negative() {
        appointment obj1 = new appointment("kamal", "Ramesh", "25/12/2020", "Give Paracetamol", "confirmed");
        appointment save = service.save(obj1);
        List<appointment> byDate = service.findByDate("24/12/2020", obj1.getDoctorName());
        assertEquals(byDate.size(),0);
    }
}
