/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbassignment;

import java.util.ArrayList;

/**
 *
 * @author lene_
 */

    public interface DataAccessObject {
	// Team
	public ArrayList<User> getTeamMembers(int team_id);
	public ArrayList<Team> getTeams();
	public Team getTeam(int id);
	// User
	public ArrayList<User> getUsers();
	public User getUser(int id) throws Exception;
}

    

