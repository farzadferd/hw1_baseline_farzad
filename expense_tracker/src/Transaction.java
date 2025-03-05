

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transaction {

  private double amount;
  private String category;
  private String timestamp;

  public Transaction(double amount, String category) { //Constructor that creates a new transaction with the given amount and category, automatically setting the timestamp.

    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() { //Returns the amount of the transaction
    return amount;
  }

  public void setAmount(double amount) { //Sets the amount of the transaction.
    this.amount = amount;
  }

  public String getCategory() { //Returns the category of the transaction.
    return category;
  }

  public void setCategory(String category) { //Sets the category of the transaction.
    this.category = category; 
  }
  
  public String getTimestamp() { //Returns the timestamp of the transaction.
    return timestamp;
  }

  private String generateTimestamp() { //Generates and returns the current timestamp of the transaction
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}
