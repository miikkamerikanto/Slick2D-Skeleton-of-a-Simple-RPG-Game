package iceadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.newdawn.slick.geom.Vector2f;

/**
 * New class just for the File IO stuff..
 *
 * @author mermi
 */
public class FileIO {

    private Vector2f coordinates = new Vector2f(0, 0);

    /**
     *  Empty Constructor.
     */
    public FileIO() {}

    /**
     * Loads the saved game from txt file (game.sav).
     * @return Hero's coordinates.
     */
    public Vector2f loadSave() {
        try {
            Scanner lukija = new Scanner(new File("saves/game.sav"));
            coordinates.x = Float.parseFloat(lukija.nextLine());
            coordinates.y = Float.parseFloat(lukija.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Error: saved game does not exist!");
        } catch (NumberFormatException e) {
            System.out.println("Error: could not read the file!");
        }
        return coordinates;
    }

    /**
     * Saves the game in a txt file (game.sav).
     * @param vector Hero's current coordinates.
     */
    public void save(Vector2f vector) {
        try {
            PrintWriter writer = new PrintWriter(new File("saves/game.sav"));
            writer.println(vector.x);
            writer.println(vector.y);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: could not save the file!");
        }
    }
}