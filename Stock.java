/* MIng Zhuang presented
 * A class represents an equity that is the share of a stock*/
public class Stock extends Equity{
   
   /* A constructor which initalizes the name, symbol and the current price of the stock*/
   public Stock(String name, char symbol, double currentPrice){
      super(name, symbol, currentPrice);
   }
   
   /* A method that buy a certain amount of stocks*/
   public double buy(int numberShares, double commission){
      setNumberShares(getNumberShares() + numberShares);
      double increasedCostBasis = numberShares * getCurrentPrice() + commission;   //stores the increased cost basis
      setCostBasis(getCostBasis() + increasedCostBasis);
      return increasedCostBasis;
   }
   
   /* A method that sell a certain amount of stocks*/
   public double sell(int numberShares, double commission){
      if (numberShares > getNumberShares())
         return 0;
      else{
         double oldNumberShares = getNumberShares();   // stores the original number of shares
         double oldCostBasis = getCostBasis();                    // stores the original cost of basis
         setNumberShares(getNumberShares() - numberShares);
         setCostBasis((getNumberShares() / oldNumberShares) * getCostBasis());
         setCapitalGains(getCapitalGains() + ((numberShares * getCurrentPrice() - commission) - (oldCostBasis - getCostBasis())));
         return (numberShares * getCurrentPrice() - commission);
      }
   }
   
   /* A method that split the stocks*/
   public double split (int numerator, int denominator) {
      double doubleNumerator = (double) numerator;
      double doubleDenominator = (double) denominator;
      if (doubleNumerator == 0.0 ||  doubleDenominator == 0.0)
         return 0.0;
      else if (((getNumberShares() * (doubleNumerator /  doubleDenominator)) % 1) == 0) {
         setNumberShares(getNumberShares() * (doubleNumerator /  doubleDenominator));
         return 0;
      }
      else{
         double fractionalShares = (getNumberShares() * (doubleNumerator /  doubleDenominator)) % 1;   // store the fractional part of the shares
         double oldNumberShares = getNumberShares();                                                                                    // store the old number of shares
         double oldCostBasis = getCostBasis ();                                                                                                     // store the old cost basis
         setNumberShares(getNumberShares() * (doubleNumerator /  doubleDenominator) - fractionalShares);
         setCostBasis(getCostBasis() *  ( getNumberShares()  / (oldNumberShares * (doubleNumerator /  doubleDenominator)) ));
         setCapitalGains( getCapitalGains() + ( fractionalShares * getCurrentPrice() - (oldCostBasis - getCostBasis())));
         return fractionalShares * getCurrentPrice() ;
      }
   }
}