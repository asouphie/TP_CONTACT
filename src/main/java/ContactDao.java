import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactDao implements IContactDao {

    /**
     * Liste des contacts.
     */
    private List<Contact> listContact;

    /**
     * Construction de l'objet contactDAO.
     */
    public ContactDao() {
        listContact = new ArrayList<>();
    }

    /**
     * Méthode permettant de créer un contact,
     * donc de l'ajouter à la liste de contacts.
     * @param contact - le contact à ajouter
     */
    public void creerContact(final Contact contact) {
        if (contact != null) {
            listContact.add(contact);
        }
    }

    /**
     * Méthode permettant de savoir si un contact existe déjà,
     * par rapport à son nom.
     * @param nom - le nom du contact à trouver
     * @return vrai si le contact existe, sinon faux
     */
    public boolean isContactExist(final String nom) {
        if (recupererContact(nom) != null) {
            return true;
        }
        return false;
    }

    /**
     * Methode permettant de récupérer un contact via son nom.
     * @param nom - nom du contact à récupérer
     * @return le contact rechercher. Si pas trouvé retourne null.
     */
    public Contact recupererContact(final String nom) {
        if (!nom.isEmpty()) {
            for (Contact contact : listContact) {
                if (nom.equals(contact.getNom())) {
                    return contact;
                }
            }
        }
        return null;
    }

    /**
     * Methode permettant de supprimer un contact
     * de la liste des contacts, via son nom.
     * @param nom - nom du contact à supprimer
     * @return vrai si le contact a été supprimer. Sinon faux.
     */
    public boolean supprimerContact(final String nom) {
        if (!nom.isEmpty()) {
            for (Contact contact : listContact) {
                if (nom.equals(contact.getNom())) {
                    listContact.remove(contact);
                    return true;
                }
            }
        }
        return false;
    }
}
