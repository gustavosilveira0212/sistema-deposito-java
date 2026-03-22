package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import sistemaInterface.UsuarioStaff;

public class StaffDAO {
    public void cadastrarStaff(UsuarioStaff usuarioStaff) {
        String sql = "INSERT INTO STAFF (cpfStaff, emailStaff, nomeStaff, senhaStaff, codigoStaff) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuarioStaff.getCpfStaff());
            ps.setString(2, usuarioStaff.getEmailStaff());
            ps.setString(3, usuarioStaff.getNomeStaff());
            ps.setString(4, usuarioStaff.getSenhaStaff());
            ps.setInt(5, usuarioStaff.getCodigoStaff());

            ps.execute();
            ps.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
