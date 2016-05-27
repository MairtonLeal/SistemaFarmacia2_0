
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RemedioDB {
    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BDNAME = "remediofarm";
    private final String URL = "jdbc:mysql://localhost/" + BDNAME;  //jdbc:mysql://localhost/
    private final String LOGIN = "root";
    private final String SENHA = "mysql";
    public boolean getConnection(){
        
        
        
        try{
            Class.forName(DRIVER); //carrega o driver
            connection = DriverManager.getConnection(URL, LOGIN, SENHA); //estabelece a conexão por meio do obj connection
            System.out.println("Conectou");
            return true;
        }catch(ClassNotFoundException erro){
            System.out.println("Driver não encontrado " +erro.toString());
            return false;
        }catch(SQLException erro){
            System.out.println("Falha ao conectar " +erro.toString());
            return false;
        }
    }
    public void close(){
        try{
            connection.close();
            System.out.println("Desconectou");
        }catch(SQLException erro){   
        }
    }
}
