package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Specialization;
import com.example.demo.repository.SpecializationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationRepositoryTest {
	
	private SpecializationRepository repo;
	
	@Test
	@Order(1)
	public void testSpecCreate()
	{
		Specialization spec = new Specialization(null, "CARDIOLIGIST","CRDL" , "Expert in heart");
		spec = repo.save(spec);
		assertNotNull(spec.getId(),"spec is not created");
		
	}
	
	@Test
	@Order(2)
	public void testSpecFetchAll()
	{
		List<Specialization> mylist = repo.findAll();
		assertNotNull(mylist);
		if(mylist.isEmpty())
		{
			fail("No data exist in db");
		}
		}
	

}
