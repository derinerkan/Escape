import java.util.ArrayList;

public class Leaderboard
{
    ArrayList<Player> list;

    public Leaderboard()
    {
        list = new ArrayList<Player>();
    }
    /**
     * It adds the player to the leaderboard list with the correct place the user belongs.
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
    }
    /**
     * Checks if it can add the player to leaderboard.
     */
    public boolean canAdd(Player toAdd)
    {
        return toAdd.getScore() > list.get(list.size() - 1).getScore();
    }
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