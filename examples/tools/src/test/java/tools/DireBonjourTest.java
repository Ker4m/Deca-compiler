package tools;

import static org.junit.Assert.*;
import org.junit.Test;

public class DireBonjourTest {

    @Test
    public void testMessage() {
        DireBonjour direBonjour = new DireBonjour();
        // A_FAIRE : le test suivant échoue (chiffre 0 à la place du caractère o)
        // A_FAIRE : Vérifier qu'il échoue, corrigez, puis relancez les tests
        assertEquals("Bonjour", direBonjour.getMessage());

        // A_FAIRE : tester aussi direBonjour.getOtherMessage()
        // A_FAIRE : il suffit de décommenter les lignes suivantes.
        assertEquals("Au revoir", direBonjour.getOtherMessage());
        assertEquals("Bonjour\nAu revoir", direBonjour.getBothMessages());
    }

}
