/* Ming Zhuang presented
 * A class represents an asset where you can own shares of the asset*/
public class Equity extends Asset{
   
   /* A field represents the symbol of the equity*/
   //Ming
   private final char symbol;
   
   /* A field represents the your share of the equity*/
   private double numberShares = 0.0;
   
   /* A constructor that sets the name, symbol and the current price of the equity*/
   public Equity(String name, char symbol, double currentPrice) {
      super(name, 0.0);
      this.symbol = symbol;
      setCurrentPrice(currentPrice);
   }
   
   /* A method to return the symbol in the form of char*/
   public char getSymbol() {
      return this.symbol;
   }
   
   /* A method to return your share of the equity*/
   public double getNumberShares() {
      return this.numberShares;
   }
   
   /* A method to change your share of the equity*/
   protected void setNumberShares(double numberShares){
      this.numberShares = numberShares;
   }
}