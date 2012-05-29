package jbo.dataviewer;

import org.duckham.oracle.OracleDataViewer;

public class DataViewer {
	
	public static void main(String[] args) {
		
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new OracleDataViewer().setVisible(true);
	            }
	        });
		
	}
	
}
