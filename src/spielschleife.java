import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;


public class spielschleife implements Runnable {
	
	//spielschleife
	Thread gameloop;
	
	
	//ufo=spieler
		static int ufo_x 	= 400;
		static int ufo_y 	= 300;
		static double ufo_xspeed 	= 0;
		static double ufo_yspeed 	= 0;
		static int ufo_speed= 5;
	
		static BufferedImage ufo;
		static BufferedImage ufooben	;
		static BufferedImage ufounten	;
		static BufferedImage uforechts	;
		static BufferedImage ufolinks	;
	
	//meteoriten
		static BufferedImage meteorimg	;
		static int[][] meteor;
		static int[][] meteorverlaengern;
		static int metverl=1;
		static int metanzahl;
		static int metspeed;

	

	//zeit fuer anzeige der spieldauer
		static Date zeit =null;
		static int startcountdown;
		FileOutputStream output;	
		DataOutputStream datop;	
		static boolean speichern = false;
		
		
		
	public spielschleife(){

		
		//Spielschleife starten
		gameloop = new Thread(this);
		gameloop.start();
		
		
		try {	output = new FileOutputStream("highscore.txt");
		} catch (IOException e) {}
	
		//Bilder laden
		try {	ufooben = ImageIO.read(getClass().getResource("ufooben.png"));
		} catch (IOException e) {}
		
		try {	ufounten = ImageIO.read(getClass().getResource("ufounten.png"));
		} catch (IOException e) {}
		
		try {	uforechts = ImageIO.read(getClass().getResource("uforechts.png"));
		} catch (IOException e) {}
		
		try {	ufolinks = ImageIO.read(getClass().getResource("ufolinks.png"));
		} catch (IOException e) {}
		
		ufo=ufooben;
		
		try {	meteorimg = ImageIO.read(getClass().getResource("meteor.png"));
		} catch (IOException e) {}
		
	}
	
	//spielschleife
	public void run(){
		
		//waehrenddem das programm laeuft
		while(game.fenster.isVisible()){
			
			
			
			//waehrend des eigentlichen spiels
			if(spiel.spiellaeuft==true){
				
				zusatz.ufobewegung();
				
				//neue zeit fuer zeitanzeige
				zeit=new Date();
				
				zusatz.meteoritenbewegung();
				
				//Kollisionscheck
				if(zusatz.kollisionscheck()){
					game.fenster.repaint();
					hauptmenue.highscoreliste[0]=(int)(spielschleife.zeit.getTime()-spiel.startzeit.getTime())/1000;
					java.util.Arrays.sort(hauptmenue.highscoreliste);
					speichern=true;
					
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {}
					
					
					spiel.spiellaeuft=false;
					game.fenster.remove(spiel.gamecont);
					new hauptmenue();
				}
				
				
				
				
				if(metverl==((spielschleife.zeit.getTime()-spiel.startzeit.getTime())/1000)/metverl){
					meteorverlaengern = new int[meteor.length][4];
					for(int i=0;i<meteor.length;i++){
						meteorverlaengern[i][0]=meteor[i][0];
						meteorverlaengern[i][1]=meteor[i][1];
						meteorverlaengern[i][2]=meteor[i][2];
						meteorverlaengern[i][3]=meteor[i][3];
					}
					meteor=new int[meteorverlaengern.length+1][4];
					for(int i=0;i<meteorverlaengern.length;i++){
						meteor[i][0]=meteorverlaengern[i][0];
						meteor[i][1]=meteorverlaengern[i][1];
						meteor[i][2]=meteorverlaengern[i][2];
						meteor[i][3]=meteorverlaengern[i][3];
		
					}
					meteor[meteor.length-1]=zusatz.spawnset(metspeed);
					metverl+=1;
				
				}
			
			
			}
	
			
			game.fenster.repaint();
			if(spiel.start==true){
				for(startcountdown = 3;startcountdown>0;startcountdown--){
					try {
						game.fenster.repaint();
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
				spiel.startzeit   = new Date();
				spiel.start = false;
			}
			
			if(speichern==true){

				try {	output = new FileOutputStream("optionen.txt");
						datop  = new DataOutputStream(output);
				} catch (IOException e) {e.printStackTrace();}
				
				
						try {
							datop.writeInt(hauptmenue.highscoreliste[1]);
							datop.writeInt(hauptmenue.highscoreliste[2]);
							datop.writeInt(hauptmenue.highscoreliste[3]);
							datop.writeInt(hauptmenue.highscoreliste[4]);
							datop.writeInt(hauptmenue.highscoreliste[5]);

							datop.writeInt(input.hocode);
							datop.writeInt(input.rucode);
							datop.writeInt(input.licode);
							datop.writeInt(input.recode);

							datop.writeBoolean(hauptmenue.leicht);
							datop.writeBoolean(hauptmenue.mittel);
							datop.writeBoolean(hauptmenue.schwer);

							
							
					} catch (IOException e) {e.printStackTrace();
					}
				
			try {
				output.close();
			} catch (IOException e1) {}
			speichern=false;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
	}


}
	


