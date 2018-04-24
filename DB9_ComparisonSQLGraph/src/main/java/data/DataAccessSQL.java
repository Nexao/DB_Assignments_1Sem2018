package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Person;
import java.util.List;

public class DataAccessSQL implements IDataAccessor {

    private DBConnectorSQL sqlCon;

    public DataAccessSQL(DBConnectorSQL sqlCon) {
        this.sqlCon = sqlCon;
    }

    public Person getRandom(int id) {
        Person p = null;

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
             String query = "SELECT * FROM person WHERE id ='"+id+"' ";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
            String name = res.getString("name");
            String job = res.getString("job");
            String bday = res.getString("birthday");
            p = new Person(id + "", name, job, bday);
            }
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getRandom" + e.toString());
        }
        return p;
    }

    public List<Person> getAll() {
        List<Person> list = new ArrayList();

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person LIMIT 50;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }

    public String getName() {
        return sqlCon.getName();
    }

    public List<Person> getAllPersonsDepthOne(String name) {
        List<Person> list = new ArrayList();

        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person a JOIN  (select * FROM chinook.endorsement e JOIN chinook.person p ON e.source_node_id = p.id WHERE p.name='" + name + "') b ON a.id=b.target_node_id LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthTwo(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person WHERE id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement e JOIN chinook.person p ON e.source_node_id = p.id WHERE p.name = '" + name + "')) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthTwo" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthThree(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person WHERE id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement e JOIN chinook.person p ON e.source_node_id = p.id WHERE p.name = '" + name + "'))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthThree" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthFour(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person WHERE id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement e JOIN chinook.person p ON e.source_node_id = p.id WHERE p.name = '" + name + "')))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);

            list = this.getResults(res);

        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFour" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthFive(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.sqlCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM chinook.person WHERE id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement WHERE source_node_id IN (SELECT target_node_id FROM chinook.endorsement e JOIN chinook.person p ON e.source_node_id = p.id WHERE p.name = '" + name + "'))))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);

            list = this.getResults(res);

        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFive" + e.toString());
        }
        return list;
    }

    private List<Person> getResults(ResultSet res) throws SQLException {
        List<Person> list = new ArrayList();
        while (res.next()) {
            String id = res.getString("id");
            String name = res.getString("name");
            String job = res.getString("job");
            String bday = res.getString("birthday");
            Person p = new Person(id, name, job, bday);
            list.add(p);
        }
        return list;
    }
}
