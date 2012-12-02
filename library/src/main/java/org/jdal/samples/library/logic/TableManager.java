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
package org.jdal.samples.library.logic;

import info.joseluismartin.logic.TableManagerSupport;
import info.joseluismartin.model.User;
import info.joseluismartin.service.TableService;

/**
 * Store table preferences on database.
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class TableManager extends TableManagerSupport implements TableService {

	User user = new User();
	
	public TableManager() {
		user.setName("DefaultUser");
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected User getUser() {
		// should get it from SecurityContext
		return user;    
	}

}
