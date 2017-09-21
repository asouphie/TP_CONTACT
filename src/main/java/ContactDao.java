import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactDao implements IContactDao {

    private List<Contact> listContact;

    public ContactDao() {
        listContact = new ArrayList<>();
    }

    public void creerContact(Contact contact) {
        if(contact != null) {
            listContact.add(contact);
        }
    }

    public boolean isContactExist(String nom) {
        if(recupererContact(nom) != null) {
            return true;
        }
        return false;
    }

    public Contact recupererContact(String nom) {
        if(!nom.isEmpty()) {
            for(Contact contact : listContact) {
                if(nom.equals(contact.getNom())) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void supprimerContact(String nom) {
        //TODO
    }
}
