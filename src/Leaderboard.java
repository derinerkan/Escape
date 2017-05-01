import java.util.ArrayList;

/**
 * Leaderboard class for Escape game
 * @author Escape
 * @version 1.0
 */
public class Leaderboard
{
    ArrayList<Player> list;

    public Leaderboard()
    {
        list = new ArrayList<Player>();
    }
    /**
     * It adds the player to the leaderboard list with the correct place the user belongs.
     * @param toAdd the player to add
     */
    public void addPlayer(Player toAdd)
    {
        for( int i = 0; i < list.size(); i++)
        {
            //Checking whether it's bigger or not.
            if(toAdd.getScore() > list.get(i).getScore())
            {
                list.remove(list.size()-1);
                list.add(i,toAdd);
                return;
            }
            // Checking the alphabetical order if both players get the same score.
            if( toAdd.getScore() == list.get(i).getScore() )
            {
                if( (toAdd.getName().compareTo( list.get(i).getName() ) ) < 0)
                {
                    list.add(i,toAdd);
                    list.remove(list.size()-1);
                    return;
                }
                else
                {
                    list.add(i+1,toAdd);
                    list.remove( list.size()-1 );
                    return ;
                }
            }
        }
    }public class Store
{
  private final ArrayList<Ball> balls;
  private Player player;

  public Store()
  {
    balls = new ArrayList<Ball>();
    player = new Player();
  }

  /**
   * It lets the user buy the ball if conditions are satisfied.
   * @param index the index to buy the ball from
   */
  public boolean buyBall(int index)
  {
    if(balls.get(index).isOwned == false && player.money.getMoney() > balls.get(index).getPrice())
    {
      balls.get(index).isOwned = true;
      player.money.spendMoney(balls.get(index).getPrice());
      player.setBall(balls.get(index));
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * It lets the user equip the ball if the conditions are satisfied.
   * @param index the index to buy the ball from
   */
  public void equipBall(int index)
  {
    if(balls.get(index).isOwned == true)
    {
      player.setBall(balls.get(index));
    }
  }
}

    /**
     * Checks if it can add the player to leaderboard.
     * @param toAdd the player to add
     * @return true if the player can be added
     */
    public boolean canAdd(Player toAdd)
    {
        return toAdd.getScore() > list.get(list.size() - 1).getScore();
    }

    /**
     * Returns an ArrayList<String of players on the leaderboard
     * @return the players on the list
     */
    public ArrayList<String> printMethod()
    {
        ArrayList<String> output = new ArrayList<String>();
        for(Player i: list)
        {
            output.add(i.getName() + i.getScore());
        }
        return output;
    }

}