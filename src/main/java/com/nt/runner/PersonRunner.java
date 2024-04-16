package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.repo.PersonRepo;

import jakarta.persistence.Column;
import jakarta.transaction.Transactional;

@Component
public class PersonRunner implements CommandLineRunner {
	
	@Autowired
	private PersonRepo repo;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
//		@Column(name = "P_PHONES")
//		private Set<Long> phones;
//		
//		@Column(name = "P_IDETAIILS")
//		private Map<String, Long> idDetails;
		
		Person per=new Person();
		per.setPname("Raja");
		per.setFriends(List.of("Friend1","Friend2","Friend3"));
		
		per.setPhones(Set.of(8787877789L,5454585575L,975454255L));
		per.setIdDetails(Map.of("ADHAR",1878787L,"PAN",2585575L,"VOTER",754255L));
		repo.save(per);
		
		
	}

}
