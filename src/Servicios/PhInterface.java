package Servicios;
import java.io.IOException;
import java.util.List;
import dto.DTO;
public interface PhInterface {
    List<DTO> findAll() throws IOException, ClassNotFoundException;

    void save(DTO var1) throws IOException;
}
