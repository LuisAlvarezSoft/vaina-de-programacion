package dto;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.io.Serializable;

public class DTO implements Serializable {
    public Integer Q1;
    public Integer Q2;
    public Integer Q3;
    public Integer Q4;
    public Double F1;
    public Double F2;
    public Double F3;
    public Double Fr;
    public Double tetaFRf;
    public Double FRx;
    public Double FRy;
    public Integer angulo2;
    public Double longitud;

    public DTO(Integer q1, Integer q2, Integer q3, Integer q4, Double f1, Double f2, Double f3, Double fr, Double tetaFRf, Double FRx, Double FRy, Integer angulo2, Double longitud) {
        this.Q1 = q1;
        this.Q2 = q2;
        this.Q3 = q3;
        this.Q4 = q4;
        this.F1 = f1;
        this.F2 = f2;
        this.F3 = f3;
        this.Fr = fr;
        this.tetaFRf = tetaFRf;
        this.FRx = FRx;
        this.FRy = FRy;
        this.angulo2 = angulo2;
        this.longitud = longitud;
    }

    public String toString() {
        return "Record:\n-Q1=" + this.Q1 + "C, Q2=" + this.Q2 + "C, Q3=" + this.Q3 + "C, Q4=" + this.Q4 + "C\n-F1=" + this.F1 + "N, F2=" + this.F2 + "N, F3=" + this.F3 + "N, Fr=" + this.Fr + "N, tetaFRf=" + this.tetaFRf + "θ, FRx=" + this.FRx + "N, FRy=" + this.FRy + "N\n-angulo2=" + this.angulo2 + "θ\n-longitud=" + this.longitud + "m";
    }
}
