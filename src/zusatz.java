import javax.swing.JToggleButton;


public class zusatz {
	static int expl_x=0;
	static int expl_y=0;
	
	public static int[] spawnset(int speed){
		int hoehe=600;
		int breite=800;
		
		int h;
		int b;
		int hspeed=0;
		int bspeed=0;
		int seite=(int)(Math.random()*4)+1;
		int[] zuruck = new int[4];
		switch (seite){
			case 1:{
				b=-20;
				h=(int)(Math.random()*hoehe);
				
				while(bspeed==0 & hspeed == 0){
					bspeed=(int)(Math.random()*speed);
					hspeed=(int)(Math.random()*(speed*2))-speed;
					bspeed/=2;
					hspeed/=2;
				}
				
				zuruck[0]=b;
				zuruck[1]=h;
				zuruck[2]=bspeed;
				zuruck[3]=hspeed;
				
				return zuruck;
				
			}
			case 2:{
				b=(int)(Math.random()*breite);
				h=-20;
				while(bspeed==0 & hspeed == 0){
					bspeed=(int)(Math.random()*(speed*2))-speed;
					hspeed=(int)(Math.random()*speed);
					bspeed/=2;
					hspeed/=2;
				}

				zuruck[0]=b;
				zuruck[1]=h;
				zuruck[2]=bspeed;
				zuruck[3]=hspeed;
				
				return zuruck;
			}
			case 3:{
				b=(int)(Math.random()*breite);
				h=hoehe;
				while(bspeed==0 & hspeed == 0){
					bspeed=(int)(Math.random()*(speed*2))-speed;
					hspeed=(int)(Math.random()*-speed);
					bspeed/=2;
					hspeed/=2;
				}
					
				zuruck[0]=b;
				zuruck[1]=h;
				zuruck[2]=bspeed;
				zuruck[3]=hspeed;
				
				return zuruck;
			}
			case 4:{
				b=breite;
				h=(int)(Math.random()*hoehe);
				while(bspeed==0 & hspeed == 0){
					bspeed=(int)(Math.random()*-speed);
					hspeed=(int)(Math.random()*(speed*2))-speed;
					bspeed/=2;
					hspeed/=2;
				}
				
				zuruck[0]=b;
				zuruck[1]=h;
				zuruck[2]=bspeed;
				zuruck[3]=hspeed;
				
				return zuruck;
			}
			
		}
		
		
		
		return zuruck;
	}

	public static void ufobewegung(){
			spielschleife.ufo_x+=spielschleife.ufo_xspeed;
			spielschleife.ufo_y+=spielschleife.ufo_yspeed;
			if(input.up==true){
				spielschleife.ufo=spielschleife.ufooben;
				Spielfeld.spielerbild=spielschleife.ufo;
				spielschleife.ufo_y=spielschleife.ufo_y-spielschleife.ufo_speed;
				if(spielschleife.ufo_y<0)
					spielschleife.ufo_y=0;
			}
			if(input.down==true){
				spielschleife.ufo=spielschleife.ufounten;
				Spielfeld.spielerbild=spielschleife.ufo;
				spielschleife.ufo_y=spielschleife.ufo_y+spielschleife.ufo_speed;
				if(spielschleife.ufo_y>spiel.gamecont.getHeight()-50)
					spielschleife.ufo_y=spiel.gamecont.getHeight()-50;
			}
			if(input.left==true){
				spielschleife.ufo=spielschleife.ufolinks;
				Spielfeld.spielerbild=spielschleife.ufo;
				spielschleife.ufo_x=spielschleife.ufo_x-spielschleife.ufo_speed;
				if(spielschleife.ufo_x<0)
					spielschleife.ufo_x=0;
			}
			if(input.right==true){
				spielschleife.ufo=spielschleife.uforechts;
				Spielfeld.spielerbild=spielschleife.ufo;
				spielschleife.ufo_x=spielschleife.ufo_x+spielschleife.ufo_speed;
				if(spielschleife.ufo_x>spiel.gamecont.getWidth()-50)
					spielschleife.ufo_x=spiel.gamecont.getWidth()-50;
			}
	
}

	public static void meteoritenbewegung(){
		for(int i=0;i<spielschleife.meteor.length;i++){
			spielschleife.meteor[i][0]+=spielschleife.meteor[i][2];
			spielschleife.meteor[i][1]+=spielschleife.meteor[i][3];
			if(   spielschleife.meteor[i][0]<-20 
				| spielschleife.meteor[i][0]>800
				| spielschleife.meteor[i][1]<-20 
				| spielschleife.meteor[i][1]>600){
				spielschleife.meteor[i]=zusatz.spawnset(spielschleife.metspeed);
			}
			}
		}

	public static boolean kollisionscheck(){
		boolean h1=false;
		boolean h2=false;
		boolean h3=false;
		h1=kollizusatz(32,32);
		h2=kollizusatz(16,50);
		h3=kollizusatz(50,16);
		
		if((h1==true & h2==true) | (h1==true & h3==true)){
			return true;
		}else{
			return false;
	
		}
	}
		
	public static boolean kollizusatz(int b,int h){
		int xa = (int) ((50-b)*0.5);
		int ya = (int) ((50-h)*0.5);
		
		
		for(int i=0;i<spielschleife.meteor.length;i++){
		if(  //oben links
			  spielschleife.meteor[i][0] 	>= spielschleife.ufo_x+ xa
			& spielschleife.meteor[i][0] 	<= spielschleife.ufo_x+(50-xa)
			& spielschleife.meteor[i][1] 	>= spielschleife.ufo_y+ ya
			& spielschleife.meteor[i][1]	<= spielschleife.ufo_y+(50-ya)
			| spielschleife.meteor[i][0]+20 >= spielschleife.ufo_x+ xa
			& spielschleife.meteor[i][0]+20 <= spielschleife.ufo_x+(50-xa)
			& spielschleife.meteor[i][1] 	>= spielschleife.ufo_y+ ya
			& spielschleife.meteor[i][1] 	<= spielschleife.ufo_y+(50-ya)
			| spielschleife.meteor[i][0]+20 >= spielschleife.ufo_x+ xa
			& spielschleife.meteor[i][0]+20 <= spielschleife.ufo_x+(50-xa)
			& spielschleife.meteor[i][1] 	>= spielschleife.ufo_y+ ya
			& spielschleife.meteor[i][1] 	<= spielschleife.ufo_y+(50-ya)
			| spielschleife.meteor[i][0]+20 >= spielschleife.ufo_x+ xa
			& spielschleife.meteor[i][0]+20 <= spielschleife.ufo_x+(50-xa)
			& spielschleife.meteor[i][1]+20 >= spielschleife.ufo_y+ ya
			& spielschleife.meteor[i][1]+20 <= spielschleife.ufo_y+(50-ya)){
				expl_x=spielschleife.meteor[i][0];
				expl_y=spielschleife.meteor[i][1];
				return true;
		
					
				}
	}
		return false;
	}

	public static void tastenerkennung(int code,JToggleButton button){
		switch (code){
		case 37:
			button.setText("Pfeil_Links ");
			break;
		case 38:
			button.setText("Pfeil_Hoch  ");
			break;
		case 39:
			button.setText("Pfeil_Rechts");
			break;
		case 40:
			button.setText("Pfeil_Runter");
			break;
		default:	
			break;
		}
	}
}


