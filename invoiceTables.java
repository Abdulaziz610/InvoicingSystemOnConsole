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
            String invoiceTable = "CREATE TABLE Hotels "
                    + "(id INT PRIMARY KEY, "
                    + "hotel_name VARCHAR(255) NOT NULL, "
                    + "hotel_location VARCHAR(255), "
                    + "created_date DATE NOT NULL, "
                    + "updated_date DATE, "
                    + "is_Active bit NOT NULL)";

            statement.executeUpdate(invoiceTable);
}
    }
