import java.util.ArrayList;
import java.io.Serializable;

/**
 * Player class for Escape game
 * @author Escape
 * @version 1.0
 */
public class Player implements Serializable
{
    private double score;
    private double highScore;
    protected VirtualMoney money;
    private String name;
    //private int ballIndex;
    private ArrayList<Ball> balls;
    private boolean isPlaying;

    private Ball currentBall;

    /**
     * Default constructor: initializes an empty Player that should be set with other methods.
     * Should only really be called once, as existing players are going to be serialized and reconstructed etc.
     */
    public Player()
    {
        score = 0;
        highScore = 0;
        money = new VirtualMoney();
        name = "";
        currentBall = new Ball();
        //ballIndex = 0;
        balls = new ArrayList<Ball>();
        isPlaying = true;
    }

    /**
     * Copy constructor for this player
     * @param p the player to copy
     */
    public Player(Player p)
    {
        this.score = p.score;
        this.highScore = p.highScore;
        this.money = p.money;
        this.name = p.name;
        this.currentBall = p.currentBall;
        //this.ballIndex = p.ballIndex;
        this.balls = p.balls;
        this.isPlaying = p.isPlaying;
    }

    /**
     * Updates both the normal score and the high score
     * @param score the new score of this player
     */
    public void updateScore(double score)
    {
        this.score = score;
        if(score > highScore) highScore = score; //set the high score as well if we are beating our record
    }

    /**
     * Returns the score of this player
     * @return their score
     */
    public double getScore()
    {
        return score;
    }

    /**
     * Returns the high score of this player
     * @return their high score
     */
    public double getHighScore()
    {
        return highScore;
    }
    /**
     * Try to set the current Ball of this player
     * @param ball the new Ball to set
     */
    public void setBall(Ball ball)
    {
        if(ball.isOwned) currentBall = ball;
        if(!balls.contains(ball)) balls.add(ball);
    }

    /**
     * Get the ball that this player is using
     * @return the ball
     */
    public Ball currentBall() //beyler umlde burası yanlış olmuş ball return etmesi daha mantıklı
    {
        //return balls.get(ballIndex); //burda current ball da verebiliriz öyle yapacaksak
        return currentBall;
    }

    /**
     * Gives a string representation of this player's name and their high score.
     * Example: "Derin 25.04234"
     * @return a string representation of this player
     */
    @Override
    public String toString()
    {
        return name + " " + highScore;
    }

    /**
     * Get all the balls owned by this player
     * @return the balls that this player owns
     */
    public ArrayList<Ball> getBalls()
    {
        return balls;
    }

    /**
     * Takes a ball, makes it owned, and adds it to the player's collection
     * @param ball the ball to be added
     */
    public void addBall(Ball ball)
    {
        ball.isOwned = true;
        balls.add(ball);
    }

    /**
     * Sets the name of this player
     * @param name the new player
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Retrieves the name of this player.
     * @return the name of this player
     */
    public String getName()
    {
        return name;
    }

}
