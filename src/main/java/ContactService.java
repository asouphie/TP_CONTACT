/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactService {

    private IContactDao contactDao;

    public ContactService() {
        contactDao = new ContactDao();
    }

    public void creerContact(String nom, String tel) throws Exception {
        if(nom == null) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if(nom.length() < 3 || nom.length() > 40) {
            throw new IllegalArgumentException("La longueur du nom doit être de 3 à 40 caractères.");
        }
        if(contactDao.isContactExist(nom)) {
            throw new IllegalArgumentException("Le nom doit être unique.");
        }
        Contact contact = new Contact(nom, tel);
        contactDao.creerContact(contact);
    }

    public void supprimerContact(String nom) throws Exception {
        if(nom == null) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if(nom.length() < 3 || nom.length() > 40) {
            throw new IllegalArgumentException("La longueur du nom doit être de 3 à 40 caractères.");
        }
        if(!contactDao.isContactExist(nom)) {
            throw new IllegalArgumentException("Aucuns contacts ne porte ce nom : '" + nom + "'.");
        }
        contactDao.supprimerContact(nom);
    }
}
