package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.util.Properties;

public class setPr {
	public setPr() {}
	public setPr(String key,String vel,Properties p) {
		if(p.getProperty(key)==null) {
			p.setProperty(key, vel);
			System.out.println(key + " wurde erstellt");
			return;
		}
		System.out.println(key + " ist vorhanden " + p.getProperty(key));
		return;
	}

}
