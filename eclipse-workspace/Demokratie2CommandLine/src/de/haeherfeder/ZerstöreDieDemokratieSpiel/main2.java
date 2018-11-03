/**-------------------------------------------------------ä
 * 
 */
package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.IOException;
public class main2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
/*	JFrame gameTest = new JFrame();
	gameTest.setTitle("Game Register");
	gameTest.setSize(300, 150);
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Name");
	panel.add(label);
	JTextField tfName = new JTextField("Test",20);
//	JLabel label2 = new JLabel("Name");
	JTextField tfName2 = new JTextField("T3st",20);
	panel.add(tfName);
	panel.add(tfName2);
	JButton buttonOK = new JButton("OK");
	panel.add(buttonOK);
//	buttonOK.addActionListener();
	gameTest.add(panel);
//	gameTest.setDefaultCloseOperation(0);
	String Name = null;
	gameTest.setVisible(true);	
	register(Name,panel,tfName,tfName2);*/
	new main2();
	System.out.println("Ende");
	return;
	}
/*	private void register(String Name, JPanel panel,JTextField tfName,JTextField tfName2) {
		while(!false) {
			Name = tfName.getText();
			panel.remove(tfName2);
			tfName2 = new JTextField(Name,10);
			panel.add(tfName2);
		}
	}*/
	/*public void Start(String g){
		TextField tf1,tf2,tf3 = null;
		Label l1,l2,l3 = null; 
		Panel p1,p2,p3 = null;
		Frame f = null;
		String Text = null;
		System.out.println(Inhalt.values());
		int b,h;
		b = 800;
		h = 400;
		System.out.print("HI ");
		int hi = 3;
		System.out.println(hi);
		tf1 = TextFieldG("Hallo",20);
		tf2 = TextFieldG("h",1);
		tf3 = TextFieldG("",1);
		p1 = PanelG(tf1);
		p2 = PanelG(tf2);
		p3 = PanelG(tf3);
		l1 = LabelG("Inhalt");
		l2 = LabelG("J");
		f = FrameG("Text Show",h,b,3,p1,l1,p2,l2,p3,l3);
//		f.remove(p1);
//		TextField tf2 = new TextField(Text);
		System.out.println("f");
//		f.add(p1);
		while(true) {
			System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tf2.getText().matches("J")) {
			System.out.println("Ende, J gelesen.");
			break;
		}
		}
		Text = tf1.getText();
		System.out.println("Text: " + Text);
		String Inhalt2 = Inhalt.Start.getText();
		switch(Text) {
			case "a":
			case "A":
				f.removeAll();
				String na = Inhalt.Start.getnexta();
				Label a = LabelG(Inhalt.Start.getnexta());
				Start("ddd");
				f.add(a);
				f.pack();
				f.setSize(b, h);
				f.setVisible(true);
				break;
			default:
				break;
		}
		System.out.println(Inhalt2);
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.removeAll();
		f.setVisible(false);
		return;
	}*/
	public main2() throws IOException { 
		configFR conf = new configFR();
		conf.configFRSt();
		System.out.println(conf.getProp("key"));
		conf.setPr("CurrentPlayer","");
		String Gamestart = null;
		System.out.println("hi, \ndies ist eine Neue Zeile.");
		GameWindow game = new GameWindow(Gamestart);
		return;
	}/*
	public Panel PanelG(TextField tf) {
		Panel p = new Panel();
		p.add(tf);
		return p;
	}
	public TextField TextFieldG(String text, int len) {
		TextField tf = new TextField(text,len);
		return tf;
	}
	public Frame FrameG(String Name,int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3) {
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
		
	}*/
}