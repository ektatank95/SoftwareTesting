package com.company.varnaa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalManagementSystemApplicationTests {

	@Autowired
	private prescriptionService service;

	@MockBean
	private prescriptionRepository repository;

//	@Test
//	public void getPrescriptionTest(){
//		String name = "Arya";
//		when(repository.findByPatientName(name)).thenReturn(Stream.of(new prescription("Arya", 12, "Fever", "sai"), new prescription("rk",11,"cough","Rahul")).collect((Collectors.toList())));
//		assertEquals(2, service.findByPatientName(name).size());
//	}

	@Test
	void contextLoads() {
	}

}
