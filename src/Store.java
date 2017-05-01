public class Store
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
   */
  public void equipBall(int index)
  {
    if(balls.get(index).isOwned == true)
    {
      player.setBall(balls.get(index));
    }
  }
}
