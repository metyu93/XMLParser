/**
 * Created by metin.namli on 2.01.2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    public static Connection getConnection(){
        try{
            String URL = "jdbc:sqlserver://192.168.0.74;databaseName=trendyol.dev;user=trendyoluser;password=29trendyol29" ;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL);
        }
        catch(Exception ex){
            System.out.println("Bağlantı başarısız");
            return  null;

        }

    }
}
