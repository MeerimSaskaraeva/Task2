package dao;

import model.Animal;
import model.Person;

import java.util.List;

public class Database {
    private List<Person> person;
    private List<Animal> animal;

    public Database(List<Person> person, List<Animal> animal) {
        this.person = person;
        this.animal = animal;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Database{" +
                "person=" + person +
                ", animal=" + animal +
                '}';
    }
}
