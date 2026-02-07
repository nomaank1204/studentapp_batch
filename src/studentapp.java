import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class studentapp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "NK",
                    "Khan@1204"
            );

            while (true) {
                System.out.println("1. Insert Student");
                System.out.println("2. View Students");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                // INSERT
                if (choice == 1) {
                    System.out.print("Enter Name: ");
                    String NAME = sc.next();

                    System.out.print("Enter Age: ");
                    int AGE = sc.nextInt();

                    System.out.print("Enter Subject: ");
                    String SUBJECT = sc.next();

                    System.out.print("Enter Marks: ");
                    int MARKS = sc.nextInt();

                    PreparedStatement ps =
                            con.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");

                    ps.setString(1,NAME);
                    ps.setInt(2, AGE);
                    ps.setString(3, SUBJECT);
                    ps.setInt(4, MARKS);

                    ps.executeUpdate();
                    System.out.println("Inserted successfully");
                }

                // VIEW
                else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM student");

                    System.out.println("NAME AGE SUBJECT MARKS ");
                    while (rs.next()) {
                        System.out.println(
                                rs.getString(1) + " " +
                                        rs.getInt(2) + " " +
                                        rs.getString(3) + " " +
                                        rs.getInt(4)
                        );
                    }
                }

                // EXIT
                else if (choice == 3) {
                    con.close();
                    System.out.println("Program ended");
                    break;
                }

                else {
                    System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

