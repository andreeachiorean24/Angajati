package Service;


import Domain.Angajat;
import Repository.DbRepository;

import java.util.ArrayList;
import java.util.List;

public class Service {
    DbRepository repoAngajat;


    public Service(DbRepository repoAngajat){
        this.repoAngajat =repoAngajat;
    }

    public Iterable<Angajat> getAll(){
        return repoAngajat.findAll();
    }


    public List<Angajat> getListAngajati(){
        Iterable<Angajat> utilizatorIterable = repoAngajat.findAll();
        List<Angajat> listaAngajatilor = new ArrayList<>();
        utilizatorIterable.forEach(listaAngajatilor::add);
        return listaAngajatilor;
    }

}


