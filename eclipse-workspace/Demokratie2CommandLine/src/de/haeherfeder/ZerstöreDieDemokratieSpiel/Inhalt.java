package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.util.EnumMap;
import java.util.EnumSet;

public enum Inhalt {
	Start ("hi","Test","ddd","Start"),
	ddd ("hi2","Test3","Start","Start"),
	Test("hi314","ende",null,null);
	
	public String Name;
	public String Inhalt;
	public String nexta;
	public String nextb;
//	public Enum Inh;
	
	Inhalt(String Name,String Inhalt,String nexta,String nextb){
		this.Name = Name;
		this.Inhalt = Inhalt;
		this.nexta = nexta;
		this.nextb = nextb;
	}
		
	public String getName() {
		return Name;
	}
		
	public String getText() {
		return Inhalt;
	}
	public String getnexta() {
		return nexta;
	}
	public String getnextb() {
		return nextb;
	}
}