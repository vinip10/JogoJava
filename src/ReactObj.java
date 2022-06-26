import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class ReactObj extends Rectangle {
	
	public Color color;
	
	public int speed = 0;
	
	public int rotation = 0;
	
	public ReactObj(int x, int y, int width, int height) {
		super(x,y,width,height);
		
		color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
		
		speed = new Random().nextInt(6-4)+4;
	}
	//velocidade que o quadrado aparece na tela
	public void update() {
		x+=speed;
		rotation++;
		if(rotation >= 360)
			rotation = 0;
	}
	
}
