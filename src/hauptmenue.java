import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;




public class hauptmenue{
		
		//"Behaelter"
		JPanel container;
	
		//Buttons
		JButton start;
		JButton optionen;
		JButton highscore;	
		JButton ende;
		
		//Ueberschrift
		JLabel ueberschrift = new JLabel ("UFO");
		
		//untermenue
		JLabel fehler 	=  new JLabel("FEHLER");
		
			//optionen	
				//Buttons zu festlegen der steuerung
				JButton hochb1	= new JButton("HOCH");
				JButton runterb1	= new JButton("RUNTER");
				JButton linksb1	= new JButton("LINKS");
				JButton rechtsb1	= new JButton("RECHTS");
			
				static JToggleButton hochb2		= new JToggleButton("");
				static JToggleButton runterb2	= new JToggleButton("");
				static JToggleButton linksb2	= new JToggleButton("");
				static JToggleButton rechtsb2	= new JToggleButton("");
				
				static boolean hochwahr	 = false;
				static boolean runterwahr= false;
				static boolean linkswahr = false;
				static boolean rechtsahr = false;
				
				//schwierigkeitsgrad
				static boolean leicht;
				static boolean mittel;
				static boolean schwer;
				ButtonGroup box =new ButtonGroup();
				JRadioButton leichtbox = new JRadioButton("Leicht");
				JRadioButton mittelbox = new JRadioButton("Mittel");
				JRadioButton schwerbox = new JRadioButton("Schwer");
		
			//highscore
			static int[] highscoreliste = new int[6];
			
			JLabel hsue = new JLabel("HIGHSCORE");
			JLabel hs1;
			JLabel hs2;
			JLabel hs3;
			JLabel hs4;
			JLabel hs5;
			
		//zurueck zum hauptmenue button	
		JButton zurueck	= new JButton("ZURUCK");
		
		
	public hauptmenue(){
		
		//"Behaelter"
			container = new JPanel();
		
			container.setLayout(null);
			
			//Hintergrundfarbe
			container.setBackground(new Color(5,0,10));
		
			game.fenster.add(container);
		
			//sterne setzen
			new menuesterne(container,true);
		
		
		//ueberschrift
		ueberschrift.setForeground(Color.YELLOW);
		ueberschrift.setFont(new Font ("Monospaced",Font.BOLD,200));
		
		//Button-Beschriftung
		start		= new JButton("START");
		optionen	= new JButton("OPTIONEN");
		highscore	= new JButton("HIGHSCORE");
		ende		= new JButton("ENDE");
		
		//"knopfdruck" festlegen
		start		.addActionListener(new knopfdruck());
		optionen	.addActionListener(new knopfdruck());
		highscore	.addActionListener(new knopfdruck());
		ende		.addActionListener(new knopfdruck());

		zurueck		.addActionListener(new knopfdruck());
		
		//alle komponenten zum container hinzufuegen

		container.add(ueberschrift);
		container.add(start);
		container.add(optionen);
		container.add(highscore);
		container.add(ende);
	

		//positionen festlegen
		start		.setBounds(300, 247, 200, 50);
		optionen	.setBounds(300, 299, 200, 50);
		highscore	.setBounds(300, 351, 200, 50);
		ende		.setBounds(300, 403, 200, 50);
		ueberschrift.setBounds(220, 20 , 500, 200);
		
		//optionen
		box.add(leichtbox);
		box.add(mittelbox);
		box.add(schwerbox);
		
		leichtbox.setBounds(245,350,100,50);
		mittelbox.setBounds(350,350,100,50);
		schwerbox.setBounds(455,350,100,50);
		
		leichtbox.setForeground(Color.YELLOW);
		leichtbox.setFont(new Font ("Monospaced",Font.BOLD,20));

		mittelbox.setForeground(Color.YELLOW);
		mittelbox.setFont(new Font ("Monospaced",Font.BOLD,20));

		schwerbox.setForeground(Color.YELLOW);
		schwerbox.setFont(new Font ("Monospaced",Font.BOLD,20));
		
		leichtbox.setOpaque(false);
		mittelbox.setOpaque(false);
		schwerbox.setOpaque(false);
		
		leichtbox.addActionListener(new knopfdruck());
		mittelbox.addActionListener(new knopfdruck());
		schwerbox.addActionListener(new knopfdruck());
		
		hochb2	.addActionListener(new knopfdruck());
		runterb2.addActionListener(new knopfdruck());
		linksb2	.addActionListener(new knopfdruck());
		rechtsb2.addActionListener(new knopfdruck());

	
	}
		//knopfdruck
		private class knopfdruck implements ActionListener {

			public void actionPerformed(ActionEvent  e) {
				
				//Spielstart
				if(e.getSource()==start){
					
					game.fenster.remove(container);
				
					new spiel();
			
				}
				
				//Steuerung festlegen
				if(e.getSource()==optionen){
					
					//alte componenten entfernen
					container.remove(ueberschrift);
					container.remove(start);
					container.remove(optionen);
					container.remove(highscore);
					container.remove(ende);
					
					
			
					//neue hinzufuegen
					
					//steuerung
					container.add(hochb1);
						hochb1	.setBounds(200, 97 , 200, 50);
					container.add(runterb1);
						runterb1	.setBounds(200, 149 , 200, 50);
					container.add(linksb1);
						linksb1	.setBounds(200, 201 , 200, 50);
					container.add(rechtsb1);
						rechtsb1	.setBounds(200, 253 , 200, 50);
						
					container.add(hochb2);
						hochb2	.setBounds(400, 97 , 200, 50);
					container.add(runterb2);
						runterb2	.setBounds(400, 149 , 200, 50);
					container.add(linksb2);
						linksb2	.setBounds(400, 201 , 200, 50);
					container.add(rechtsb2);
						rechtsb2	.setBounds(400, 253 , 200, 50);
						
						
					container.add(leichtbox);	
					container.add(mittelbox);	
					container.add(schwerbox);	
					
					
					if(leicht==true){
						leichtbox.setSelected(true);
					}
					if(mittel==true){
						mittelbox.setSelected(true);
					}
					if(schwer==true){
						schwerbox.setSelected(true);
					}

					container.add(zurueck);
						zurueck.setBounds(300, 450 , 200, 50);
						
						
				container.add(zurueck);

					
				}
				
				if(e.getSource()==hochb2){
					game.fenster.requestFocus();
				}
				if(e.getSource()==runterb2){
					game.fenster.requestFocus();
				}
		
				if(e.getSource()==linksb2){
					game.fenster.requestFocus();
				}
				
				if(e.getSource()==rechtsb2){
					game.fenster.requestFocus();
				}
				
		
				//Schwierigkeitsgrad
				if(e.getSource()==leichtbox){
					leicht=true;
					mittel=false;
					schwer=false;
				}
				if(e.getSource()==mittelbox){
					leicht=false;
					mittel=true;
					schwer=false;
				}
				if(e.getSource()==schwerbox){
					leicht=false;
					mittel=false;
					schwer=true;
				}
				
				
				if(e.getSource()==highscore){
					
					//alte componenten entfernen
					container.remove(ueberschrift);
					container.remove(start);
					container.remove(optionen);
					container.remove(highscore);
					container.remove(ende);
					
					//neue hinzufuegen
					container.add(hsue);
						hsue.setBounds(270, 75 , 300 ,50 );
						hsue.setForeground(Color.YELLOW);
						hsue.setFont(new Font ("Monospaced",Font.BOLD,50));
					
					hs1=new JLabel("1. "+highscoreliste[5]);	
						container.add(hs1);
						hs1.setBounds(350, 150 , 400,50 );
						hs1.setForeground(Color.YELLOW);
						hs1.setFont(new Font ("Monospaced",Font.BOLD,30));
						
					hs2=new JLabel("2. "+highscoreliste[4]);	
						container.add(hs2);
						hs2.setBounds(350, 200 , 400,50 );
						hs2.setForeground(Color.YELLOW);
						hs2.setFont(new Font ("Monospaced",Font.BOLD,30));
						
					hs3=new JLabel("3. "+highscoreliste[3]);	
						container.add(hs3);
						hs3.setBounds(350, 250 , 400,50 );
						hs3.setForeground(Color.YELLOW);
						hs3.setFont(new Font ("Monospaced",Font.BOLD,30));
						
					hs4=new JLabel("4. "+highscoreliste[2]);	
						container.add(hs4);
						hs4.setBounds(350, 300 , 400,50 );
						hs4.setForeground(Color.YELLOW);
						hs4.setFont(new Font ("Monospaced",Font.BOLD,30));
						
					hs5=new JLabel("5. "+highscoreliste[1]);	
						container.add(hs5);
						hs5.setBounds(350, 350 , 400,50 );
						hs5.setForeground(Color.YELLOW);
						hs5.setFont(new Font ("Monospaced",Font.BOLD,30));
					
					container.add(zurueck);
						zurueck.setBounds(300, 450 , 200, 50);
						
				
				container.add(zurueck);
				}
				
				//Spiel beenden
				if(e.getSource()==ende){
					game.fenster.dispose();
				}
				
				//zurueck zum hauptmenue
				if(e.getSource()==zurueck){
					
					hochb2.setSelected(false);
					runterb2.setSelected(false);
					linksb2.setSelected(false);
					rechtsb2.setSelected(false);
					
					spielschleife.speichern=true;
					
					game.fenster.remove(container);
					new hauptmenue();
					
					
				}
				
			}
		}
		
		
		
	
}


