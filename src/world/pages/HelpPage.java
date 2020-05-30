package world.pages;

import world.World;

import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import utils.MyButton;

import static raidenObjects.BaseRaidenObject.loadImage;
import static utils.PageStatus.*;

/**
 * @author 鏉ㄨ姵婧�
 *
 */
public class HelpPage implements Page {
	MyButton buttonBack;
	
	public void run(World world) {
		ActionListener listener = (e) -> {
        	World.pageStatus = MAIN;
        };
        buttonBack = new MyButton(300, 550, 120, 80, Paths.get("data", "images", "previous.png"), listener);
        world.add(buttonBack);
	}
	
	public void paint(Graphics g) {
		g.drawImage(loadImage(Paths.get("data", "images", "Background.png").toFile()),
					0,0,null);
		g.drawImage(loadImage(Paths.get("data", "images", "previous.png").toFile()),
                	300, 550, 120, 80, null);
	}

	public void clean(World world) {
		if (buttonBack != null)
        	world.remove(buttonBack);
		world.revalidate();
		world.repaint();
	}
	
}
