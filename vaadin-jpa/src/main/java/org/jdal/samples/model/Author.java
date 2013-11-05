package org.jdal.samples.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="authors")
@Filter(name="authorByNameFilter", condition="name like :pattern or surname like :pattern")
@FilterDef(name="authorByNameFilter", parameters=@ParamDef(name="pattern", type="string"))
public class Author implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return surname + (name != null ? ", " + name : ""); 
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
