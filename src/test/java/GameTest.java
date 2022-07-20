import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();
    Player p1 = new Player(1, "James", 31);
    Player p2 = new Player(2, "Mary", 31);
    Player p3 = new Player(3, "Robert", 61);
    Player p4 = new Player(4, "Patricia", 29);

    @Test
    public void shouldCompareIfPlayersHaveEqualStrength() {
        game.register(p1);
        game.register(p2);

        assertEquals(0, game.round(p1.getName(), p2.getName()));
    }

    @Test
    public void shouldCompareIfFirstPlayerStrongerThanSecond() {
        game.register(p2);
        game.register(p4);

        assertEquals(1, game.round(p2.getName(), p4.getName()));
    }

    @Test
    public void shouldCompareIfFirstPlayersWeakerThanSecond() {
        game.register(p1);
        game.register(p3);

        assertEquals(2, game.round(p1.getName(), p3.getName()));
    }

    @Test
    public void shouldCompareIfFirstPlayerIsNotRegistered() {
        game.register(p2);
        game.register(p3);

        assertThrows(RuntimeException.class, () -> game.round(p1.getName(), p3.getName()));
    }

    @Test
    public void shouldCompareIfSecondPlayerIsNotRegistered() {
        game.register(p1);
        game.register(p2);

        assertThrows(RuntimeException.class, () -> game.round(p1.getName(), p3.getName()));
    }

    @Test
    public void shouldCompareIfBothPlayersAreNotRegistered() {
        game.register(p1);
        game.register(p2);

        assertThrows(RuntimeException.class, () -> game.round(p3.getName(), p4.getName()));
    }
}