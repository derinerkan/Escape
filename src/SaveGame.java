import java.io.*;

/**
 * @author Derin Erkan
 * @version 2017-05-07
 */
public class SaveGame
{
    private Player player;
    private Leaderboard leaderboard;
    final String pFilename = "player.txt";
    final String lFilename = "leaderboard.txt";

    /**
     * Default constructor for the SaveGame. Tries to recall game data from memory,
     * but if the game data is not in memory the relevant objects' default constructors
     * are called.
     */
    public SaveGame() {
        try {
            FileInputStream pInput = new FileInputStream(pFilename);
            FileInputStream lInput = new FileInputStream(lFilename);

            ObjectInputStream pInStr = new ObjectInputStream(pInput);
            ObjectInputStream lInStr = new ObjectInputStream(lInput);

            player = (Player) pInStr.readObject();
            leaderboard = (Leaderboard) lInStr.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            player = new Player();
            leaderboard = new Leaderboard();
        }
    }

    /**
     * Saves the game if it can. If it cant you are fucked
     */
    public void saveGame()
    {
        try
        {
            ObjectOutputStream pOutput = new ObjectOutputStream(new FileOutputStream(pFilename));
            ObjectOutputStream sOutput = new ObjectOutputStream(new FileOutputStream(sFilename));

            pOutput.writeObject(player);
            sOutput.writeObject(store);

            pOutput.close();
            sOutput.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}


}
