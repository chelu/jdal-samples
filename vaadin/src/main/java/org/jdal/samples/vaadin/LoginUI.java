package org.jdal.samples.vaadin;

import org.jdal.vaadin.annotation.UiMapping;

import com.vaadin.annotations.Theme;

/**
 * Extends only to add the {@link Theme} annotation
 * @author Jose Luis Martin
 * @since 2.1
 */
@Theme("sample")
@UiMapping("/login")
public class LoginUI extends org.jdal.vaadin.auth.LoginUI {

}
