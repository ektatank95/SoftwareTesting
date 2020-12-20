package com.company.varnaa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
 class prescriptionServiceTest {
    @Autowired
    private prescriptionService service;

    @Autowired
    private prescriptionRepository repository;

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
    public void givenPrescription_whenSaveAndRetreivePrescription() {
        //data preparation
        prescription prescription=new prescription("Aman",1,"Cold and Flu","Sameer");
        prescription save = service.save(prescription);
        prescription byId = repository.findById(save.getPrescriptionID()).orElse(null);
        assertEquals(save.getPatientName(),byId.getPatientName());
        assertEquals(save.getDoctorName(),byId.getDoctorName());
        assertEquals(save.getPrescriptionID(),byId.getPrescriptionID());
        assertEquals(save.getAppointmentID(),byId.getAppointmentID());
        assertEquals(save.getDescription(),byId.getDescription());
    }

    @Test
    public void givenPrescription_whenSaveAndRetreivePrescription_Negative() {
        //data preparation
        prescription prescription=new prescription("Aman",1,"Cold and Flu","Sameer");
      //  prescription save = service.save(prescription);
        prescription byId = repository.findById(1).orElse(null);
        assertNull(byId);
    }



    @Test
    public void givenPrescription_whenSaveAndRetreivePrescription_thenOK_RepositoryTest() {
        //data preparation
        prescription prescription=new prescription("Aman",1,"Cold and Flu","Sameer");
        prescription save = repository.save(prescription);
        prescription byId = repository.findById(save.getPrescriptionID()).orElse(null);
        assertEquals(save.getPatientName(),byId.getPatientName());
        assertEquals(save.getDoctorName(),byId.getDoctorName());
        assertEquals(save.getPrescriptionID(),byId.getPrescriptionID());
        assertEquals(save.getAppointmentID(),byId.getAppointmentID());
        assertEquals(save.getDescription(),byId.getDescription());
    }

    @Test
    public void findPrescriptionByNameTestatService_Negative(){
        prescription pre0 = new prescription("Arya", 12, "Fever", "sai");
        prescription pre1 = new prescription("rk", 13, "Fever", "Ama");
        prescription pre2 = new prescription("Arya", 16, "Fever", "Ama");
        prescription pre3 = new prescription("Rajat", 17, "Fever", "Ama");
        prescription pre4 = new prescription("Arya", 18, "Fever", "sai");
        service.save(pre0);
        service.save(pre1);
        service.save(pre2);
        service.save(pre3);
        service.save(pre4);
        String name = "Sharad";
        assertEquals(service.findByPatientName(name).size(),0);

    }

    @Test
    public void findPrescriptionByNameTest(){
        prescription pre0 = new prescription("Arya", 12, "Fever", "sai");
        prescription pre1 = new prescription("rk", 13, "Fever", "Ama");
        prescription pre2 = new prescription("Arya", 16, "Fever", "Ama");
        prescription pre3 = new prescription("Rajat", 17, "Fever", "Ama");
        prescription pre4 = new prescription("Arya", 18, "Fever", "sai");
        repository.save(pre0);
        repository.save(pre1);
        repository.save(pre2);
        repository.save(pre3);
        repository.save(pre4);
        String name = "Arya";
        assertEquals(pre0.getPatientName(),service.findByPatientName(name).get(0).getPatientName());
        assertEquals(pre0.getDoctorName(),service.findByPatientName(name).get(0).getDoctorName());
        assertEquals(pre0.getPrescriptionID(),service.findByPatientName(name).get(0).getPrescriptionID());
        assertEquals(pre0.getAppointmentID(),service.findByPatientName(name).get(0).getAppointmentID());
        assertEquals(pre0.getDescription(),service.findByPatientName(name).get(0).getDescription());

        assertEquals(pre2.getPatientName(),service.findByPatientName(name).get(1).getPatientName());
        assertEquals(pre2.getDoctorName(),service.findByPatientName(name).get(1).getDoctorName());
        assertEquals(pre2.getPrescriptionID(),service.findByPatientName(name).get(1).getPrescriptionID());
        assertEquals(pre2.getAppointmentID(),service.findByPatientName(name).get(1).getAppointmentID());
        assertEquals(pre2.getDescription(),service.findByPatientName(name).get(1).getDescription());

        assertEquals(pre4.getPatientName(),service.findByPatientName(name).get(2).getPatientName());
        assertEquals(pre4.getDoctorName(),service.findByPatientName(name).get(2).getDoctorName());
        assertEquals(pre4.getPrescriptionID(),service.findByPatientName(name).get(2).getPrescriptionID());
        assertEquals(pre4.getAppointmentID(),service.findByPatientName(name).get(2).getAppointmentID());
        assertEquals(pre4.getDescription(),service.findByPatientName(name).get(2).getDescription());
    }

    @Test
    public void findPrescriptionByNameTestRepository_Negative(){
        prescription pre0 = new prescription("Arya", 12, "Fever", "sai");
        prescription pre1 = new prescription("rk", 13, "Fever", "Ama");
        prescription pre2 = new prescription("Arya", 16, "Fever", "Ama");
        prescription pre3 = new prescription("Rajat", 17, "Fever", "Ama");
        prescription pre4 = new prescription("Arya", 18, "Fever", "sai");
        repository.save(pre0);
        repository.save(pre1);
        repository.save(pre2);
        repository.save(pre3);
        repository.save(pre4);
        String name = "Sharad";
        assertEquals(repository.findByPatientName(name).size(),0);

    }


}
