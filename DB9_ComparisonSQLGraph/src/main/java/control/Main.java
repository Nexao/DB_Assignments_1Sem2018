package control;

import cjs.db_assignment.model.Depth;
import data.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Person;

public class Main {

    private static ArrayList<Double> sqlResTime = new ArrayList<Double>();
    private static ArrayList<Double> graphResTime = new ArrayList<Double>();
    private static Timer timer = new Timer();

    public static void main(String[] args) throws Exception {
        DataAccessSQL sqlCon = new DataAccessSQL(new DBConnectorSQL());
//        DataAccessGraph graphCon = new DataAccessGraph(new DBConnectorGraph());
//        List<Person> dOnePersons = graphCon.getAll();
        List<Person> persons = sqlCon.getAll();

//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("A. ALL PERSONS THAT A PERSON ENDORSES, I.E., ENDORSEMENTS OF DEPTH ONE.");
//        System.out.println("-----------------------------------------------------------------------");
        timer.resetTime();
        List<Person> dOnePersons = sqlCon.getAllPersonsDepthOne("Patrice Gula");
        double time1 = timer.elapsedTime();
        sqlResTime.add(time1);
        
//         timer.resetTime();
//        List<Person> dOnePersons1 = graphCon.getAllPersonsDepthOne("Patrice Gula");
//        double time01 = timer.elapsedTime();
//        graphResTime.add(time01);
//        for (Person dOnePerson : dOnePersons1) {
//            printPerson(dOnePerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("B. ALL PERSONS THAT ARE ENDORSED BY ENDORSED PERSONS OF A PERSON, I.E., ENDORSEMENTS OF DEPTH TWO.");
//        System.out.println("-----------------------------------------------------------------------");
        timer.resetTime();
        List<Person> dTwoPersons = sqlCon.getAllPersonsDepthTwo("Patrice Gula");
        double time2 = timer.elapsedTime();
        sqlResTime.add(time2);
        
//        timer.resetTime();
//        List<Person> dTwoPersons1 = graphCon.getAllPersonsDepthTwo("Patrice Gula");
//        double time02 = timer.elapsedTime();
//        graphResTime.add(time02);
//        for (Person dTwoPerson : dTwoPersons) {
//            printPerson(dTwoPerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("C. ENDORSEMENTS OF DEPTH OF THREE");
//        System.out.println("-----------------------------------------------------------------------");
        timer.resetTime();
        List<Person> dThreePersons = sqlCon.getAllPersonsDepthThree("Patrice Gula");
        double time3 = timer.elapsedTime();
        sqlResTime.add(time3);
        
//        timer.resetTime();
//        List<Person> dThreePersons1 = graphCon.getAllPersonsDepthThree("Patrice Gula");
//        double time03 = timer.elapsedTime();
//        graphResTime.add(time03);
//        for (Person dThreePerson : dThreePersons) {
//            printPerson(dThreePerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("D. ENDORSEMENTS OF DEPTH OF FOUR");
//        System.out.println("-----------------------------------------------------------------------");
        timer.resetTime();
        List<Person> d4Persons = sqlCon.getAllPersonsDepthFour("Patrice Gula");
        double time4 = timer.elapsedTime();
        sqlResTime.add(time4);
        
//        timer.resetTime();
//        List<Person> d4Persons1 = graphCon.getAllPersonsDepthFour("Patrice Gula");
//        double time04 = timer.elapsedTime();
//        graphResTime.add(time04);
//        for (Person d4Person : d4Persons) {
//            printPerson(d4Person);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("E. ENDORSEMENTS OF DEPTH OF FIVE");
//        System.out.println("-----------------------------------------------------------------------");
        timer.resetTime();
        List<Person> d5Persons = sqlCon.getAllPersonsDepthFive("Patrice Gula");
        double time5 = timer.elapsedTime();
        sqlResTime.add(time5);
        
//        timer.resetTime();
//        List<Person> d5Persons1 = graphCon.getAllPersonsDepthFive("Patrice Gula");
//        double time05 = timer.elapsedTime();
//        graphResTime.add(time05);
//        for (Person d5Person : d5Persons1) {
//            printPerson(d5Person);
//        }

//        List<Person> randomFromGraph = graphCon.get20RandomIndexes();
//        System.out.println("------------------20 RANDOM USING GRAPH - NEO4J------------------");
//        for (Person dOnePerson : randomFromGraph) {
//            printPerson(dOnePerson);
//        }

        List<Person> randomFromSQL = new ArrayList<Person>();
        Random generator = new Random();
        for (int i = 0; i < 20; i++) {

            int index = generator.nextInt(persons.size() - 1);
//            System.out.println("INDEX" + index);
//                Person p = sqlCon.getRandom(index);
            Person p = new Person(persons.get(index).getId(), persons.get(index).getName(), persons.get(index).getJob(), persons.get(index).getBirthday());
            randomFromSQL.add(p);

        }
        System.out.println("------------------20 RANDOM USING SQL - POSTGRESQL------------------");
        for (Person dOnePerson : randomFromSQL) {
            printPerson(dOnePerson);
        }
        
        
        display();
        
    }

    private static void display() {

        String format = "%-20s%-20s%-20s\n";
//        System.out.printf("%-35s%-20s%-20s\n", "", "PostGreSQL", "Neo4J");
        System.out.printf("%-20s%-20s%-20s\n", "", "PostGreSQL Time", "Neo4J Time");
        
        String[] depthsname = new String[5];
        depthsname[0] = "one";
        depthsname[1] = "two";
        depthsname[2] = "three";
        depthsname[3] = "four";
        depthsname[4] = "five";
        
        DepthMeasure mes = new DepthMeasure();
        double ave1 = mes.getAverage(sqlResTime);
        
        for (int i = 0; i < 5; i++) {
            String prefix = "Depth " + depthsname[i];
            System.out.printf(format, prefix, sqlResTime.get(i), graphResTime.get(i));
        }

    }

    private static void printPerson(Person p) {
        String format = "%-15s%-30s%-40s%-20s\n";
        System.out.printf(format, p.getId(), p.getName(), p.getJob(), p.getBirthday());
    }

}
