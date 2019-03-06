/* Ming Zhaung presented
 * A class represents an equity that is the share of a mutual fund*/
public class MutualFund extends Equity{
   
   /* A field stores the load of the mutual fund, which a percentage charged on all sales of the fund*/
   private double load = 0.0;
   
   /* A constructor initalizes the name, symbol and the current price of the mutual fund*/
   public MutualFund (String name, char symbol, double currentPrice) {
      super(name, symbol, currentPrice);
   }
   
   /* A method to return the load of the mutual fund*/
   public double getLoad(){
      return this.load;
   }
   
   /* A method to change the load of the mutual fund*/
   public void setLoad(double load){
      this.load = load;
   }
   
   /* A method that buys mutual fund by money amount*/
   public double buy(double moneyInvented){
      if (moneyInvented > 0){
         setNumberShares(getNumberShares() + (moneyInvented * (1 - load) / getCurrentPrice()));
         setCostBasis(getCostBasis() + moneyInvented);
         return moneyInvented;
      }
      else
         return 0;
   }
   
   /* A method that sells mutual fund by money amount*/
   public double sell(double moneyWithdrawn) {
      if (moneyWithdrawn <= 0 || moneyWithdrawn > (getCurrentPrice() * getNumberShares()))
         return 0;
      else{
         double oldNumberShares = getNumberShares();   // stores the original number of shares
         double oldCostBasis = getCostBasis();                    // stores the original cost basis
         setNumberShares(getNumberShares() - (moneyWithdrawn / getCurrentPrice()));
         setCostBasis((getNumberShares() / oldNumberShares) * getCostBasis());
         setCapitalGains(getCapitalGains() + (moneyWithdrawn - (oldCostBasis - getCostBasis())));
         return moneyWithdrawn;
      }
   }
}