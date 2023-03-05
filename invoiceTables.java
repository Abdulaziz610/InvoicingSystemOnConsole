import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class invoiceTables {

    public static void main(String[] args) {

        String url ="jdbc:sqlserver://localhost:1433;" +
                "databaseName=DatabseInvoice;" +
                "encrypt=true;" +
                "trustServerCertificate=true";
        String username = "sa";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()) {

            // Create Hotels table
            String invoiceTable = "CREATE TABLE invoices ("
                    + "invoice_id INT PRIMARY KEY,"
                    + "customer_id INT,"
                    + "invoice_date DATE,"
                    + "total_amount DECIMAL(10, 2),"
                    + "paid_amount DECIMAL(10, 2),"
                    + "balance DECIMAL(10, 2),"
                    + "FOREIGN KEY (customer_id) REFERENCES customers(customer_id)"
                    + ");";

            statement.executeUpdate(invoiceTable);

            // Create Room_Type table
            String itemTable  = "CREATE TABLE items ("
                    + "item_id INT PRIMARY KEY,"
                    + "item_name VARCHAR(255),"
                    + "unit_price DECIMAL(10, 2)"
                    + ");";
            statement.executeUpdate(itemTable);

            // Create Rooms table
            String customerTable = "CREATE TABLE customers ("
                    + "customer_id INT PRIMARY KEY,"
                    + "full_name VARCHAR(255),"
                    + "phone_number VARCHAR(20)"
                    + ");";

            statement.executeUpdate(customerTable);


            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}