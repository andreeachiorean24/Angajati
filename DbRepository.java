package Repository;
import Domain.Angajat;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbRepository {
    private String url;
    private String username;
    private String password;

    public DbRepository(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Iterable<Angajat> findAll() {
        Set<Angajat> users = new HashSet<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("SELECT * from angajat");
            ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String post=resultSet.getString("post");
                Double salariu=resultSet.getDouble("salariu");

                Angajat angajat = new Angajat(id,nume, prenume,post,salariu);
                angajat.setId(id);
                users.add(angajat);
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
}
