import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Spielfeld extends JPanel{

	private static final long serialVersionUID = 1L;
	
	static BufferedImage spielerbild;
	int[][] sterne1 = new int[10][2];
	int[][] sterne2 = new int[50][2];
	int[][] sterne3 = new int[100][2];
	Image stern_kl;
	Image stern_mdl;
	Image stern_gr;
	Image explosion;

	public Spielfeld(){
		try {		spielerbild = ImageIO.read(getClass().getResource("ufooben.png"));
		} catch (IOException e) {}
		
		try {		stern_kl = ImageIO.read(getClass().getResource("stern_kl.png"));
		} catch (IOException e) {}
		try {		stern_mdl= ImageIO.read(getClass().getResource("stern_mdl.png"));
		} catch (IOException e) {}
		try {		stern_gr = ImageIO.read(getClass().getResource("stern_gr.png"));
		} catch (IOException e) {}
		try {		explosion= ImageIO.read(getClass().getResource("explosion.png"));
		} catch (IOException e) {}
		
		
		for(int i=0;i<sterne1.length;i++){
			sterne1[i][0] = (int)(Math.random()*800);
			sterne1[i][1] = (int)(Math.random()*600)-50;
		}
		for(int i=0;i<sterne2.length;i++){
			sterne2[i][0] = (int)(Math.random()*800);
			sterne2[i][1] = (int)(Math.random()*600)-50;
		}
		for(int i=0;i<sterne3.length;i++){
			sterne3[i][0] = (int)(Math.random()*800);
			sterne3[i][1] = (int)(Math.random()*600)-50;
		}
		
		
	}
	@Override 
	 protected void paintComponent( Graphics g ) { 
	    super.paintComponent( g ); 
	    
	    for(int i=0;i<sterne1.length;i++){
			g.drawImage(stern_gr,sterne1[i][0],sterne1[i][1],this);
		}
	    for(int i=0;i<sterne2.length;i++){
	    	g.drawImage(stern_mdl,sterne2[i][0],sterne2[i][1],this);
		}
	    for(int i=0;i<sterne3.length;i++){
	    	g.drawImage(stern_kl,sterne3[i][0],sterne3[i][1],this);
		}
	    
	    
	    if(spielschleife.startcountdown>0){
	    	g.setColor(Color.YELLOW);
		    g.setFont( new Font( "Verdana", Font.BOLD, 200 ) );
		    g.drawString(""+spielschleife.startcountdown,325,360);
	    }
	    g.drawImage(spielerbild,spielschleife.ufo_x,spielschleife.ufo_y,this);
	    for(int i=0;i<spielschleife.meteor.length;i++){
	    	g.drawImage(spielschleife.meteorimg,spielschleife.meteor[i][0],spielschleife.meteor[i][1],this);
	
	    }
	    if(zusatz.kollisionscheck()==true){
	    	g.drawImage(explosion,zusatz.expl_x,zusatz.expl_y,this);
	    	g.setColor(Color.YELLOW);
	  	    g.setFont( new Font( "Verdana", Font.BOLD, 80 ) );
	  	    g.drawString("GAME OVER", 125, 260);
	  	    g.setColor(Color.YELLOW);
	  	    g.setFont( new Font( "Verdana", Font.BOLD, 40 ) );
	  	    g.drawString("ZEIT: "+((spielschleife.zeit.getTime()-spiel.startzeit.getTime())/1000), 125, 360);
	    }
	    g.setColor(Color.YELLOW);
	    g.setFont( new Font( "Verdana", Font.BOLD, 20 ) );
	    g.drawString(""+((spielschleife.zeit.getTime()-spiel.startzeit.getTime())/1000),0,19);
	   
	}
}
