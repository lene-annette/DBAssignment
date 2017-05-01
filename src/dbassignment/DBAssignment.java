/*
 * Main method for the assignment. 
*/
package dbassignment;

import java.util.ArrayList;

/**
 * @author Anders Hedegaard Christiansen & Lene Annette Skov
 */
public class DBAssignment {

    public static void main(String[] args) throws Exception {
        DataAccessObjectImpl dao = new DataAccessObjectImpl();
        try {
            // get all teams
            ArrayList<Team> teams = dao.getTeams();
            for (Team team : teams) {
                System.out.println(team);
            }
            // get one team by id
            Team team = dao.getTeam(1);
            System.out.println(team);
            // get all users
            ArrayList<User> users = dao.getUsers();
            for (User user : users) {
                System.out.println(user);
            }
            // get user by id
            User user = dao.getUser(1);
            System.out.println(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
