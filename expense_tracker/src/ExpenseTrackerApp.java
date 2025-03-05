import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) { //Initializes the Model View Controller components and creates an instance of the view.
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      String validationMessage = InputValidation.validateInputs(amount, category);
      if(!validationMessage.equals("Valid inputs")){
         JOptionPane.showMessageDialog(view, validationMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
         return; // Stop processing further
        }

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}
