import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class input implements KeyListener{
	
	//richtungen
	static boolean up		= false;
	static boolean down		= false;
	static boolean left		= false;
	static boolean right	= false;
	
	static int hocode;
	static int rucode;
	static int licode;
	static int recode;
	
	static int code;
	static String beschriftung;

	
	//KeyListener fuer fenster hinzufuegen+fokus setzen
	public input(){
		game.fenster.setFocusable(true);
		game.fenster.addKeyListener(this);
	}
	
	//richtung setzten wenn enstprechende taste gedrueckt wird
	public void keyPressed(KeyEvent k) {
	
		beschriftung=""+k.getKeyChar();
		beschriftung=beschriftung.toUpperCase();
		
		if(hauptmenue.hochb2.isSelected()){
			switch (k.getKeyCode()){
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
				hauptmenue.hochb2.setText(beschriftung);
				break;
			}
			hocode=k.getKeyCode();
			hauptmenue.hochb2.setSelected(false);
		}
		
		if(hauptmenue.runterb2.isSelected()){
			switch (k.getKeyCode()){
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
				hauptmenue.runterb2.setText(beschriftung);
				break;
			}
			rucode=k.getKeyCode();
			hauptmenue.runterb2.setSelected(false);			
		}
		
		if(hauptmenue.linksb2.isSelected()){
			switch (k.getKeyCode()){
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
				hauptmenue.linksb2.setText(beschriftung);
				break;
			}
			licode=k.getKeyCode();
			hauptmenue.linksb2.setSelected(false);			
		}
		
		if(hauptmenue.rechtsb2.isSelected()){
			switch (k.getKeyCode()){
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
				hauptmenue.rechtsb2.setText(beschriftung.toUpperCase());
				break;
			}
			recode=k.getKeyCode();
			hauptmenue.rechtsb2.setSelected(false);			
		}
		
		
	
		
		
		if(k.getKeyCode()==hocode){
			up=true;
		}
		if(k.getKeyCode()==rucode){
			down=true;
		}
		if(k.getKeyCode()==licode){
			left=true;
		}
		if(k.getKeyCode()==recode){
			right=true;
		}
		
	}

	//richtung setzen rueckgaengig mach wenn taste losgelassen wird
	public void keyReleased(KeyEvent k) {
		if(k.getKeyCode()==hocode){
			up=false;
		}
		if(k.getKeyCode()==rucode){
			down=false;
		}
		if(k.getKeyCode()==licode){
			left=false;
		}
		if(k.getKeyCode()==recode){
			right=false;
		}
	
	}


	public void keyTyped(KeyEvent k) {	

	}

}


