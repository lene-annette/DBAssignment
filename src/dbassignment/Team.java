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
public class Team {
    private int id;
    private String teamName;
    private ArrayList<User> teammembers;

    public Team(int id, String teamname, ArrayList<User> teammembers) {
        this.id = id;
        this.teamName = teamname;
        this.teammembers = teammembers;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<User> getTeammembers() {
        return teammembers;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", teamName=" + teamName + ", teammembers=" + teammembers + '}';
    }
    

 
    
    
}
