import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private ArrayList<String> fortunes;
    private JButton newFortune;
    private JButton quit;
    private JTextArea displayArea;

    private int previousFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createGUI();
        enableButtons();

        fortunes = new ArrayList<>();
        fortunes.add("You will find a banana in your pillowcase.");
        fortunes.add("Sometimes you just need to crash your car.");
        fortunes.add("You need to take a vacation.");
        fortunes.add("You need to get off your ass and work.");
        fortunes.add("I see a snack in your future.");
        fortunes.add("I see a 100 in this project's future");
        fortunes.add("I'm not good at this fortune thing.");
        fortunes.add("I need a break from the whole fortune telling job.");
        fortunes.add("Get some sunshine.");
        fortunes.add("Touch grass in your future.");
        fortunes.add("I see an L in the future.");
        fortunes.add("AAAAAAAAAAAAHHHHHHHHHHHH Respectfully");

        setVisible(true);
    }

    private void createGUI() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        //JLabel
        JLabel textImage = new JLabel("Fortune Teller!");
        textImage.setFont(new Font("SansSerif", Font.BOLD, 42));
        main.add(BorderLayout.NORTH, textImage);

        //Couldn't figure out the image
        //TextScroller
        displayArea = new JTextArea(10, 50);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane scroller = new JScrollPane(displayArea);
        main.add(BorderLayout.CENTER, scroller);
        //Adding Button on a panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        //Adding buttons
        newFortune = new JButton("Read My Fortune!");
        newFortune.setFont(new Font("Georgia ", Font.PLAIN, 18));
        quit = new JButton("Quit");
        quit.setFont(new Font("Georgia ", Font.PLAIN, 18));
        buttons.add(newFortune);
        buttons.add(quit);
        main.add(BorderLayout.SOUTH, buttons);

        add(main);
    }
    //Button Functionality
    private void enableButtons() {
        newFortune.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFortune();
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //Random fortune generator logic cant have back to back fortunes
    private void readFortune() {
        int randomIndex;
        do {
            randomIndex = new Random().nextInt(fortunes.size());
        } while (randomIndex == previousFortuneIndex);
        previousFortuneIndex = randomIndex;
        String fortune = fortunes.get(randomIndex);
        displayArea.append(fortune + "\n");
    }

}
