package data;

import model.Person;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import java.util.ArrayList;
import java.util.List;

public class DataAccessGraph{
    private DBConnectorGraph graphCon;

    public DataAccessGraph(DBConnectorGraph graphCon) {
        this.graphCon = graphCon;
    }
    
    public List get20RandomIndexes() {
        List<Person> list = new ArrayList<Person>();
        Driver driver = graphCon.getInstance();
        Session session = driver.session();
        StatementResult result = session.run(
                "MATCH(a:Person) WITH a, rand() AS number RETURN a.name as name, a.job as job, a.birthday as birthday ORDER BY number LIMIT 20");

        list = getResults(result);
        session.close();
        graphCon.closeDriver();
        System.out.println("DONE");

        return list;

}
    
    public List<Person> getAll() {
        List<Person> list = new ArrayList();

        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH (n) RETURN n.name as name, n.job as job, n.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);
            list = getResults(result);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthOne(String person) {
        List<Person> list = new ArrayList();

        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH ({name:\""+person+"\"})-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);
            list = getResults(result);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }

    public List<Person> getAllPersonsDepthTwo(String person) {
        List<Person> list = new ArrayList();

        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH ({name:\""+person+"\"})-[:ENDORSES]->()-[:ENDORSES]->(other_other) RETURN other_other.name as name, other_other.job as job, other_other.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);
            list = getResults(result);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthTwo" + e.toString());
        }
        return list;
    }


    public List<Person> getAllPersonsDepthThree(String person) {
        List<Person> list = new ArrayList();

        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH ({name:\""+person+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);
            list = getResults(result);
            session.close();

        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthThree" + e.toString());
        }
        return list;

    }

    public List<Person> getAllPersonsDepthFour(String person) {
        List<Person> list = new ArrayList();
        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH ({name:\""+person+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);

            list = getResults(result);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFour" + e.toString());
        }
        return list;
    }


    public List<Person> getAllPersonsDepthFive(String person) {
        List<Person> list = new ArrayList();

        try {
            Driver driver = graphCon.getInstance();
            String query = "MATCH ({name:\""+person+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
            Session session = driver.session();
            StatementResult result = session.run(query);
            list = getResults(result);
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFive" + e.toString());
        }
        return list;
    }

    public String getName() {
        return this.graphCon.getName();
    }

    private List<Person> getResults(StatementResult res) {
        List<Person> list = new ArrayList();
        while (res.hasNext()) {
            Record record = res.next();
                String id = record.get("id").asString();
                String name = record.get("name").asString();
                String job = record.get("job").asString();
                String bday = record.get("birthday").asString();
                
//                System.out.println("HERE:..." + name);
                Person p = new Person(id, name, job, bday);
                list.add(p);
            }
        return list;
    }

    public void close() {
        Driver driver = graphCon.getInstance();
        driver.close();

    }


}