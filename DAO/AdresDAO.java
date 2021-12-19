package P4.DAO;

import P4.Domein.Adres;
import P4.Domein.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface AdresDAO{
    public boolean save(Adres adres) throws SQLException;
    public boolean update(Adres adres) throws SQLException;
    public boolean delete(Adres adres) throws SQLException;
    public Adres findByReiziger(Reiziger reiziger) throws SQLException;
    public boolean findById(int i) throws SQLException;
    public List<Adres> findAll() throws SQLException;
}
