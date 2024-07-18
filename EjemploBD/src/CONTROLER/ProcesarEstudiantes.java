package CONTROLER;

import MODEL.Estudiante;
import MODEL.ConeccionDB;
import java.util.ArrayList;

public class ProcesarEstudiantes {
    private ArrayList<Estudiante> lstEst;
    private ConeccionDB coneccionDB;

    public ProcesarEstudiantes(ArrayList<Estudiante> lstEst) {
        this.lstEst = lstEst;
        this.coneccionDB = new ConeccionDB();
    }

    public void calculoPromedios() {
        for (Estudiante est : lstEst) {
            est.promedio = (est.nota1 + est.nota2) / 2;
        }
    }

    public void calculoEstados() {
        for (Estudiante est : lstEst) {
            est.estado = est.promedio >= 6 ? "Aprobado" : "Reprobado";
        }
    }

    public void insertarEstudiante(Estudiante est) {
        coneccionDB.insertarEstudiante(est);
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        return coneccionDB.getLstEstudiantes();
    }

    public void actualizarEstudiante(Estudiante est) {
        coneccionDB.actualizarEstudiante(est);
    }

    public void eliminarEstudiante(int id) {
        coneccionDB.eliminarEstudiante(id);
    }
}
