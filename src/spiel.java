import java.awt.Color;
import java.util.Date;



public class spiel {
	static Spielfeld gamecont;
	static boolean spiellaeuft;
	static boolean start = false;
	static Date startzeit =null;
	
	public spiel() {
		
		if( hauptmenue.leicht==true){
			spielschleife.metanzahl=8;
			spielschleife.metspeed=6;
		}else{	
		if( hauptmenue.mittel==true){
			spielschleife.metanzahl=10;
			spielschleife.metspeed=8;
		}else{	
		if( hauptmenue.schwer==true){
			spielschleife.metanzahl=12;
			spielschleife.metspeed=10;
		}else{
			spielschleife.metanzahl=10;
			spielschleife.metspeed=8;
		}
		}
		}
		
		//UFO-startposition
		spielschleife.ufo_x = 375;
		spielschleife.ufo_y = 275;
		
		gamecont = new Spielfeld();
		gamecont.setLayout(null);
		game.fenster.add(gamecont);
		gamecont.setBackground(new Color(5,0,10));
		
		
		
		
		
		spielschleife.meteor = new int[spielschleife.metanzahl][4];
		for(int i=0;i<spielschleife.meteor.length;i++){
			spielschleife.meteor[i]=zusatz.spawnset(spielschleife.metspeed);
			//System.out.println(meteor[i][0]+"|"+meteor[i][1]+"|"+meteor[i][2]+"|"+meteor[i][3]);
		}

		
		spiellaeuft = true;
		start  = true;
		startzeit   = new Date();
		
		
		

		
		new menuesterne(gamecont,false);
		
		
		
		
	}
	
	
}
