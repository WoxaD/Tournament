import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String Name1, String Name2) {
        Player p1 = null;
        Player p2 = null;
        for (Player player : players) {
            if (player.getName().equals(Name1)) {
                p1 = player;
            }
            if (player.getName().equals(Name2)) {
                p2 = player;
            }
        }
        if (p1 == null) {
            throw new RuntimeException("Игрок " + Name1 + " не зарегистрирован");
        }
        if (p2 == null) {
            throw new RuntimeException("Игрок " + Name2 + " не зарегистрирован");
        }

        if (p1.getStrength() == p2.getStrength()) {
            return 0;
        }
        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}