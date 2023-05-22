package isbn.test.tdd;

public class IsbnValidator {

    /**
     * Verifie si un numéro ISBN est valide
     * @param isbnAVerifier
     * @return true si valide, false si non
     */
    public boolean verifierIsbn(String isbnAVerifier) {
        if(isbnAVerifier.length() != 10){
            throw new IllegalArgumentException("Le numéro ISBN n'est pas de10 caractères");
        } else {
            int isbn = Integer.parseInt(isbnAVerifier.substring(0, 9));
            int total = convertirDernierNombre(isbnAVerifier);
            total += calculerSommePoids(isbn);
            return verifierModuloDeOnze(total);
        }
    }

    /**
     * Vérifie que le nombre est divisible par onze.
     * @param total
     * @return boolean
     */
    private boolean verifierModuloDeOnze(int total){
        return total % 11 == 0;
    }

    /**
     * Fait la somme des multiplications
     * des chiffres
     * @param isbn
     * @return int
     */
    private int calculerSommePoids(int isbn) {
        int somme = 0;
        for (int index = 1; index < 10; index++) {
            somme += (isbn % 10) * (index + 1);
            isbn /= 10;
        }
        return somme;
    }

    /**
     *
     * @param isbnAVerifier
     * @return int
     */
    private int convertirDernierNombre(String isbnAVerifier){
        int lastNumber = 0;
        if (isbnAVerifier.charAt(9) == 'X') {
            lastNumber += 10;
        } else {
            lastNumber += Character.getNumericValue(isbnAVerifier.charAt(9));
        } return lastNumber;
        }
    }