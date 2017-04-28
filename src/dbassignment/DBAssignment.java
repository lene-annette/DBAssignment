/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbassignment;

/**
 *
 * @author lene_
 */
public class DBAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DataAccessObjectImpl dao = new DataAccessObjectImpl();
        try {
            User u = dao.getUser(1);
            System.out.println(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
