package model;

public class Person {

    String id, name, job, birthday;
    public Person (String id, String name, String job, String bday){
        this.id = id;
        this.name = name;
        this.job = job;
        this.birthday = bday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
