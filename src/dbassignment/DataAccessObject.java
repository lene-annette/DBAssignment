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
	public ArrayList<User> getTeamMembers(int team_id) throws Exception;
	public ArrayList<Team> getTeams() throws Exception;
	public Team getTeam(int id) throws Exception;
	// User
	public ArrayList<User> getUsers() throws Exception;
	public User getUser(int id) throws Exception;
}

    

