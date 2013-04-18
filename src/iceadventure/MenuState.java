package iceadventure;

import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {

    private static final int NUMBEROFCHOICES = 4;
    private static final int START = 0;
    private static final int SAVE = 1;
    private static final int LOAD = 2;
    private static final int QUIT = 3;
    private String[] playersOptions = new String[NUMBEROFCHOICES];
    private Font font;
    private TrueTypeFont playersOptionsTTF;
    private int playersChoice, stateid;
    private Color notChosen = new Color(153, 204, 255);

    public MenuState(int id) {
        stateid = id;
    }

    @Override
    public int getID() {
        return stateid;
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        font = new Font("Verdana", Font.BOLD, 40);
        playersOptionsTTF = new TrueTypeFont(font, true);
        playersOptions[0] = "Start";
        playersOptions[1] = "Save";
        playersOptions[2] = "Load";
        playersOptions[3] = "Quit";
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_DOWN)) {
            if (playersChoice == (NUMBEROFCHOICES - 1)) {
                playersChoice = 0;
            } else {
                playersChoice++;
            }
        }
        if (input.isKeyPressed(Input.KEY_UP)) {
            if (playersChoice == 0) {
                playersChoice = NUMBEROFCHOICES - 1;
            } else {
                playersChoice--;
            }
        }
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            switch (playersChoice) {
                case START:
                    sbg.enterState(IceAdventure.GAMEPLAYSTATE);
                    break;
                case QUIT:
                    gc.exit();
                    break;
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        renderPlayersOptions();
    }

    private void renderPlayersOptions() {
        for (int i = 0; i < NUMBEROFCHOICES; i++) {
            if (playersChoice == i) {
                playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i]);
            } else {
                playersOptionsTTF.drawString(100, i * 50 + 200, playersOptions[i], notChosen);
            }
        }
    }
}