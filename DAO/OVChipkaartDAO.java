package P4.DAO;

import P4.Domein.Reiziger;
import P4.Domein.OVChipkaart;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDAO{
    public boolean save(OVChipkaart ovChipkaart) throws SQLException;
    public boolean update(OVChipkaart ovChipkaart) throws SQLException;
    public boolean delete(OVChipkaart ovChipkaart) throws SQLException;
    public List<OVChipkaart> findAll() throws SQLException;
}
