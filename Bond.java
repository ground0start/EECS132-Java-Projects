/* Ming Zhuang Presented
 * A class represents an asset which is a loan from a government or corporation*/
public class Bond extends Asset {
   
   /* A field stores the principle of the bond*/
   private final int principal;
   
   /* A field stores the interest rate of the bond*/
   private double interestRate = 0.0;
   
   /* A field stores the number of bonds owned*/
   private int numberOwned = 0;
   
   /* A constructor initalizes the name, principle, and interest rate of the bond*/
   public Bond (String name, int principal, double interestRate){
      super(name, 0.0);
      this.principal = principal;
      this.interestRate = interestRate;
      setCurrentPrice(principal);
   }
   
   /* A method to return the unchangeable principal*/
   public int getPrincipal() {
      return this.principal;
   }
   
   /* A method to return the interest rate*/
   public double getInterestRate() {
      return this.interestRate;
   }
   
   /* A method to change the interest rate*/
   public void setInterestRate(double interestRate){
      this.interestRate = interestRate;
   }
   
   /* A method to return the number of interest should be paid */
   public double payInterest(){
      return interestRate * principal;
   }
   
   /* A method to purchase a bond*/
   public double buy(){
      setCostBasis(getCostBasis() + getCurrentPrice());
      numberOwned = getNumberOwned() + 1;
      return getCurrentPrice();
   }
   
   /* A method to sell a bond*/
   public double sell(){
      if (getNumberOwned() == 0)
         return 0;
      else
      {  double oldCostBasis = getCostBasis();   // stores the old value of the cost basis
         setCostBasis(getCostBasis() - (getCostBasis() / getNumberOwned()));
         setCapitalGains(getCapitalGains() + (getCurrentPrice() - (oldCostBasis / getNumberOwned())));
         numberOwned = getNumberOwned() - 1;
         return getCurrentPrice();
      }
   }
   /* A method to return the number of owned bonds*/
   public int getNumberOwned() {
      return numberOwned;
   }
}