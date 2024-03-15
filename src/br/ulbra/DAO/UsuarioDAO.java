package br.ulbra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class UsuarioDAO {


        Connection con;

        public UsuarioDAO() throws SQLException {
            con = ConnectionFactory.getConnection();
        }

    public Connection getConnection() {
        return con;
    }
        

        public boolean checkLogin(String login, String senha) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            try {
                stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE emailusu = ? and senhausu = ?");
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally {

                ConnectionFactory.closeConnection(con, stmt, rs);
            }
            return check;
        }

   
    
    }

