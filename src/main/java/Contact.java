/**
 * Created by Asouphie on 20/09/2017.
 */
public class Contact {

    private String nom;
    private String tel;

    public Contact(String nom, String tel) {
        this.nom = nom;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (nom != null ? !nom.equals(contact.nom) : contact.nom != null) return false;
        return tel != null ? tel.equals(contact.tel) : contact.tel == null;
    }
}
