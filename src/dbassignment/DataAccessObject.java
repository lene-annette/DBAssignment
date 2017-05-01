/*
 * The DataAccessObject interface which needs to be implemented
 */
package dbassignment;

import java.util.ArrayList;

    public interface DataAccessObject {
	// Team
	public ArrayList<User> getTeamMembers(int team_id);
	public ArrayList<Team> getTeams();
	public Team getTeam(int id);
	// User
	public ArrayList<User> getUsers();
	public User getUser(int id);
}

    

