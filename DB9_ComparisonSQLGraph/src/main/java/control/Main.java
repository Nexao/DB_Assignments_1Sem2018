package control;

import cjs.db_assignment.model.Depth;
import data.*;
import java.util.List;
import java.util.Random;
import model.Person;

public class Main {

    private static List<Depth> sqlRes;
    private static List<Depth> graphRes;

    public static void main(String[] args) throws Exception {
        DataAccessSQL sqlCon = new DataAccessSQL(new DBConnectorSQL());
        DataAccessGraph graphCon = new DataAccessGraph(new DBConnectorGraph());
//        List<Person> dOnePersons = graphCon.getAll();
//        List<Person> dOnePersons = sqlCon.getAll();

//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("A. ALL PERSONS THAT A PERSON ENDORSES, I.E., ENDORSEMENTS OF DEPTH ONE.");
//        System.out.println("-----------------------------------------------------------------------");
////        List<Person> dOnePersons = sqlCon.getAllPersonsDepthOne("Patrice Gula");
//        for (Person dOnePerson : dOnePersons) {
//            printPerson(dOnePerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("B. ALL PERSONS THAT ARE ENDORSED BY ENDORSED PERSONS OF A PERSON, I.E., ENDORSEMENTS OF DEPTH TWO.");
//        System.out.println("-----------------------------------------------------------------------");
//        List<Person> dTwoPersons = sqlCon.getAllPersonsDepthTwo("Patrice Gula");
//        for (Person dTwoPerson : dTwoPersons) {
//            printPerson(dTwoPerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("C. ENDORSEMENTS OF DEPTH OF THREE");
//        System.out.println("-----------------------------------------------------------------------");
//        List<Person> dThreePersons = sqlCon.getAllPersonsDepthThree("Patrice Gula");
//        for (Person dThreePerson : dThreePersons) {
//            printPerson(dThreePerson);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("D. ENDORSEMENTS OF DEPTH OF FOUR");
//        System.out.println("-----------------------------------------------------------------------");
//        List<Person> d4Persons = sqlCon.getAllPersonsDepthFour("Patrice Gula");
//        for (Person d4Person : d4Persons) {
//            printPerson(d4Person);
//        }
//
//        System.out.println("-----------------------------------------------------------------------");
//        System.out.println("E. ENDORSEMENTS OF DEPTH OF FIVE");
//        System.out.println("-----------------------------------------------------------------------");
//        List<Person> d5Persons = sqlCon.getAllPersonsDepthFive("Patrice Gula");
//        for (Person d5Person : d5Persons) {
//            printPerson(d5Person);
//        }

        List<Person> randomFromGraph = graphCon.get20RandomIndexes();
        for (Person dOnePerson : randomFromGraph) {
            printPerson(dOnePerson);
        }
        
        List<Person> randomFromSQL = null;
        Random generator = new Random();
            for (int i = 0; i < 20; i++) {

                int index = generator.nextInt(5000000);
                System.out.println("INDEX" + index);
                Person p = sqlCon.getRandom(index);
                if(p != null){
                    randomFromSQL.add(p);
                   
                }else{
                     i = i-1;
                }

}
        
        for (Person dOnePerson : randomFromSQL) {
            printPerson(dOnePerson);
        }
    }

    private static void display() {

        String format = "%-20s%-20s%-20s%-20s%-20s\n";
        System.out.printf("%-35s%-20s%-20s\n", "", "PostGreSQL", "Neo4J");
        for (int i = 0; i < 5; i++) {
            String prefix = "Depth " + sqlRes.get(i).getName() + ":";
            System.out.printf(format, prefix, sqlRes.get(i).getAve(), sqlRes.get(i).getMed(), graphRes.get(i).getAve(), graphRes.get(i).getMed());
        }

    }

    private static void printPerson(Person p) {
        String format = "%-15s%-30s%-40s%-20s\n";
        System.out.printf(format, p.getId(), p.getName(), p.getJob(), p.getBirthday());
    }

}
