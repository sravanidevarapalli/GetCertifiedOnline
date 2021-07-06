package com.GetCertifiedOnline.Service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.GetCertifiedOnline.Entity.Certification;
import com.GetCertifiedOnline.Repository.CertificationDao;
import com.GetCertifiedOnline.Service.CertificationServiceImpl;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)

public class TestCertificationService {
	@InjectMocks
	CertificationServiceImpl service;

	@Mock
	CertificationDao dao;
	@Test
	public void addCertificationTest() {

		Certification c = new Certification(1, "java", "abc", 2000, LocalDate.now());

		when(dao.saveAndFlush(c)).thenReturn(c);

		assertEquals(c, service.addcertification(c));
	}

		@Test
		public void updateCertificationTest() {

			Certification c = new Certification(1, "Html", "xyz", 1000, LocalDate.now() );
			when(dao.saveAndFlush(c)).thenReturn(c);

			assertEquals(c, service.updatecertification(c));
		}
			@Test
			public void viewAllCertificationTest() {

				List<Certification> list = new ArrayList<>();
				Certification c1 = new Certification(1, "python", "abc", 3000, LocalDate.now());
				Certification c2 = new Certification(2, "java", "abc", 4000, LocalDate.now());
				list.add(c2);
				list.add(c1);

				when(dao.findAll()).thenReturn(list);
				List<Certification> certificationList = service.viewAllcertification();
				assertEquals(2, certificationList.size());
				verify(dao, times(1)).findAll();

	}
			@Test 
			public void viewCertificationByIdTest() {
				 
				Certification c1 = new Certification(1, "python", "abc", 5000, LocalDate.now());
				Certification c2 = new Certification(1, "python", "abc", 6000, LocalDate.now());
				dao.saveAndFlush(c1);
				dao.saveAndFlush(c2);
			
			     when(dao.findById(c1.getCertificationId())).thenReturn(Optional.of(c1));
			     
			     assertEquals(c1,service.viewcertificationById(c1.getCertificationId()));
			}
			@Test
			public void testDeletebyCertificationId() {
				Certification c = new Certification(1, "python", "abc", 6000, LocalDate.now());
				
				
				when(dao.existsById(c.getCertificationId())).thenReturn(false);
				assertFalse(dao.existsById(c.getCertificationId()));
			}

}
