import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Plane {
	private float x;
	private float y;
	public static final float VELOCITY = 0.6f;
	public static final float ANGULARVELOCITY = 0.6f;

	private Image image;

	public Plane(float x, float y, String path) throws SlickException {
		this.x = x;
		this.y = y;
		this.image = new Image(path);
	}

	public void update(int dir, int rotation, int delta) throws SlickException {
		if (!rotation) {
			y += delta * VELOCITY * dir;
		}
		else{
			
		}

	}

	public void render() {
		image.setRotation(angle);
		image.drawCentered(x, y);

	}

}
