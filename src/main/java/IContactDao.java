/**
 * Created by Asouphie on 20/09/2017.
 */
public interface IContactDao {
    public void creerContact(Contact contact);
    public boolean isContactExist(String nom);
    public Contact recupererContact(String nom);
    public void supprimerContact(String nom);
}
