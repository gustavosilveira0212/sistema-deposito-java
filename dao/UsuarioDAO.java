package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import sistemaInterface.Usuario;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (nomeCliente, cpfCliente, emailCliente, senhaCliente) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNomeCliente());
            ps.setString(2, usuario.getCpfCliente());
            ps.setString(3, usuario.getEmailCliente());
            ps.setString(4, usuario.getSenhaCliente());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean login(String cpfCliente, String senhaCliente) {
        String sql = "SELECT * FROM USUARIO WHERE cpfCliente = ? AND senhaCliente = ?"; 

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cpfCliente);
            ps.setString(2, senhaCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            rs.close();
            ps.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
