package MikesMikes.tutorials;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author MikesMikes
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Connection conn = null;

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("db.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}