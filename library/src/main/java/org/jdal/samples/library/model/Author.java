package org.jdal.samples.library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.NotBlank;


@javax.persistence.Entity
@Table(name="authors")
@Filter(name="patternFilter", condition="name like :pattern or surname like :pattern")
@FilterDef(name="patternFilter", parameters=@ParamDef(name="pattern", type="string"))
/**
 * Author Entity 
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class Author  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	@NotBlank
	protected String name = "";
	@NotBlank
	private String surname = "";

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
		return name + " " + surname;
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
