package MODEL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConeccionDB {
    public Connection concDB;
    public String msj;
    public void setConcDB(String url) {
        try {
            this.concDB = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        ArrayList<Estudiante> lstEstudiantes = new ArrayList<>();
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Estudiante");
            while (resultSet.next()) {
                lstEstudiantes.add(new Estudiante(
                        resultSet.getInt("id"),
                        resultSet.getString("nombreEst"),
                        resultSet.getDouble("nota1"),
                        resultSet.getDouble("nota2"),
                        resultSet.getDouble("promedio"),
                        resultSet.getString("estado"))
                );
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return lstEstudiantes;
    }

    public void insertarEstudiante(Estudiante estudiante) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strInsertEst = String.format("INSERT INTO Estudiante(id, nombreEst, nota1, nota2, promedio, estado) "
                    + "VALUES(%d, '%s', %f, %f, %f, '%s')",
                    estudiante.id, estudiante.nombreEst, estudiante.nota1, estudiante.nota2, estudiante.promedio, estudiante.estado);
            statement.executeUpdate(strInsertEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strUpdateEst = String.format("UPDATE Estudiante SET nombreEst='%s', nota1=%f, nota2=%f, promedio=%f, estado='%s' WHERE id=%d",
                    estudiante.nombreEst, estudiante.nota1, estudiante.nota2, estudiante.promedio, estudiante.estado, estudiante.id);
            statement.executeUpdate(strUpdateEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void eliminarEstudiante(int id) {
        try {
            setConcDB("jdbc:sqlite:bd/dbTest1.db");
            Statement statement = concDB.createStatement();
            String strDeleteEst = String.format("DELETE FROM Estudiante WHERE id=%d", id);
            statement.executeUpdate(strDeleteEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }
}
//para el delete copiar el mismo de insertar estudiante,se conecta a la msima bass de datos, lo que cambia es, 'DELETE FROM' + estudiantes + 'Where' + estudiante."id =" + estudiante.Id);
