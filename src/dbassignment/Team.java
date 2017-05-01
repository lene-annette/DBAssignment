/*
 * Team entity class
 */
package dbassignment;

import java.util.ArrayList;

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
