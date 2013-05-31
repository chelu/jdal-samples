package org.jdal.samples.library;

import javax.swing.JFrame;

import org.jdal.beans.AppCtx;
import org.jdal.swing.ApplicationContextGuiFactory;
import org.jdal.swing.ListPane;

/**
 * Launch JDAL Library Demo
 * 
 * @author Jose Luis Martin - (jlm@joseluismartin.info)
 */
public class Main {
	
	public static void main (String[] args) {
		
		ApplicationContextGuiFactory.setPlasticLookAndFeel();
		AppCtx.setConfigPackage("conf");
		
		JFrame f = new JFrame("JDAL Swing Library Demo 2.0");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ListPane listPane = (ListPane) AppCtx.getInstance().getBean("listPanel");
		f.add(listPane);
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
