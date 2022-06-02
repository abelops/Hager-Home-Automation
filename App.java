
import res.mains.ContCent;
import res.mains.Database;
import res.mains.Home;
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\t\t\t\t______________HAGER HOME AUTOMATION APP__________________\n\n");
        System.out.print("Starting the App");

        //Built in User Registration
        Database.BuiltInUser("abel", "1234");

        //Starting the Actual GUI
        new Home();
    }   
}