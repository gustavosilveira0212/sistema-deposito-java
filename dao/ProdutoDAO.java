package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.Produto;
import conexao.Conexao;

public class ProdutoDAO {

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO PRODUTO (nomeProduto, valorProduto, quantidadeProduto) VALUES (?, ?, ?)";

        // 🔒 validação
        if (produto.getNomeProduto() == null || produto.getNomeProduto().isEmpty()) {
            System.out.println("Nome do produto não pode ser vazio!");
            return;
        }

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, produto.getNomeProduto());
            ps.setDouble(2, produto.getValorProduto());
            ps.setInt(3, produto.getQuantidadeProduto());

            ps.executeUpdate();
            ps.close();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM PRODUTO WHERE nomeProduto IS NOT NULL AND nomeProduto <> ''";

        List<Produto> listaProdutos = new ArrayList<>();

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("idproduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setValorProduto(rs.getDouble("valorProduto"));
                produto.setQuantidadeProduto(rs.getInt("quantidadeProduto"));

                listaProdutos.add(produto);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }

    public void deletarProduto(int idproduto) {
        String sql = "DELETE FROM PRODUTO WHERE idproduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idproduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Produto deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerQuantidadeProduto(int quantidadeProduto, int idproduto) {
        String sql = "UPDATE PRODUTO SET quantidadeProduto = quantidadeProduto - ? WHERE idproduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, quantidadeProduto);
            ps.setInt(2, idproduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Quantidade removida do estoque!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarQuantidadeProduto(int quantidadeProduto, int idproduto) {
        String sql = "UPDATE PRODUTO SET quantidadeProduto = quantidadeProduto + ? WHERE idproduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, quantidadeProduto);
            ps.setInt(2, idproduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Quantidade adicionada ao estoque!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNomeProduto(String nomeProduto) {
        String sql = "UPDATE PRODUTO SET nomeProduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nomeProduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Nome do produto atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarQuantidadeProduto(int quantidadeProduto) {
        String sql = "UPDATE PRODUTO SET quantidadeProduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, quantidadeProduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Quantidade atualizada!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizarValorProduto(double valorProduto) {
        String sql = "UPDATE PRODUTO SET valorProduto = ?";

        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, valorProduto);

            ps.executeUpdate();
            ps.close();

            System.out.println("Valor atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}