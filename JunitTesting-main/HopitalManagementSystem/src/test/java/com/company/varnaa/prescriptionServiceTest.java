package com.company.varnaa;

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
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
 class prescriptionServiceTest {
    @Autowired
    private prescriptionService service;

    @Autowired
    private prescriptionRepository repository;

    @Test
    public void getPrescriptionTest(){
        String name = "Arya";
        when(repository.findByPatientName(name)).thenReturn(Stream.of(new prescription("Arya", 12, "Fever", "sai"), new prescription("rk",11,"cough","Rahul")).collect((Collectors.toList())));
        System.out.println("Paitent name is"+service.findByPatientName(name).get(0).getPatientName());
        assertEquals(2, service.findByPatientName(name).size());
    }

    @Test
    public void givenPrescription_whenSaveAndRetreivePrescription_thenOK() {
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

}
