/**
 * Created by Asouphie on 20/09/2017.
 */
public class Contact {

    /**
     * Le nom du contact.
     */
    private String nom;
    /**
     * Le numero du contact.
     */
    private String tel;

    /**
     * Construction de l'objet contact.
     * @param sonNom - le nom du contact
     * @param sonTel - le numero du contact
     */

    public Contact(final String sonNom, final String sonTel) {
        this.nom = sonNom;
        this.tel = sonTel;
    }

    /**
     * Accesseur du nom.
     * @return le nom
     */

    public String getNom() {
        return this.nom;
    }

    /**
     * Modificateur du nom.
     * @param newNom - nouveau nom
     */

    public void setNom(final String newNom) {
        this.nom = newNom;
    }

    /**
     * Accesseur du numero.
     * @return le numero.
     */

    public String getTel() {
        return this.tel;
    }

    /**
     * Modificateur du numero.
     * @param newTel - nouveau numero de telephone
     */

    public void setTel(final String newTel) {
        this.tel = newTel;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact contact = (Contact) o;

        if ((nom != null) ? !nom.equals(contact.nom) : (contact.nom != null)) {
            return false;
        }

        return (tel != null) ? tel.equals(contact.tel) : (contact.tel == null);
    }
}
