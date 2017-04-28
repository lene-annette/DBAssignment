/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbassignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lene_
 */
public class DataAccessObjectImpl implements DataAccessObject {

    private final DBConnector conn;

    public DataAccessObjectImpl() throws Exception {
        this.conn = new DBConnector();
    }

    @Override
    public ArrayList<User> getTeamMembers(int team_id) {

    }

    @Override
    public ArrayList<Team> getTeams() {

    }

    @Override
    public Team getTeam(int id) {

    }

    @Override
    public ArrayList<User> getUsers() {

    }

    
    public User getUser(int id) throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where user_id = " + id;
        User us = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                us = new User(userid, username, password, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }
    
    }
