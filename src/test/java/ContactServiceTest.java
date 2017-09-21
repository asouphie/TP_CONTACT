import org.junit.Test;

/**
 * Created by Asouphie on 20/09/2017.
 */
public class ContactServiceTest {
    @Test (expected = IllegalArgumentException.class)
    public void creerContactAvecDeuxChar() throws Exception {
        ContactService contactService = new ContactService();
        contactService.creerContact("cd", "05-78-46-13-98");
    }

    @Test (expected = IllegalArgumentException.class)
    public void creerContactAvecQuaranteEtUnChar() throws Exception {
        ContactService contactService = new ContactService();
        contactService.creerContact("cdregdcsfmpetdlfrpimentrezaropdfmtsqpoirt", "05-78-46-13-98");
    }

    @Test
    public void creerContactAvecTroisChar() throws Exception {
        ContactService contactService = new ContactService();
        contactService.creerContact("cdR", "05-78-46-13-98");
    }

    @Test
    public void creerContactAvecQuaranteChar() throws Exception {
        ContactService contactService = new ContactService();
        contactService.creerContact("cdP", "05-78-46-13-98");
    }

    @Test (expected = IllegalArgumentException.class)
    public void creerContactDejaExistant() throws Exception {
        ContactService contactService = new ContactService();
        contactService.creerContact("cdR", "05-78-46-13-98");
        contactService.creerContact("cdR", "05-78-46-13-98");
    }
}