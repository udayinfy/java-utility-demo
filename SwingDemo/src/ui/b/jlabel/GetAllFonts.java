package ui.b.jlabel;

import java.awt.GraphicsEnvironment  ;

public class GetAllFonts{
	public static void main(String args[]){
		GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment() ;
		String fontNames[] = eq.getAvailableFontFamilyNames() ;
		for(int x=0;x<fontNames.length;x++){
			System.out.println(fontNames[x]) ;
		}
	}
}; 