package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Estoque;

public class EstoqueDAO extends DAO 
{
    
    public void atualizarEstoque(Estoque estoque) throws SQLException
    {
        String sql = "UPDATE estoque SET cod_usuario = ?, cod_produto = ?, quantidade = ? " 
                   + "WHERE id = ?";
        conectar(sql);
        stm.setInt(1, estoque.getCodUsuario());
        stm.setInt(2, estoque.getCodProduto());
        stm.setInt(3, estoque.getQuantidade());
        stm.setInt(4, estoque.getId());
        stm.execute();
        fechar();
    }
    
    public List<Estoque> listarEstoque(int codUsuario) throws SQLException
    {
        String sql = "SELECT * FROM estoque "
                   + "JOIN produto ON estoque.cod_produto = produto.id "
                   + "WHERE estoque.cod_usuario = ? ";
        conectar(sql);
        stm.setInt(1, codUsuario);
        List<Estoque> lista = new ArrayList<Estoque>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Estoque e = new Estoque();
            e.setId(rs.getInt("estoque.id"));
            e.setNomeProduto(rs.getString("produto.nome"));
            e.setCodProduto(rs.getInt("estoque.cod_produto"));
            e.setCodUsuario(rs.getInt("estoque.cod_usuario"));
            e.setQuantidade(rs.getInt("estoque.quantidade"));
            lista.add(e);
        }
        fechar();
        return lista;
    }
    
    public Estoque estoquePorId(int idEstoque) throws SQLException
    {
        String sql = "SELECT * FROM estoque "
                   + "JOIN produto ON estoque.cod_produto = produto.id "
                   + "WHERE estoque.id = ? ";
        conectar(sql);
        stm.setInt(1, idEstoque);
        Estoque e = new Estoque();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            e.setId(rs.getInt("estoque.id"));
            e.setNomeProduto(rs.getString("produto.nome"));
            e.setCodProduto(rs.getInt("estoque.cod_produto"));
            e.setCodUsuario(rs.getInt("estoque.cod_usuario"));
            e.setQuantidade(rs.getInt("estoque.quantidade"));
        }
        fechar();
        return e;
    }
    
}
