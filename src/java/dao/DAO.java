package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {

    protected PreparedStatement stm;

    protected void conectar(String sql) {
        try {
            stm = ConnectionFactory.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    protected void fechar() {
        try {
            stm.close();
            ConnectionFactory.getConnection().close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void commit()
    {
        try {
            if (!ConnectionFactory.getConnection().isClosed())
                ConnectionFactory.getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback()
    {
        try {
            if (!ConnectionFactory.getConnection().isClosed())
                ConnectionFactory.getConnection().rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
