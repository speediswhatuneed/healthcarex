package com.example.demo.seviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Specialization;
import com.example.demo.repository.SpecializationRepository;
import com.example.demo.service.ISpecializationService;

public class SpecialziationImp implements ISpecializationService{
	
	@Autowired
	private SpecializationRepository repo;

	@Override
	public Long saveSpecialization(Specialization spec) {
		
		return repo.save(spec).getId();
		
	}

	@Override
	public List<Specialization> getAllSpecializations() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Long id) {

		 repo.deleteById(id);
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization> specs = repo.findById(id);
	    if(specs.isPresent())
	    {
	    	return specs.get();
	    }
	    else
	    {
	    	return null; 
	    }
		// TODO Auto-generated method stub
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
		
	}

}
