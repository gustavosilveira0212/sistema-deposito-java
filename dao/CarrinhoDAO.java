package dao;

import estoque.Carrinho;
import conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {

    public void adicionarAoCarrinho(Carrinho carrinho) {
        String sql = "INSERT INTO CARRINHO (idUsuario, idProduto, quantidadeCarrinho) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, carrinho.getIdUsuario());
            ps.setInt(2, carrinho.getIdProduto());
            ps.setInt(3, carrinho.getQuantidadeCarrinho());

            ps.execute();
            ps.close();

            System.out.println("Produto adicionado ao carrinho!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carrinho> listarCarrinhoUsuario(int idUsuario) {
        String sql = "SELECT * FROM CARRINHO WHERE idUsuario = ?";

        List<Carrinho> lista = new ArrayList<>();

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Carrinho carrinho = new Carrinho();

                carrinho.setIdCarrinho(rs.getInt("idCarrinho"));
                carrinho.setIdUsuario(rs.getInt("idUsuario"));
                carrinho.setIdProduto(rs.getInt("idProduto"));
                carrinho.setQuantidadeCarrinho(rs.getInt("quantidadeCarrinho"));

                lista.add(carrinho);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void removerItemCarrinho(int idCarrinho) {
        String sql = "DELETE FROM CARRINHO WHERE idCarrinho = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idCarrinho);

            ps.executeUpdate();
            ps.close();

            System.out.println("Item removido do carrinho!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void limparCarrinhoUsuario(int idUsuario) {
        String sql = "DELETE FROM CARRINHO WHERE idUsuario = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idUsuario);

            ps.executeUpdate();
            ps.close();

            System.out.println("Carrinho limpo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}