import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, MouseListener  {

	public static final int WIDTH = 640, HEIGHT = 480;
	
	public static int contador = 100;
	
	public static int pontuacao = 0;
	
	public static int mx, my;
	
	public static boolean clicado = false;
	
	public Spanner spanner;
	
	public Game() {
		Dimension dimension = new Dimension(WIDTH,HEIGHT);
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		
		spanner = new Spanner();
	}
	
	
	
	//serve para atualizar tudo que acontece no jogo
	public void update() {
		// está linha sserviu para testar se o contador perde vida>>> contador--;
		spanner.update();
		if(contador <=0) {
			contador = 100;
		}
	}
	//serve para renderizar o jogo em si 
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		/*
		 *g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString("Pontos: " + contador, WIDTH/2 - 60, 30);
		*/
		g.setColor(Color.green);
		g.fillRect(Game.WIDTH/2 - 100 - 70, 20, contador*3, 20);
		g.setColor(Color.white);
		g.drawRect(Game.WIDTH/2 - 100 - 70, 20, 300, 20);
		
		spanner.render(g);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		 Game game = new Game();
		 JFrame jframe = new JFrame("Meu jogo");
		 jframe.add(game);
		 jframe.setLocationRelativeTo(null);
		 jframe.pack();
		 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 jframe.setVisible(true);
		 
		 new Thread(game).start();
	}
	 
	@Override
	public void run() {
	while(true)	{
		update();
		render();
		try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {

			e.printStackTrace();
		} 
	}
	
	
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		clicado = true;
		mx = e.getX();
		my = e.getY();
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
