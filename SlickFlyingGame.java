import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SlickFlyingGame extends BasicGame {
	int count = 0;
	Image background;
	Image balloon;
	
	Plane plane;
	
	float balloonx;
	float balloony;
	
	static final int UP = 1;
	static final int DOWN = -1;
	static final int NOSHIFT  = 0;
	static final int NOROTATION = 0;
	static final int RIGHT = 1;
	static final int LEFT = -1;


	public SlickFlyingGame() {
		super("SlickFlyingGame");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		//System.out.println(container.getWidth());
		//System.out.println(container.getHeight());
		background = new Image("assets/land.jpeg");// load background image
		
		plane = new Plane(container.getWidth()/2,container.getHeight()/2,"assets/plane.jpeg");
		balloon = new Image("assets/balloon.png");

		Random rand = new Random();
		balloonx = rand.nextFloat() * container.getWidth();
		balloony = rand.nextFloat() * container.getHeight();
	}

	@Override
	public void update(GameContainer gc, int delta) // delta: how many ms has
													// passed since last frame
			throws SlickException {

		Input input = gc.getInput();
		
		//double distance = 

		if (input.isKeyDown(Input.KEY_UP)) {
			plane.update(UP,NOROTATION,delta);
			//y -= delta * VELOCITY;
		}

		if (input.isKeyDown(Input.KEY_DOWN)) {
			plane.update(DOWN,NOROTATION,delta);
			//y += delta * VELOCITY;
		}

		if (input.isKeyDown(Input.KEY_LEFT)) {
			//x -= delta * VELOCITY;
		}

		if (input.isKeyDown(Input.KEY_RIGHT)) {
			//x += delta * VELOCITY;
		}

		//set plane location
		x = x > gc.getWidth() ? gc.getWidth() : x;
		x = x < 0 ? 0 : x;
		y = y > gc.getHeight() ? gc.getHeight() : y;
		y = y < 0 ? 0 : y;

		
		// exit when Esc is pressed
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.draw(0, 0);
		plane.render();
		balloon.drawCentered(balloonx, balloony);

		// g.drawString("Count = " + count, 100, 100);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AppGameContainer app = new AppGameContainer(new SlickFlyingGame());
			app.setDisplayMode(800, 600, false);
			app.start();

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
