import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class einlesen {
	
	public einlesen(){
		try {
			FileInputStream iostream = new FileInputStream("optionen.txt");
			DataInputStream diostrem = new DataInputStream(iostream);
			
			try {
				hauptmenue.highscoreliste[1]=diostrem.readInt();
				hauptmenue.highscoreliste[2]=diostrem.readInt();
				hauptmenue.highscoreliste[3]=diostrem.readInt();
				hauptmenue.highscoreliste[4]=diostrem.readInt();
				hauptmenue.highscoreliste[5]=diostrem.readInt();
				
				input.hocode=diostrem.readInt();
					switch (input.hocode){
						case 37:
							hauptmenue.hochb2.setText("Pfeil_Links");
							break;
						case 38:
							hauptmenue.hochb2.setText("Pfeil_Hoch");
							break;
						case 39:
							hauptmenue.hochb2.setText("Pfeil_Rechts");
							break;
						case 40:
							hauptmenue.hochb2.setText("Pfeil_Runter");
							break;
						default:	
							hauptmenue.hochb2.setText((KeyEvent.getKeyText(input.hocode)).toUpperCase());
							break;
					}
				input.rucode=diostrem.readInt();
					switch (input.rucode){
						case 37:
							hauptmenue.runterb2.setText("Pfeil_Links");
							break;
						case 38:
							hauptmenue.runterb2.setText("Pfeil_Hoch");
							break;
						case 39:
							hauptmenue.runterb2.setText("Pfeil_Rechts");
							break;
						case 40:
							hauptmenue.runterb2.setText("Pfeil_Runter");
							break;
						default:	
							hauptmenue.runterb2.setText((KeyEvent.getKeyText(input.rucode)).toUpperCase());
							break;
					}
				input.licode=diostrem.readInt();
					switch (input.licode){
						case 37:
							hauptmenue.linksb2.setText("Pfeil_Links");
							break;
						case 38:
							hauptmenue.linksb2.setText("Pfeil_Hoch");
							break;
						case 39:
							hauptmenue.linksb2.setText("Pfeil_Rechts");
							break;
						case 40:
							hauptmenue.linksb2.setText("Pfeil_Runter");
							break;
						default:	
							hauptmenue.linksb2.setText((KeyEvent.getKeyText(input.licode)).toUpperCase());
							break;
					}
				input.recode=diostrem.readInt();
					switch (input.recode){
						case 37:
							hauptmenue.rechtsb2.setText("Pfeil_Links");
							break;
						case 38:
							hauptmenue.rechtsb2.setText("Pfeil_Hoch");
							break;
						case 39:
							hauptmenue.rechtsb2.setText("Pfeil_Rechts");
							break;
						case 40:
							hauptmenue.rechtsb2.setText("Pfeil_Runter");
							break;
						default:	
							hauptmenue.rechtsb2.setText((KeyEvent.getKeyText(input.recode)).toUpperCase());
							break;
					}
					
				
				hauptmenue.leicht=diostrem.readBoolean();
				hauptmenue.mittel=diostrem.readBoolean();
				hauptmenue.schwer=diostrem.readBoolean();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			hauptmenue.highscoreliste[1]=0;
			hauptmenue.highscoreliste[2]=0;
			hauptmenue.highscoreliste[3]=0;
			hauptmenue.highscoreliste[4]=0;
			hauptmenue.highscoreliste[5]=0;
			
			input.hocode=KeyEvent.VK_UP;
			input.rucode=KeyEvent.VK_DOWN;
			input.licode=KeyEvent.VK_LEFT;
			input.recode=KeyEvent.VK_RIGHT;
			
			
			hauptmenue.leicht=false;
			hauptmenue.mittel=true;
			hauptmenue.schwer=false;
			
			spielschleife.speichern=true;
		}
		
	}
}
