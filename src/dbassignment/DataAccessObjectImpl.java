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
    public ArrayList<User> getTeamMembers(int team_id) throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "Select * from user where user_id in (select user_id from team_member where team_id = " + team_id + ")";
        ArrayList<User> members = new ArrayList<User>();
        User us = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                us = new User(userid, username, password, admin);
                members.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    @Override
    public ArrayList<Team> getTeams() throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from team";
        ArrayList<Team> teams = new ArrayList<Team>();
        Team te = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int teamid = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                ArrayList<User> members = getTeamMembers(teamid);
                te = new Team(teamid,teamname,members);
                
                teams.add(te);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    @Override
    public Team getTeam(int id) throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from team";
        Team team = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int teamid = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                ArrayList<User> members = getTeamMembers(teamid);
                team = new Team(teamid, teamname, members);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }

    @Override
    public ArrayList<User> getUsers() throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user";
        ArrayList<User> users = new ArrayList<User>();
        User us = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                us = new User(userid, username, password, admin);
                users.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User getUser(int id) throws Exception {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from user where user_id = " + id;
        User us = null;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
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
