import java.util.Random;

public class SignDeck {
    private Cards flip = new Cards("FLIP +/-", "+", 0);
    private Cards DOUBLE = new Cards("DOUBLE", "+", 0);
    private int a;

    public SignDeck() {
    }

    public Cards getSignCard() {
        return createRandomCard();
    }

    private Cards createRandomCard() {
        Random r = new Random();

        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] signs = {"+", "-"};
        String randomColor = colors[r.nextInt(colors.length)];
        String randomSign = signs[r.nextInt(signs.length)];
        int randomValue = r.nextInt(6) + 1;

        return new Cards(randomColor, randomSign, randomValue);
    }

    public Cards getDouble() {
        DOUBLE.setValue(0);
        return DOUBLE;
    }

    public Cards getFlip() {
        flip.setValue(0);
        return flip;
    }

    public Cards getFlipOrDouble() {
        Random r = new Random();
        a = r.nextInt(100);
        if (a < 50) {
            return getDouble();
        } else {
            return getFlip();
        }
    }
}
