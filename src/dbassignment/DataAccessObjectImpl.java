/*
 * DataAccessObject implements the DataAccessObject interface
 * This class contains methods which recieves data from the database
 */
package dbassignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObjectImpl implements DataAccessObject {

    private final DBConnector conn;

    public DataAccessObjectImpl() throws Exception {
        this.conn = new DBConnector();

    }
    
    //Team
    @Override
    public ArrayList<User> getTeamMembers(int team_id) {
        ArrayList<User> members = new ArrayList<User>();
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "Select * from user where user_id in (select user_id from team_member where team_id = " + team_id + ")";
            User user = null;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(userid, username, password, admin);
                members.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }

    @Override
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "select * from team";
            Team team = null;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int teamid = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                ArrayList<User> members = getTeamMembers(teamid);
                team = new Team(teamid, teamname, members);

                teams.add(team);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    @Override
    public Team getTeam(int id) {
        Team team = null;
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "select * from team where team_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int teamid = rs.getInt("team_id");
                String teamname = rs.getString("teamname");
                ArrayList<User> members = getTeamMembers(teamid);
                team = new Team(teamid, teamname, members);
            }
        } catch (Exception ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }
    
    //User 
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "select * from user";
            User user = null;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(userid, username, password, admin);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            Statement stmt = conn.getConnection().createStatement();
            String sql = "select * from user where user_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int userid = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                user = new User(userid, username, password, admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
