package org.jdal.samples.library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@javax.persistence.Entity
@Table(name="categories")
/**
 * Category Entity
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	@NotBlank
	protected String name = "";
	
	public String toString() {
		return getName();
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
