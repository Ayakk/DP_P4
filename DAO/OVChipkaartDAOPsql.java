package P4.DAO;


import P4.Domein.OVChipkaart;
import P4.Domein.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDAOPsql implements OVChipkaartDAO {
    private Connection conn;
    private AdresDAOPsql adao;

    public OVChipkaartDAOPsql(Connection conn){
        this.conn = conn;
        this.adao=new AdresDAOPsql(conn);
    }

    public boolean save(OVChipkaart ovChipkaart) throws SQLException {
        PreparedStatement mystmt = conn.prepareStatement("INSERT INTO ov_chipkaart VALUES (?, ?, ?, ?, ?)");
        mystmt.setInt(1, ovChipkaart.getKaartNummer());
        mystmt.setDate(2, ovChipkaart.getGeldigTot());
        mystmt.setInt(3, ovChipkaart.getKlasse());
        mystmt.setDouble(4, ovChipkaart.getSaldo());
        mystmt.setInt(5, ovChipkaart.getReiziger().getReizigerId());
        mystmt.executeUpdate();
        mystmt.close();
        return true;
    }

    public boolean update(OVChipkaart ovChipkaart) throws SQLException {
        PreparedStatement mystmt = conn.prepareStatement("INSERT INTO ov_chipkaart VALUES (?, ?, ?, ?, ?)");
        mystmt.setInt(1, ovChipkaart.getKaartNummer());
        mystmt.setDate(2, ovChipkaart.getGeldigTot());
        mystmt.setInt(3, ovChipkaart.getKlasse());
        mystmt.setDouble(4, ovChipkaart.getSaldo());
        mystmt.setInt(5, ovChipkaart.getReiziger().getReizigerId());
        mystmt.executeQuery();
        mystmt.close();
        return true;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) throws SQLException{
        PreparedStatement mystmt = conn.prepareStatement("DELETE FROM ov_chipkaart WHERE kaart_nummer=?");
        mystmt.setInt(1, ovChipkaart.getKaartNummer());
        mystmt.executeUpdate();
        mystmt.close();
        return true;
    }


    public OVChipkaart findById(int id) throws SQLException{
        PreparedStatement mystmt = conn.prepareStatement("SELECT * FROM ov_chipkaart WHERE kaart_nummer=?");
        mystmt.setInt(1, id);
        ResultSet rs = mystmt.executeQuery("SELECT * FROM reiziger");

        int kaart_nummer = rs.getInt(1);
        Date geldig_tot = rs.getDate(2);
        int klasse = rs.getInt(3);
        double saldo = rs.getDouble(4);
        int reiziger_id = rs.getInt(5);
        Reiziger r = new Reiziger(reiziger_id, null, null, null, null);

        OVChipkaart ov = new OVChipkaart(kaart_nummer, geldig_tot, klasse, saldo, r);
        mystmt.close();
        rs.close();
        return ov;
    }

    @Override
    public List<OVChipkaart> findAll() throws SQLException{
        List l1 = new ArrayList<OVChipkaart>();
        PreparedStatement st = conn.prepareStatement("SELECT * FROM ov_chipkaart");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            int kaart_nummer = rs.getInt(1);
            Date geldig_tot = rs.getDate(2);
            int klasse = rs.getInt(3);
            double saldo = rs.getDouble(4);
            int reiziger_id = rs.getInt(5);
            Reiziger r = new Reiziger(reiziger_id, null, null, null, null);

            OVChipkaart ov = new OVChipkaart(kaart_nummer, geldig_tot, klasse, saldo, r);
            l1.add(ov);
        }
        rs.close();
        st.close();
        return l1;
    }
}
