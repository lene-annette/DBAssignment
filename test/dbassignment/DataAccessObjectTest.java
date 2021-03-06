
package dbassignment;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


public class DataAccessObjectTest {

    private static DataAccessObject dao;

    public DataAccessObjectTest() {
    }

    // Setup
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        dao = new DataAccessObjectImpl();
    }

    @After
    public void tearDown() {
    }

    // Test teams
    @Test
    public void testGetTeamMembers() {
        // Positive test
        User user;

        ArrayList<User> teamMembers = dao.getTeamMembers(1);
        assertNotNull(teamMembers);
        assertFalse(teamMembers.isEmpty());
        assertEquals(teamMembers.size(), 3);

        user = teamMembers.get(0);
        assertEquals(user.getId(), 2);
        assertEquals(user.getUsername(), "Mickey Mouse");
        assertEquals(user.getPassword(), "5678");
        assertEquals(user.isAdmin(), true);

        user = teamMembers.get(1);
        assertEquals(user.getId(), 3);
        assertEquals(user.getUsername(), "Fedtmule");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);

        user = teamMembers.get(2);
        assertEquals(user.getId(), 7);
        assertEquals(user.getUsername(), "Pluto");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), false);
    }

    @Test
    public void testGetTeamMembersInValidTeamID() {
        // Negative test
        ArrayList<User> teamMembers = dao.getTeamMembers(99);
        assertNotNull(teamMembers);
        assertTrue(teamMembers.isEmpty());
    }

    @Test
    public void testGetAllTeams() {
        ArrayList<Team> teams = dao.getTeams();
        assertNotNull(teams);
        assertFalse(teams.isEmpty());
        Team team = teams.get(0);
        assertEquals(team.getTeamName(), "A");
        assertEquals(team.getTeammembers().size(), 3);
    }

    @Test
    public void testGetTeamByID() {
        // positive test
        Team team = dao.getTeam(1);
        assertNotNull(team);
        assertEquals(team.getTeamName(), "A");
        assertEquals(team.getTeammembers().size(), 3);
    }

    @Test
    public void testGetTeamByInvalidID() {
        // Negative test
        Team team = dao.getTeam(99);
        assertNull(team);
    }

//    Test users
    @Test
    public void testGetAllUsers() {
        ArrayList<User> users = dao.getUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        User user = users.get(0);
        assertEquals(user.getId(), 1);
        assertEquals(user.getUsername(), "Anders And");
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), true);
    }

    @Test
    public void testGetUserByID() {
        // positive test
        User user = dao.getUser(1);
        assertNotNull(user);
        assertEquals(user.getUsername(), "Anders And");
        assertEquals(user.getId(), 1);
        assertEquals(user.getPassword(), "1234");
        assertEquals(user.isAdmin(), true);
    }

    @Test
    public void testGetUserByInvalidID() {
        // Negative test
        User user = dao.getUser(99);
        assertNull(user);
    }
}
