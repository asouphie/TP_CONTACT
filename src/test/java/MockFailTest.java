import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Asouphie on 20/09/2017.
 */
public class MockFailTest extends MockTest {

    @TestSubject
    private ContactService service = new ContactService();

    @Mock
    private IContactDao dao;

    @Test (expected = IllegalArgumentException.class)
    public void testCreerContactCasPasValide() throws Exception {
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        String tel = "06-75-84-91-96";
        EasyMock.expect(dao.isContactExist(nom)).andReturn(true);

        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.creerContact(nom, tel);

        //Verification
        verifyAll();
    }

    @Test
    public void testCreerContactCasValide() throws Exception {
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        String tel = "06-75-84-91-96";
        EasyMock.expect(dao.isContactExist(nom)).andReturn(false);
        Capture<Contact> capture = EasyMock.newCapture();
        dao.creerContact(EasyMock.capture(capture));

        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.creerContact(nom, tel);

        //Verification
        verifyAll();
        Contact contact = capture.getValue();
        Assert.assertEquals(nom, contact.getNom());
        Assert.assertEquals(tel, contact.getTel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSupprimerContactCasNomExistePas() throws Exception {
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        String tel = "06-75-84-91-96";
        EasyMock.expect(dao.isContactExist(nom)).andReturn(false);

        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.supprimerContact(nom);

        //Verification
        verifyAll();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSupprimerContactNonValide() throws Exception {
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        EasyMock.expect(dao.isContactExist(nom)).andReturn(true);
        EasyMock.expect(dao.supprimerContact(nom)).andReturn(false);

        //Fin de l'enregistrement
        replayAll();

        //Appel de la méthode
        service.supprimerContact(nom);

        //Verification
        verifyAll();
    }
}
