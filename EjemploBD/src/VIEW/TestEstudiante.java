package VIEW;
import MODEL.Estudiante;
import CONTROLER.ProcesarEstudiantes;
import java.util.ArrayList;
import java.util.List;
public class TestEstudiante {
    public static void main(String[] args) {
        // Lista inicial de estudiantes con datos aleatorios
        ArrayList<Estudiante> lstEst = new ArrayList<>(List.of(
                new Estudiante(0, "Paul", Math.random() * 10, Math.random() * 10),
                new Estudiante(0, "Estafania", Math.random() * 10, Math.random() * 10)
        ));

        ProcesarEstudiantes procesarEstudiantes = new ProcesarEstudiantes(lstEst);
        procesarEstudiantes.calculoPromedios();
        procesarEstudiantes.calculoEstados();
        for (Estudiante est : lstEst) {
            procesarEstudiantes.insertarEstudiante(est);
        }
        ArrayList<Estudiante> lstEst2 = procesarEstudiantes.getLstEstudiantes();
        for (Estudiante est : lstEst2) {
            System.out.println(est);
        }
    }
}