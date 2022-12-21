package service.Imlp;

import dao.Database;
import gender.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements GenericService <Person>{
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
            if (person.getId()==id){
                return person;
            }

        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        List<Person>personList1=new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().equals(name)){

                personList1.add(person);
                personList1.remove(person);

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
        for (Person person : personList) {
           person.getName().contains("A");

        }
        return null;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person>personFemale=new ArrayList<>();
        List<Person>personMale=new ArrayList<>();


        for (Person person : personList) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Write gender");
            String gender= sc.next();
            if (person.getGender().equals(Gender.valueOf(gender))){
                personFemale.add(person);
                return personFemale;
            }
            else {
                personFemale.add(person);
                return personMale;
            }
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        personList.clear();
        return personList;
    }
}
