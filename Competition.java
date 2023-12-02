import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Competition {
    public static void main(String[] args) {
        TallyCounter tallyCounter = new TallyCounter();
        simulateGame("Checkers", 150, tallyCounter);
        simulateGame("Darts", 250, tallyCounter);
        simulateGame("Relay" , 98, tallyCounter);
        simulateGame("Jump Rope" , 75, tallyCounter);
        simulateGame("Spear Throw", 89, tallyCounter);

        try (PrintWriter writer = new PrintWriter("results.txt")) {
            writeResult(writer, "Checkers" , tallyCounter.getCurrentCount());
            writeResult(writer, "Darts", tallyCounter.getCurrentCount());
            writeResult(writer, "Relay", tallyCounter.getCurrentCount());
            writeResult(writer, "Jump Rope", tallyCounter.getCurrentCount());
            writeResult(writer, "Spear Throw", tallyCounter.getCurrentCount());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void simulateGame(String gameName, int clicks, TallyCounter counter) {
        System.out.println("Game: " + gameName);
        for (int i = 0; i < clicks; i++) {
            counter.click();
        }
        System.out.println("Number of clicks: " + counter.getCurrentCount());
        counter.reset();
    }

    private static void writeResult(PrintWriter writer, String gameName, int count) {
        writer.println("Counter value after " + gameName + ": " + count);
    }
}

class TallyCounter {
    private int currentCount;

    public TallyCounter() {
        currentCount = 0;
    }

    public void reset() {
        currentCount = 0;
    }

    public void click() {
        currentCount++;
    }

    public int getCurrentCount() {
        return currentCount;
    }
}