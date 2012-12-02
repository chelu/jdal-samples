package org.jdal.samples.library;

import info.joseluismartin.beans.AppCtx;
import info.joseluismartin.gui.ApplicationContextGuiFactory;
import info.joseluismartin.gui.ListPane;

import javax.swing.JFrame;

/**
 * Launch JDAL Library Demo
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class Main {
	
	public static void main (String[] args) {
		
		ApplicationContextGuiFactory.setPlasticLookAndFeel();
		AppCtx.setConfigPackage("conf");
		
		JFrame f = new JFrame("JDAL Library Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ListPane listPane = (ListPane) AppCtx.getInstance().getBean("listPanel");
		f.add(listPane);
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
