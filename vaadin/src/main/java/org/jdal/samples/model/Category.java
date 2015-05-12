package org.jdal.samples.model;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.jdal.model.Entity;

@javax.persistence.Entity
@Table(name="categories")
public class Category extends Entity {
	
	private static final long serialVersionUID = 1L;

	public String toString() {
		return getName();
	}
	
	@NotEmpty
	public String getName() {
		return super.getName();
	}
}
