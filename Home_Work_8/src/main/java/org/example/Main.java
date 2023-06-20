package org.example;
import org.example.ui.UserMain;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        UserMain userMain = new UserMain();
        userMain.run();
    }
}
