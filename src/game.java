
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;



//hauptklasse

public class game{
	
	//Fenster+feanstericon
		static 	JFrame fenster=new JFrame();
		Image icon;
	
	
		
	//Hauptmethode/spielstarten
	public static void main(String[] args){
			new game();
	}
	
	
	//fensteroptionen festlegen
	public game(){	
		try {
			icon = ImageIO.read(getClass().getResource("meteor.png"));
		} catch (IOException e) {}
		
		fenster.setSize(800,600);
		fenster.setTitle("UFO");
		fenster.setLocationRelativeTo(null);
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setResizable(false);
		fenster.setVisible(true);
		fenster.setBackground(new Color(5,0,10));
		fenster.setIconImage(icon);
		
		//  Highscore/Optionen einlesen
		new einlesen();
		
		//  starten der eingabe (siehe input)
		new input();
		
		//  oeffnen des hauptmenues
		new hauptmenue();
			zusatz.tastenerkennung(input.hocode, hauptmenue.hochb2);
			zusatz.tastenerkennung(input.rucode, hauptmenue.runterb2);
			zusatz.tastenerkennung(input.licode, hauptmenue.linksb2);
			zusatz.tastenerkennung(input.recode, hauptmenue.rechtsb2);
		
		
		//  starten der spielschleife (siehe spielschleife)
		new spielschleife();
	}
	
	
	

}




