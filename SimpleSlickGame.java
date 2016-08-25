import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
 
public class SimpleSlickGame extends BasicGame 
	{ 
        int count = 0;
        Image background;
	
		public SimpleSlickGame() {
				super("SimpleSlickGame"); 
	    } 
		
		@Override 
	    public void init(GameContainer container) 
	    	throws SlickException {
			
			 background = new Image("assets/land.jpeg");//load background image

		} 
	    
	    @Override public void update(GameContainer gc, int delta) //delta: how many ms has passe since last frame
	    throws SlickException {
	    	
            Input input = gc.getInput();
          
	        if(input.isKeyDown(Input.KEY_UP))
	        {
	        	count++;
	        }
	 
	        if(input.isKeyDown(Input.KEY_DOWN))
	        {
	        	count--;
	        }
	        
	        //change background when C key is pressed
	        if(input.isKeyDown(Input.KEY_C)){
	        	background = new Image("assets/Background2.jpg");
	        }
	        //exit when Esc is pressed
	        if(input.isKeyDown(Input.KEY_ESCAPE )){
	        	System.exit(0);
	        }
	    } 
	    
	    @Override public void render(GameContainer container, Graphics g) 
	    throws SlickException { 
	    	background.draw(0,0);
	    	g.drawString("Count = " + count, 100, 100); 
	    	
	    } 
	    
	    public static void main(String[] args) { 
	    	
	    	try { 
	    		AppGameContainer app = new AppGameContainer(new SimpleSlickGame()); 
	    		app.setDisplayMode(800, 600, false);
	            app.start();

	    		
	    	} catch (SlickException e) { 
	    		e.printStackTrace(); 
	    	} 
	    }
}

