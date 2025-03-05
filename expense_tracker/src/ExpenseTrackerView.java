

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  

  public JTable getTransactionsTable() {
    return transactionsTable; //Returns the JTable used to display transactions
  }

  public double getAmountField() { //Retrieves the amount entered by the user in the input field.
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JTextField amountField) {
    this.amountField = amountField; //Sets the amountfield component
  } 

  public String getCategoryField() {
    return categoryField.getText(); //Retrieves the category entered by the user
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField; //Sets the categoryField component.
  }

  public JButton getAddTransactionBtn() { //Returns the Add Transaction button.
    return addTransactionBtn;
  } 
  public DefaultTableModel getTableModel() { //Returns the DefaultTableModel used by the table.
    return model;
  }

  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) { //Refreshes the table with updated transaction data.
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  public void refresh() { //Refreshes the view by fetching the latest transactions and updating the table.

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  public List<Transaction> getTransactions() { //retrieves transaction
    return transactions;
  }
  
  public void addTransaction(Transaction t) { //adds transaction
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  


  // Other view methods
}
