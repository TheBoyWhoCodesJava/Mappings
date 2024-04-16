package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PID")
	private Integer pid;
	@Column(name = "P_NAME")
	private String pname;
	
	@ElementCollection
	@OrderColumn(name = "INDEX")
	@ListIndexBase(value = 1)
	@CollectionTable(name ="PERSON_FRIENDS",joinColumns = @JoinColumn(name="PID_FRNDS_FK",referencedColumnName = "PID"))
	@Column(name = "P_FRIENDS")
	private List<String> friends;
	
	
	@ElementCollection
	@CollectionTable(name = "PERSON_PHONES",joinColumns = @JoinColumn(name="PID_PHONES_FK",referencedColumnName = "PID"))
	@Column(name = "P_PHONES")
	private Set<Long> phones;
	
	@MapKeyColumn(name = "ID_NAME")
	@ElementCollection
	@CollectionTable(name = "PERSON_IDETAILS",joinColumns =@JoinColumn(referencedColumnName = "PID",name="PID_DETAILS_FK"))
	@Column(name = "P_IDETAILS_VALUE")
	private Map<String, Long> idDetails;
	
	
}
