/* Ming Zhuang presented
 * A class represents a customer account which can keep track of stock, bond, etc.*/
public class Customer extends Object {
   
   /* A field stores the address of bond instance*/
   private Bond bond = new Bond ("myBond", 10, 1.0);
   
   /* A field stores the address of mutual fund*/
   private MutualFund mutualFund = new MutualFund ("myMutualFund", 'a', 10);
   
   /* A field stores the address of stock*/
   private Stock stock = new Stock ("myStock", 'b', 10);
   
   /* A field stores the address of cash account*/
   private CashAsset cashAccount= new CashAsset (1,1,1,1);
   
   /* A field reresents the commission rate*/
   private double commissionAmount = 0.0;
   
   /* A constructor which initializes the cash account and the commission*/
   public Customer (CashAsset cashAccount, double commissionAmount) {
      this.cashAccount = cashAccount;
      this.commissionAmount = commissionAmount;
   }
   
   /* A constructor which initializes the cash account, the bond, the mutual fiund, the stock and the commission*/
   public Customer (CashAsset cashAccount, Bond bond, MutualFund mutualFund, Stock stock, double commissionAmount) {
      this.cashAccount = cashAccount;
      this.bond = bond;
      this.mutualFund = mutualFund;
      this.stock = stock;
      this.commissionAmount = commissionAmount;
   }
   
   /* A method to return the address of an instance associated with this account of the type Bond*/
   public Bond getBond () {
      return bond;
   }
   
   /* A method to set a new bond */
   public void setBond (Bond bond) {
      this.bond = bond;
   }
   
   /* A method to return the address of an instance associated with this account of the type MutualFund*/
   public MutualFund getMutualFund () {
      return mutualFund;
   }
   
   /* A method to set a new mutua fund*/
   public void setMutualFund (MutualFund mutualFund) {
      this.mutualFund = mutualFund;
   }
   
   /* A method to return the address of an instance associated with this account of the type Stock*/
   public Stock getStock () {
      return stock;
   }
   
   /* A method to set a new stock*/
   public void setStock (Stock stock) {
      this.stock = stock;
   }
   
   /* A method to return the address of an instance associated with this account of the type CashAsset*/
   public CashAsset getCashAccount () {
      return cashAccount;
   }
   
   /* A method to set a new cash account*/
   public void setCashAccount (CashAsset cashAccount) {
      this.cashAccount = cashAccount;
   }
   
   /* A method to return the amount of commission*/
   public double getCommissionAmount () {
      return commissionAmount;
   }
   
   /* A method to set the new amount of commission*/
   public void setCommissionAmount (double commissionAmount) {
      this.commissionAmount = commissionAmount;
   }
   
   /* A method to return the sum amount of money in all your four kinds of accounts*/
   public double currentValue () {
      return cashAccount.getBalance() + bond.getCurrentPrice() + stock.getNumberShares() * stock.getCurrentPrice() + mutualFund.getNumberShares() * mutualFund.getCurrentPrice();
   }
   
   /* A mothod to return the sum of capital gains in stock, mutualFund and bond*/
   public double getCapitalGains () {
      return bond.getCapitalGains() + mutualFund.getCapitalGains() + stock.getCapitalGains();
   }
   
   /* A method to add certain amount money to the cash account balance*/
   public void deposit (double amount) {
      cashAccount.deposit(amount);
   }
   
   /* A method to withdraw a certain amount of money from the cash account balance*/
   public boolean withdraw (double amount) {
      if (amount > cashAccount.getBalance())
         return false;
      else{
         cashAccount.withdraw(amount, false);
         return true;
      }
   }
   
   /* A method to sell your bond by 1 and deposit the money to the account balance*/
   public void sellBond () {
      bond.sell();
      cashAccount.deposit(bond.getCurrentPrice());
   }
   
   /* A method to buy a bond by 1 and deduct the money from the account balance*/
   public boolean buyBond () {
      if (bond.getCurrentPrice() > this.currentValue())
         return false;
      else {
         bond.buy();
         cashAccount.withdraw(bond.getCurrentPrice(), true);
         return true;
      }
   }
   
   /* A method for the customer to pay the bond interest and deposit the value into the cash account*/
   public void payBondInterest () {
      bond.payInterest();
      cashAccount.deposit(bond.getInterestRate() * bond.getPrincipal());
   }
   
   /* A method for the customer to withdraw from the mutual fund aka sell them, and deposit the money into the cash account balance*/
   public void withdrawMutualFund (double amountWithdrawn) {
      mutualFund.sell(amountWithdrawn);
      cashAccount.deposit(amountWithdrawn);
   }
   
   /* A method for the customer to buy the mutual fund and deduct the money from the cash account balance*/
   public boolean buyMutualFund (double amountInvented) {
      if (mutualFund.getCurrentPrice() > this.currentValue())
         return false;
      else {
         mutualFund.buy(amountInvented);
         cashAccount.withdraw(amountInvented, true);
         return true;
      }
   }
   
   /* A method for customer to sell the stock shares and deposit the money into the cash account balance*/
   public void sellStockShares (int numberShares) {
      stock.sell(numberShares, commissionAmount);
      cashAccount.deposit(numberShares * stock.getCurrentPrice() - commissionAmount);
   }
   
   /* A method for customer to buy stock shares and deduct the money from the cash account balance*/
   public boolean buyStockShares (int numberShares) {
      if ((numberShares * stock.getCurrentPrice() + commissionAmount) > this.currentValue())
         return false;
      else {
         stock.buy(numberShares, commissionAmount);
         cashAccount.withdraw((numberShares * stock.getCurrentPrice() + commissionAmount), true);
         return true;
      }
   }
}