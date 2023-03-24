package Domain;

public class Angajat {
    long id;
    String nume;
    String prenume;
    String post;
    Double salariu;

    public Angajat(long id, String nume, String prenume, String post, Double salariu){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.post = post;
        this.salariu = salariu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }

    public String toString()
    {
        return "Student{"+"id="+getId()+'\''+"nume="+ getNume()+'\''+"prenume="+ getPrenume()+'\''+"post="+ getPost()+'\''+"salariu="+ getSalariu()+"}";
    }
}
