
package dbassignment;

class Teammember {
    private int teamId;
    private int userId;

    public Teammember(int teamId, int userId) {
        this.teamId = teamId;
        this.userId = userId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Teammember{" + "teamId=" + teamId + ", userId=" + userId + '}';
    }
    
    
    
}
