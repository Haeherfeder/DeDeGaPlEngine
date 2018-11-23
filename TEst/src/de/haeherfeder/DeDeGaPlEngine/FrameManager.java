package de.haeherfeder.DeDeGaPlEngine;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
/**
 * This class is Named FrameManager because Frame isn't possible, because of java.awt.Frame, which is used
 * 
 * 
 */
public class FrameManager {
	public FrameManager() {
		
	}
	public Frame setFrame(String Name,int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3) {
		Frame f = new Frame(Name);
		f.setLayout(new GridLayout());
		for(int i = 0;i<n;i++) {
			System.out.println("for");
			switch(i) {
			case 0:
				System.out.println("case 0");
			case 1:	
				f.add(la1);
				f.add(p1);
				System.out.println("case 1");
				break;
			case 2:
				f.add(la2);
				f.add(p2);
				System.out.println("case 2");
				break;
			case 3:
				f.add(la3);
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