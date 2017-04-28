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
    private ArrayList<Teammember> teammembers;

    public Team(int id, String teamname) {
        this.id = id;
        this.teamName = teamname;
        this.teammembers = new ArrayList<Teammember>();
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Teammember> getTeammembers() {
        return teammembers;
    }
    

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", teamname=" + teamName + '}';
    }
    
    
}
