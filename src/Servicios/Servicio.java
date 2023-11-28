//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Servicios;

import dto.DTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements PhInterface {
    private List<DTO> objc = new ArrayList();

    public Servicio() throws IOException, ClassNotFoundException {
    }

    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        this.objc = (List)ObjetoSerializable.readObjectFromFile("figurine.ax");
        return this.objc;
    }

    public void save(DTO figura) throws IOException {
        this.objc.add(figura);
        ObjetoSerializable.writeObjectToFile(this.objc, "figurine.ax");
    }
}
