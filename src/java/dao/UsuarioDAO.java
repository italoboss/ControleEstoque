package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class UsuarioDAO extends DAO
{
    
    public void adicionarUsuario(Usuario usuario) throws SQLException
    {
        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?) ";
        conectar(sql);
        stm.setString(1, usuario.getLogin());
        stm.setString(2, usuario.getSenha());
        stm.execute();
        fechar();
    }
    
    public void editarUsuario(Usuario usuario) throws SQLException
    {
        String sql = "UPDATE usuario SET login = ?, senha = ? "
                   + "WHERE id = ? ";
        conectar(sql);
        stm.setString(1, usuario.getLogin());
        stm.setString(2, usuario.getSenha());
        stm.setInt(3, usuario.getId());
        stm.execute();
        fechar();
    }
    
    public boolean validarUsuario(Usuario usuario) throws SQLException
    {
        String sql = "SELECT id, login, senha FROM usuario WHERE login = '" + usuario.getLogin() + "'";
        conectar(sql);
        ResultSet rs = stm.executeQuery(sql);
        String password = null;
        while (rs.next()) {
            usuario.setId(rs.getInt("id"));
            password = (rs.getString("senha"));
        }
        fechar();
        return password != null && password.equals(usuario.getSenha());
    }
    
    public List<Usuario> listarUsuarios() throws SQLException
    {
        String sql = "SELECT * FROM usuario ";
        conectar(sql);
        List<Usuario> lista = new ArrayList<Usuario>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("usuario.id"));
            u.setLogin(rs.getString("usuario.login"));
            lista.add(u);
        }
        fechar();
        return lista;
    }
    
    public Usuario usuarioPorId(int idUsuario) throws SQLException
    {
        String sql = "SELECT * FROM usuario "
                   + "WHERE usuario.id = ? ";
        conectar(sql);
        stm.setInt(1, idUsuario);
        Usuario u = new Usuario();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            u.setId(rs.getInt("usuario.id"));
            u.setLogin(rs.getString("usuario.login"));
            u.setSenha(rs.getString("usuario.senha"));
        }
        fechar();
        return u;
    }
    
    public void removerUsuario(int usuario) throws SQLException
    {
        String sql = "DELETE FROM usuario WHERE id = ?; ";
        conectar(sql);
        stm.setInt(1, usuario);
        stm.execute();
        fechar();
    }
    
}
