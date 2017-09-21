/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactService {
    /**
     * attribut contactDao permettant d'avoir accès à la base de données.
     */
    private IContactDao contactDao;

    /**
     * Construction de l'objet contactService.
     */
    public ContactService() {
        contactDao = new ContactDao();
    }

    /**
     * CMéthode permettant de créer un contact
     * via son nom et son numéro de téléphone.
     * @param nom - nom du contact
     * @param tel - numéro du contact
     * @throws Exception - Exception si le nom est null,
     * trop court ou trop long et si le contact existe déjà
     */
    public void creerContact(final String nom, final String tel)
            throws Exception {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if (nom.length() < 3 || nom.length() > 40) {
            throw new IllegalArgumentException("La longueur "
                    + "du nom doit être de 3 à 40 caractères.");
        }
        if (contactDao.isContactExist(nom)) {
            throw new IllegalArgumentException("Le nom doit être unique.");
        }
        Contact contact = new Contact(nom, tel);
        contactDao.creerContact(contact);
    }

    /**
     * Méthode permettant de supprimer un contact via son nom.
     * @param nom - nom du contact à supprimer
     * @throws Exception - Exception si le nom est null,
     * trop court ou trop long et si le contact n'existe pas
     */

    public void supprimerContact(final String nom) throws Exception {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if (nom.length() < 3 || nom.length() > 40) {
            throw new IllegalArgumentException("La longueur du"
                    + "nom doit être de 3 à 40 caractères.");
        }
        if (!contactDao.isContactExist(nom)) {
            throw new IllegalArgumentException("Aucuns contacts"
                    + "ne porte ce nom : '" + nom + "'.");
        }
        if (!contactDao.supprimerContact(nom)) {
            throw new IllegalArgumentException("Impossible"
                    + "de supprimer le contact.");
        }
    }
}
