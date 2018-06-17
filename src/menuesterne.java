import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;





public class menuesterne {
	JLabel[] stern1 =new JLabel[10];
	JLabel[] stern2 =new JLabel[50];
	JLabel[] stern3 =new JLabel[100];
	
	
	public menuesterne(JPanel container,boolean b){
		
		//grosse Sterne
		for(int i=0;i<stern1.length;i++)
			sterne(container, stern1[i],30,b);
		
		//mittlere Sterne
		for(int i=0;i<stern2.length;i++)
			sterne(container, stern2[i],20,b);
		
		//kleine Sterne
		for(int i=0;i<stern3.length;i++)
			sterne(container, stern3[i],10,b);
		

		
	
		
	}
	public static void sterne(JPanel container, JLabel stern,int z,boolean b){
		stern=new JLabel();
		int x=(int)(Math.random()*800);
		int y=(int)(Math.random()*600)-50;
		stern.setText(".");
		container.add(stern);
		stern.setOpaque(false);
		stern.setBounds(x,y,50,50);
		stern.setForeground(Color.WHITE);
		stern.setFont(new Font ("Monospaced",Font.BOLD,z));
		stern.setVisible(b);
	}
	
}
