package iceadventure;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class IceAdventure extends StateBasedGame {

    public static final int STARTMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;
    public static final int MENUSTATE = 2;

    public static final int WIDTH = 1366;
    public static final int HEIGHT = 768;
    public static final boolean FULLSCREEN = false;
    
    public IceAdventure() {
        super("Ice Adventure");
        addState(new StartMenuState(STARTMENUSTATE));
        addState(new GamePlayState(GAMEPLAYSTATE));
        addState(new MenuState(MENUSTATE));
        this.enterState(STARTMENUSTATE);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        getState(STARTMENUSTATE).init(gc, this);
        getState(GAMEPLAYSTATE).init(gc, this);
        getState(MENUSTATE).init(gc, this);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new IceAdventure());
        app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
        app.start();
    }
}