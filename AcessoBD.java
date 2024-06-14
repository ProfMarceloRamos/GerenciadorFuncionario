import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessoBD {
    
    // Informações do banco de dados
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USUARIO = "postgres";
    static final String SENHA = "root";

    public static void main(String[] args) {

        try {
            // Registrar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            // Criar uma declaração para executar consultas
            Statement statement = connection.createStatement();

            // Exemplo: inserir dados na tabela
            String inserirQuery = "INSERT INTO empresa (nmEmpresa, tipoRamo) VALUES ('Empresa A', 1)";
            statement.executeUpdate(inserirQuery);
            System.out.println("Dados inseridos com sucesso!");

            // Fechar recursos
            //resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados!");
            e.printStackTrace();
        }
        

    }

}
