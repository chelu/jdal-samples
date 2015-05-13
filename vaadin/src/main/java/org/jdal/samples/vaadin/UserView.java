package org.jdal.samples.vaadin;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdal.auth.AuthStrategy;
import org.jdal.dao.Dao;
import org.jdal.samples.model.Role;
import org.jdal.samples.model.User;
import org.jdal.util.comparator.PropertyComparator;
import org.jdal.vaadin.ui.AbstractView;
import org.jdal.vaadin.ui.FormUtils;
import org.jdal.vaadin.ui.form.BoxFormBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;

import com.vaadin.ui.Component;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TwinColSelect;

public class UserView extends AbstractView<User> {
	
	private static final Log log = LogFactory.getLog(UserView.class);
	
	private TextField username = FormUtils.newTextField();
	private TextField name = FormUtils.newTextField();
	private TextField surname = FormUtils.newTextField();
	private TextField email = FormUtils.newTextField();
	private PasswordField passwd = FormUtils.newPasswordField();
	private PasswordField retypePasswd = FormUtils.newPasswordField();
	private TwinColSelect roles = new TwinColSelect();

	@Autowired
	private AuthStrategy authStrategy;
	@Resource
	private Dao<Role, Long> roleService;
	
	public UserView() {
		this(new User());
	}

	public UserView(User model) {
		super(model);
	}
	
	@PostConstruct
	public void init() {
		List<Role> all = this.roleService.getAll();
		Collections.sort(all, new PropertyComparator("role"));
		this.roles.addItems(all);
		autobind();
	}

	@Override
	protected Component buildPanel() {
		BoxFormBuilder fb = new BoxFormBuilder();
		fb.setMargin(false);
		fb.setUseTabIndex(true);
		fb.setDefaultWidth(BoxFormBuilder.SIZE_FULL);
		fb.row();
		fb.startBox();
		fb.setFixedHeight();
		fb.row();
		fb.add(name, getMessage("name"));
		fb.add(surname, getMessage("surname"));
		fb.row();
		fb.add(username, getMessage("username"));
		fb.add(email, getMessage("email"));
		fb.row();
		fb.add(passwd, getMessage("password"));
		fb.add(retypePasswd, getMessage("retypePassword"));
		fb.endBox();
		fb.row(BoxFormBuilder.SIZE_FULL);
		fb.add(roles, getMessage("roles"));
		
		return fb.getForm();
	}
	
	@Override
	public void doUpdate() {
		String p = passwd.getValue();
		if (!StringUtils.isEmpty(p)) {
			if (p.equals(retypePasswd.getValue())) {
				try {
					getModel().setPassword(authStrategy.crypt(p));
				} catch (NoSuchAlgorithmException e) {
					log.error(e);
				}
			}
			else {
				addError(new FieldError("passwordMitmatch", "passwd", "Passwords doesn't match"));
			}
		}
		
	}

}
