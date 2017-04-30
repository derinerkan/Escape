/**
 * Virtual Money class for Escape project
 * @author Derin Erkan
 * @version 2017-04-30
 */
public class VirtualMoney
{
    private int amount;

    /**
     * Initializes a VirtualMoney with zero money
     */
    public VirtualMoney()
    {
        amount = 0;
    }

    /**
     * Add some money to this account
     * @param amount the amount to add as an integer
     */
    public void addMoney(int amount)
    {
        this.amount += amount;
    }

    /**
     * Spend money from this account
     * @param amount the amount to subtract
     * @return whether spending it was successful
     */
    public boolean spendMoney(int amount)
    {
        this.amount -= amount;
    }
}
