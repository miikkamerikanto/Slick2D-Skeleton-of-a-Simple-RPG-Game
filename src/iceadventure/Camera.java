package iceadventure;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

public class Camera {

    private int x, y;
    private int mapWidth, mapHeight;
    private Rectangle viewPort;

    public Camera(TiledMap map, int mapWidth, int mapHeight) {
        x = 0;
        y = 0;
        viewPort = new Rectangle(0, 0, IceAdventure.WIDTH, IceAdventure.HEIGHT);
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void translate(Graphics g, Hero hero) {

        if (hero.getX() - IceAdventure.WIDTH / 2 + 16 < 0) {
            x = 0;
        } else if (hero.getX() + IceAdventure.WIDTH / 2 + 16 > mapWidth) {
            x = -mapWidth + IceAdventure.WIDTH;
        } else {
            x = (int) -hero.getX() + IceAdventure.WIDTH / 2 - 16;
        }

        if (hero.getY() - IceAdventure.HEIGHT / 2 + 16 < 0) {
            y = 0;
        } else if (hero.getY() + IceAdventure.HEIGHT / 2 + 16 > mapHeight) {
            y = -mapHeight + IceAdventure.HEIGHT;
        } else {
            y = (int) -hero.getY() + IceAdventure.HEIGHT / 2 - 16;
        }
        g.translate(x, y);
        viewPort.setX(-x);
        viewPort.setY(-y);
    }
}