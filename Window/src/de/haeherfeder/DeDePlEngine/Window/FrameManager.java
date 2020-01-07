package de.haeherfeder.DeDePlEngine.Window;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
/**
 * This class is Named FrameManager because Frame isn't possible, because of java.awt.Frame, which is used
 * 
 * 
 */
public class FrameManager {
	public static Frame setFrame(String Name,int h, int b,int n, Panel p1, TextArea l1,Panel p2,TextArea l2,Panel p3, TextArea l3) {
		Frame f = new Frame(Name);
		f.setLayout(new GridLayout());
		for(int i = 0;i<n&&i<4;i++) {
			System.out.println("for");
			switch(i) {
			case 0:
				System.out.println("case 0");
			case 1:	
				f.add(l1);
				f.add(p1);
				System.out.println("case 1");
				break;
			case 2:
				f.add(l2);
				f.add(p2);
				System.out.println("case 2");
				break;
			case 3:
				f.add(l3);
				f.add(p3);
				System.out.println("case 3");
			break;
			default:
				System.out.println("cas def");
				break;
			}
		}
		f.pack();
		f.setSize(b, h);
		f.setVisible(true);
		return f;
	}
}