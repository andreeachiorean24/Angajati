package UI;


import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import Domain.Angajat;
import Service.Service;
import java.util.Comparator;
import java.util.Objects;

public class Ui {
    private Service service;
    private Scanner scanner;

    public Ui(Service s) {
        this.service = s;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int alegere;
        while (true) {
            optiuni();
            System.out.println("Optiunea: ");
            alegere = scanner.nextInt();
            scanner.nextLine();
            switch (alegere) {
                case 1 -> System.out.println(cautareAngajat());
                case 2 -> filtrarePost();
                case 3 -> filtrarePostSalariu();
                case 4 -> sortNumePrenume();
                case 5 -> sortPost();
                case 6 -> sortSalariu();

            }
        }
    }


    private void optiuni() {
        System.out.println("1.Cautarea angajatului 'Ionescu Paul'");
        System.out.println("2.Filtrarea angajatilor cu postul 'programator'");
        System.out.println("3.Filtrarea angajatilor cu postul 'programator'si salariu >5000");
        System.out.println("4.Sortare nume si prenume, alfabetic, descrescator");
        System.out.println("5.Sortare post crescator");
        System.out.println("6.Sortare salariu descrescator");

    }


    private String citire(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    private String cautareAngajat()
    {
        String nume=citire("Nume:");
        String prenume=citire("Prenume:");

        List<Angajat> angajatilist=service.getListAngajati();
        for(int i=0;i<angajatilist.size();i++)
        {
            if(angajatilist.get(i).getNume().equals(nume) && angajatilist.get(i).getPrenume().equals(prenume))
            {
                return angajatilist.get(i).toString();
            }
        }
        return "nu exista";
    }

    private void filtrarePost()
    {
        List<Angajat> angajatiList=service.getListAngajati();
        List<Angajat> filtered_list = (List)angajatiList.stream().filter((s)->{
            return s.getPost().equals("programator");
        }).collect(Collectors.toList());

        System.out.println(filtered_list);
    }

    private void filtrarePostSalariu(){

        List<Angajat> angajatilist=service.getListAngajati();
        List<Angajat> filtered_list = (List)angajatilist.stream().filter((s) ->{
            return s.getPost().equals("programator");
        }).collect(Collectors.toList());
        List<Angajat> filtered_list1 = (List)filtered_list.stream().filter((s) ->{
            return s.getSalariu() > 5000.0;
        }).collect(Collectors.toList());
        System.out.println(filtered_list1);

        System.out.println();
    }

    private void sortNumePrenume()
    {
        List<Angajat> lista =service.getListAngajati();

        List<Angajat> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Angajat::getPrenume).reversed().thenComparing(Angajat::getNume).reversed()).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {
            Long var1 = s.getId();
            return "" + var1 + "  " + s.getNume() + "  " + s.getPrenume();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

    private void sortPost()
    {
        List<Angajat> lista =service.getListAngajati();

        List<Angajat> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Angajat::getPost)).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {

            return "" + s.getNume()+ " " + s.getPrenume() + " " + s.getPost();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }

    private void sortSalariu()
    {
        List<Angajat> lista =service.getListAngajati();

        List<Angajat> sorted_list = (List)lista.stream().sorted(Comparator.comparing(Angajat::getSalariu).reversed()).collect(Collectors.toList());
        Stream var =sorted_list.stream().map((s) -> {

            Long var1 = s.getId();
            return "" + var1 + " " + s.getSalariu();
        });

        PrintStream var11 = System.out;
        Objects.requireNonNull(var11);
        var.forEach(var11::println);
        System.out.println();
    }



}