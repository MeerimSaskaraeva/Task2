import dao.Database;
import gender.Gender;
import model.Animal;
import model.Person;
import service.Imlp.AnimalServiceImpl;
import service.Imlp.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal animal1=new Animal(1,"Dog",2, Gender.MALE);
        Animal animal2=new Animal(2,"Cat",3, Gender.FEMALE);
        Animal animal3=new Animal(3,"Horse",4, Gender.MALE);
        Animal animal4=new Animal(4,"Mouse",1, Gender.MALE);
        Animal animal5=new Animal(5,"Some",6, Gender.FEMALE);

        Person person1=new Person(1,"Asan",23,Gender.MALE);
        Person person2=new Person(2,"Meerim",39,Gender.FEMALE);
        Person person3=new Person(3,"Uson",25,Gender.MALE);
        Person person4=new Person(4,"Asel",32,Gender.FEMALE);
        Person person5=new Person(5,"Nuric",20,Gender.MALE);

        List<Animal>animalList=new ArrayList<>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);

        List<Person>personList=new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);


        AnimalServiceImpl animalService=new AnimalServiceImpl();
        PersonServiceImpl personService=new PersonServiceImpl();

        while (true){
            Scanner sc=new Scanner(System.in);
            int r= sc.nextInt();
            switch (r){
                case 1-> System.out.println(animalService.add(animalList));
                case 2-> animalService.getAll().forEach(System.out::println);
                case 3-> {
                    System.out.println("Write ID: ");
                    long id= sc.nextLong();
                    System.out.println(animalService.getById(id));
                }
                case 4-> {
                    System.out.println("Write name: ");
                    String name= sc.next();
                    System.out.println(animalService.removeByName(name));
                }
                case 5-> animalService.sortByName().forEach(System.out::println);
                case 6-> animalService.filterByGender().forEach(System.out::println);
                case 7-> animalService.clear().forEach(System.out::println);


                case 8-> System.out.println(personService.add(personList));
                case 9-> personService.getAll().forEach(System.out::println);
                case 10-> {
                    System.out.println("Write ID");
                    long id= sc.nextLong();
                    System.out.println(personService.getById(id));
                }
                case 11->{
                    System.out.println("Write name: ");
                    String name= sc.next();
                    System.out.println(personService.removeByName(name));
                }
                case 12-> personService.sortByName().forEach(System.out::println);
                case 13-> personService.filterByGender().forEach(System.out::println);
                case 14-> personService.clear().forEach(System.out::println);

            }

        }


    }
}