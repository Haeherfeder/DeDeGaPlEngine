/**
 * 
 */
package de.haeherfeder.DeDePlEngine.all;

import java.util.Properties;

/**
 * @author benjamin
 *
 */
public class Methoden {
	public static String a;  
	public static String getType() {
		return a;
	}
	public static void setType(String type) {
		a = type;
	}
	public static void setPr(String key,String vel,Properties p) {
		if(p.getProperty(key)==null) {
			p.setProperty(key, vel);
			return;
		}
		return;
	}
}
