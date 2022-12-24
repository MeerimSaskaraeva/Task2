package service.Imlp;

import dao.Database;
import gender.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnimalServiceImpl implements GenericService<Animal> {
    List<Person> personList = new ArrayList<>();
    List<Animal> animalList = new ArrayList<>();
    Database database = new Database(personList, animalList);

    @Override
    public String add(List<Animal> t) {
        this.animalList.addAll(t);
        return "Add all animal";
    }

    @Override
    public Animal getById(Long id) {

        List<Animal> animalList1 = animalList.stream().filter(animal -> animal.getId() == id).toList();
        animalList1.forEach(System.out::println);

        return  null;
    }

    @Override
    public String removeByName(String name) {
        System.out.println(animalList.removeIf(animal -> animal.getName().equals(name)));
        return "Remove animal";
    }

    @Override
    public List<Animal> getAll() {

        return animalList;
    }

    @Override
    public List<Animal> sortByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write 1= ac, or 2=dec");
        if (sc.nextInt() == 1) {
            List<Animal> sorted = animalList.stream().sorted(Comparator.comparing(Animal::getName)).toList();
            return sorted;
        } else {
            List<Animal> sorted = animalList.stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();

            return sorted;
        }
    }

    @Override
    public List<Animal> filterByGender() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose gender: ");
        String g = sc.next().toUpperCase();
        if (g.equals("FEMALE")) {
            return animalList.stream().filter(animal -> animal.getGender().equals(Gender.valueOf(g))).toList();
        } else {

            return animalList.stream().filter(animal -> animal.getGender().equals(Gender.valueOf(g))).toList();
        }

    }

    @Override
    public List<Animal> clear() {
        animalList.clear();
        System.out.println(animalList);
        return animalList;
    }
}
