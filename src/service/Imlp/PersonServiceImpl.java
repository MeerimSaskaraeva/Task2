package service.Imlp;

import dao.Database;
import gender.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {
    List<Person> personList = new ArrayList<>();
    List<Animal> animalList = new ArrayList<>();
    Database database = new Database(personList, animalList);

    @Override
    public String add(List<Person> t) {
        this.personList.addAll(t);

        return "Add all person";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String removeByName(String name) {

        for (Person person : personList) {
            if (person.getName().equals(name)) {
                personList.remove(person);

                return "Person remove ";
            }

        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public List<Person> sortByName() {

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Person> comparator2 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };
       personList.sort(comparator2);

        return personList;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person> personFemale = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Write gender");
        String gender = sc.next().toUpperCase();
        for (Person person : personList) {
            if (person.getGender().equals(Gender.valueOf(gender))) {
                personFemale.add(person);
            } else if (person.getGender().equals(Gender.valueOf(gender))) {
                personFemale.add(person);
            }
        }
        return personFemale;
    }

    @Override
    public List<Person> clear() {
        personList.clear();
        System.out.println(personList);
        return personList;
    }
}
