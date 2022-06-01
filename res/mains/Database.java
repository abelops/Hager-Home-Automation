package res.mains;

public class Database {
     // Stored User Password & username
     static int totalUsersNumber = 0;
     static String[]registeredUsernames = new String [100];
     static String[]registeredPasswords = new String [100];

    //Built in users reg
    public static void BuiltInUser(String name, String password){
        registeredUsernames[totalUsersNumber]= name;
        registeredPasswords[totalUsersNumber]= password;
        totalUsersNumber++;
    }
}
