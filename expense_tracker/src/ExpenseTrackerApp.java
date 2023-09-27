import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
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

          // Validate the amount and category inputs
      if (amount!= -1 && InputValidation.isValidAmount(amount) && InputValidation.isValidCategory(category)) {
          
          // Create transaction object
          Transaction t = new Transaction(amount, category);

          // Call controller to add transaction
          view.addTransaction(t);
      } else {
          // Display error messages for invalid inputs

          if (amount!= -1 && !InputValidation.isValidAmount(amount) && !InputValidation.isValidCategory(category)) {
              view.showError("Invalid amount and category");
          }

          else if (amount!= -1 && !InputValidation.isValidAmount(amount)) {
              view.showError("Invalid amount. Amount should be greater than 0 and less than 1000.");
          }
          else if (amount!= -1 && !InputValidation.isValidCategory(category)) {
              view.showError("Invalid category. Valid categories are: food, travel, bills, entertainment, other.");
          }
          

      }  

    });

  }

}