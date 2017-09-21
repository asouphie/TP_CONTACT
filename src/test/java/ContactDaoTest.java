import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactDaoTest {

    @Test
    public void isContactExist() throws Exception {
        ContactDao contactDao = new ContactDao();
        contactDao.creerContact(new Contact("contact1", "06-72-94-72-64"));
        contactDao.creerContact(new Contact("contact2", "06-72-94-72-64"));
        contactDao.creerContact(new Contact("contact3", "06-72-94-72-64"));
        //TEST : DEMANDE D'UN CONTACT DEJA EXISTANT
        Assert.assertTrue(contactDao.isContactExist("contact1"));
        //TEST : DEMANDE D'UN CONTACT PAS EXISTANT ENCORE
        Assert.assertFalse(contactDao.isContactExist("contact0"));
    }

    @Test
    public void recupererContact() throws Exception {
        ContactDao contactDao = new ContactDao();
        contactDao.creerContact(new Contact("contact1", "06-72-94-72-64"));
        contactDao.creerContact(new Contact("contact2", "06-72-94-72-64"));
        contactDao.creerContact(new Contact("contact3", "06-72-94-72-64"));
        //TEST : DEMANDE D'UN CONTACT DEJA EXISTANT
        Assert.assertEquals(contactDao.recupererContact("contact1"), new Contact("contact1", "06-72-94-72-64"));
        //TEST : DEMANDE D'UN CONTACT PAS EXISTANT ENCORE
        Assert.assertEquals(contactDao.recupererContact("contact0"), null);
    }
}