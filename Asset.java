/* Ming Zhuang Presented
 * A class represents any tangible property that has a value*/
public class Asset extends Object {
   
   /* A field to store the name of the asset */
   private String name = "null";
   
   /* A field to store a description of the asset */
   private String description = "blank";
   
   /* A field to store how much you spent to acquire the asset */
   private double costBasis = 0.0;
   
   /* A field to store the price someone is willing to buy the asset for */
   private double currentPrice = 0.0;
   
   /* A field to store the profit you made when you sell the asset */
   private double capitalGains = 0.0;
   
   /* A constructor that initializes the asset name and cost basis*/
   public Asset(String name, double costBasis) {  
      this.name = name;
      this.costBasis = costBasis;
   }
   
   /* A method returns the name of the asset */
   public String getName() {
      return this.name;
   }
   
   /* A method changes the name of the asset */
   public void setName(String name) {  
      this.name = name;
   }
   
   /* A method returns the description of the asset */
   public String getDescription() {
      return this.description;
   }
   
   /* A method changes the description of the asset */
   public void setDescription(String description) {  
      this.description = description;
   }
   
   /* A method returns the money you spent to acquire the asset */
   public double getCostBasis() {
      return this.costBasis;
   }
   
   /* A method changes the money you spent to acquire the asset */
   protected void setCostBasis(double costBasis) {  
      this.costBasis = costBasis;
   }
   
   /* A method returns the current price of the asset */
   public double getCurrentPrice() {
      return this.currentPrice;
   }
   
   /* A method changes the current price of the asset */
   public void setCurrentPrice(double currentPrice) {  
      this.currentPrice = currentPrice;
   }
   
   /* A method returns the profit made when you sell the asset*/
   public double getCapitalGains() {
      return this.capitalGains;
   }
   
   /* A method changes the profit made when you sell the asset*/
   protected void setCapitalGains(double capitalGains) {  
      this.capitalGains = capitalGains;
   }
}