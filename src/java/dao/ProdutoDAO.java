package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class ProdutoDAO extends DAO
{
    
    public void adicionarProduto(Produto produto, int cod_usuario, int qtd) throws SQLException
    {
        String sql = "INSERT INTO produto (nome, preco, descricao, imagem) "
		   + "VALUES(?, ?, ?, ?)";
        stm = ConnectionFactory.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stm.setString(1, produto.getNome());
        stm.setDouble(2, produto.getPreco());
        stm.setString(3, produto.getDescricao());
        stm.setString(4, produto.getImagem());
        stm.execute();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            produto.setId(generatedKeys.getInt(1));
        }
        sql = "INSERT INTO estoque (cod_usuario, cod_produto, quantidade) " 
                   + "VALUES(?, ?, ?)";
        conectar(sql);
        stm.setInt(1, cod_usuario);
        stm.setInt(2, produto.getId());
        stm.setInt(3, qtd);
        stm.execute();
        fechar();
    }
    
    public void editarProduto(Produto produto) throws SQLException
    {
        String sql = "UPDATE produto SET nome = ?, preco = ?, descricao = ?, imagem = ? "
                   + "WHERE id = ? ";
        conectar(sql);
        stm.setString(1, produto.getNome());
        stm.setDouble(2, produto.getPreco());
        stm.setString(3, produto.getDescricao());
        stm.setString(4, produto.getImagem());
        stm.setInt(5, produto.getId());
        stm.execute();
        fechar();
    }
    
    public List<Produto> listarProdutos(int cod_usuario) throws SQLException
    {
        String sql = "SELECT * FROM produto "
                   + "JOIN estoque ON estoque.cod_produto = produto.id "
                   + "WHERE estoque.cod_usuario = ? ";
        conectar(sql);
        stm.setInt(1, cod_usuario);
        List<Produto> lista = new ArrayList<Produto>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getInt("produto.id"));
            p.setNome(rs.getString("produto.nome"));
            p.setDescricao(rs.getString("produto.descricao"));
            p.setPreco(rs.getDouble("produto.preco"));
            p.setImagem(rs.getString("produto.imagem"));
            lista.add(p);
        }
        fechar();
        return lista;
    }
    
    public Produto produtoPorId(int idProduto) throws SQLException
    {
        String sql = "SELECT * FROM produto "
                   + "WHERE produto.id = ? ";
        conectar(sql);
        stm.setInt(1, idProduto);
        Produto p = new Produto();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            p.setId(rs.getInt("produto.id"));
            p.setNome(rs.getString("produto.nome"));
            p.setDescricao(rs.getString("produto.descricao"));
            p.setPreco(rs.getDouble("produto.preco"));
            p.setImagem(rs.getString("produto.imagem"));
        }
        fechar();
        return p;
    }
    
    public void removerProduto(int produto, int codUsuario) throws SQLException
    {
        String sql = "DELETE FROM estoque " +
                     "WHERE cod_produto = ? AND cod_usuario = ?; ";
        conectar(sql);
        stm.setInt(1, produto);
        stm.setInt(2, codUsuario);
        stm.execute();
        sql = "DELETE FROM produto " +
                     "WHERE id = ?; ";
        conectar(sql);
        stm.setInt(1, produto);
        stm.execute();
        fechar();
    }
    
}
