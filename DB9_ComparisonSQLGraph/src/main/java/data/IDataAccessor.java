package data;

import java.util.List;
import model.Person;

public interface IDataAccessor {

    public List<Person> getAllPersonsDepthOne(String name);

    public List<Person> getAllPersonsDepthTwo(String name);

    public List<Person> getAllPersonsDepthThree(String name);

    public List<Person> getAllPersonsDepthFour(String name);

    public List<Person> getAllPersonsDepthFive(String name);

    public String getName();
}
