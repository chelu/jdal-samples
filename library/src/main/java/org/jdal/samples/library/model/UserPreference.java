/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdal.samples.library.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model to store table preferences on database.
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
@Entity
@Table(name="user_preference")
public class UserPreference extends info.joseluismartin.model.UserPreference {
	
	/**
	 * @return the user
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return (User) super.getUser();
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		super.setUser(user);
	}


}
