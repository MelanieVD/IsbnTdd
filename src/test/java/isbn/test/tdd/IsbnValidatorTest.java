package isbn.test.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IsbnValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1491926309","2100825208"})
    public void verifierSiIsbnEstValide(String isbnAVerifier){

        IsbnValidator isbnValidator;
        boolean resultat;

        Given:
        isbnValidator = new IsbnValidator();

        When:
        resultat = isbnValidator.verifierIsbn(isbnAVerifier);

        Then:
        assertTrue(resultat,"Le numéro ISBN "+ isbnAVerifier + "est valide");
    }

    @Test
    public void verifierSiIsbnEstInvalide(){

        IsbnValidator isbnValidator;
        boolean resultat;

        Given:
        isbnValidator = new IsbnValidator();

        When:
        resultat = isbnValidator.verifierIsbn("1491926308");

        Then:
        assertFalse(resultat, "Le numéro ISBN est invalide");

    }
    @Test
    public void isbnPeutTerminerParX(){
        IsbnValidator isbnValidator;
        boolean resultat;

        Given:
        isbnValidator = new IsbnValidator();

        When:
        resultat = isbnValidator.verifierIsbn("043942089X");

        Then:
        assertTrue(resultat, "Le numéro ISBN est valide");
    }

    @ParameterizedTest
    @ValueSource(strings = {"149192630", "14919263091"})
    @DisplayName("Le numéro ISBN doit être composé de 10 caractères.")
    public void isbnNePeutPasEtrePlusLongQueDix(String isbnAVerifier){
        IsbnValidator isbnValidator;
        String isbn;

        Given:
        isbnValidator = new IsbnValidator();

        When:
        isbn = isbnAVerifier;

        Then:
        assertThrows(IllegalArgumentException.class, () -> isbnValidator.verifierIsbn(isbn));

    }

    @Test
    public void isbnNePeutContenirQueChiffreOuX(){
        IsbnValidator isbnValidator;
        String isnb;

        Given :
        isbnValidator = new IsbnValidator();

        When :
        isnb = "AZERTY10000";

        Then :
        assertThrows(IllegalArgumentException.class, () -> isbnValidator.verifierIsbn(isnb));
    }
}
