package org.example;

import Repository.DbRepository;
import Service.Service;
import UI.Ui;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/angajat";
        String user="postgres";
        String parola="And1informatica";

        Service service = new Service(new DbRepository(url,user,parola));
        Ui ui = new Ui(service);
        ui.start();
    }
}