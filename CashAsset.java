/* Ming Zhaung presented
 *  A class represents money reserves*/
public class CashAsset extends Object{
   
   /* A field to keep track of the current balace*/
   private double balance = 0.0;
   
   /* A field to keep track of the interest rate paid for savings*/  
   private double savingsRate = 0.0;
   
   /* A field to track the interest rate charged for loans*/
   private double loanRate = 0.0;
   
   /* A field to store the limit that can be loaned*/
   private double loanLimit = 0.0;
   
   /* A field to store the overdraft penalty*/
   private double overdraftPenalty = 0.0;
   
   /* A field to store the interest accured this month but ot paid*/
   private double accruedInterest = 0.0;
   
   /* A field to represent whether the account has been overdrafted*/
   private boolean whetherOverdrafted = false;
   
   /* A field to track the time of the overdraft, in order to subtract the penalty at the process month call*/
   private int numberOverdrafted = 0;
   
   /* The constructor which initialize thre saving rate, the loan rate, the loan limit and the overdraft penalty*/
   public CashAsset (double savingsRate, double loanRate, double loanLimit, double overdraftPenalty){
      this.savingsRate = savingsRate;
      this.loanRate = loanRate;
      this.loanLimit = loanLimit;
      this.overdraftPenalty = overdraftPenalty;
   }
   
   /* A method to return the account balance*/
   public double getBalance() {
      return balance;
   }
   
   /* A method to return the saving interest rate*/
   public double getSavingsRate(){
      return savingsRate;
   }
   
   /* A method to change the saving interest rate*/
   public void setSavingsRate(double savingsRate){
      this.savingsRate = savingsRate;
   }
   
   /* A method to return the loan interest rate*/
   public double getLoanRate(){
      return loanRate;
   }
   
   /* A method to change the loan interest rate*/
   public void setLoanRate(double loanRate){
      this.loanRate = loanRate;
   }
   
   /* A method to return the loan limit*/
   public double getLoanLimit(){
      return loanLimit;
   }
   
   /* A method to change the loan limit*/
   public void setLoanLimit(double loanLimit){
      this.loanLimit = loanLimit;
   }
   
   /* A method to return the overdraft penalty*/
   public double getOverdraftPenalty(){
      return overdraftPenalty;
   }
   
   /* A method to change the overdraft penalty*/
   public void setOverdraftPenalty(double overdraftPenalty){
      this.overdraftPenalty = overdraftPenalty;
   }
   
   /* A method to make a deposit, adding value to the account balance*/
   public void deposit(double amount){
      balance = balance + amount;
   }
   
   /* A metod to make a withdraw, deducting value from the account balance*/
   public boolean withdraw(double amount, boolean confirm){
      if(confirm == false && amount > balance)
         return false;
      else{
         balance = balance - amount;
         return true;
      }  
   }
   
   /* A method to produce the daily accured interest, noting the time of the overdraft*/
   public void processDay(){
      if (balance >= 0)
         accruedInterest = accruedInterest + balance * (savingsRate / 365);
      else
         accruedInterest = accruedInterest + balance * (loanRate / 365);
      if (balance < 0 && balance + loanLimit < 0)
         numberOverdrafted = numberOverdrafted + 1;
   }
   
   /* A method to clear the accrued interest and add them to the balance; deduct the penalty*/
   public void processMonth(){
      balance = balance + accruedInterest;
      accruedInterest = 0;
      balance = balance - overdraftPenalty * numberOverdrafted;
      numberOverdrafted = 0;
   }
   
   /* A method to return the accrued interest*/
   public double getAccruedInterest(){
      return accruedInterest;
   }
   
   /* A method to change the accrued interest*/
   protected void setAccruedInterest(double accruedInterest){
      this.accruedInterest = accruedInterest;
   }
}