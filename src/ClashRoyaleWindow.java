import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a new JFrame with the emote buttons.
 * @author Leonardo Ledda (LeddaZ)
 */
public class ClashRoyaleWindow extends JFrame {

    /**
     * Constructor; creates the components and puts them in
     * the JFrame.
     */
    public ClashRoyaleWindow() {
        super("Clash Royale Emotes");
        setSize(350, 350);

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Clash Royale Emotes");
        titleLabel.setFont(new Font("sans-serif", Font.PLAIN, 18));
        titlePanel.add(titleLabel);
        add(titlePanel, "North");

        JPanel emotesPanel = new JPanel();
        emotesPanel.setLayout(new GridLayout(2, 2));

        JButton angryButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("emotes/Angry_King.png")));
        emotesPanel.add(angryButton);

        JButton cryingButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("emotes/Crying_King.png")));
        emotesPanel.add(cryingButton);

        JButton laughButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("emotes/Laughing_King.png")));
        emotesPanel.add(laughButton);

        JButton thumbsUpButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("emotes/Thumbs-Up_King.png")));
        emotesPanel.add(thumbsUpButton);

        add(emotesPanel, "Center");

        JPanel bottomPanel = new JPanel();
        JLabel bottomLabel = new JLabel("You laughed 0 times. HEHEHEHA!");
        bottomLabel.setFont(new Font("sans-serif", Font.PLAIN, 16));
        bottomPanel.add(bottomLabel);
        add(bottomPanel, "South");

        angryButton.addMouseListener(new EmoteButtonListener("angry"));
        laughButton.addMouseListener(new EmoteButtonListener("laugh", bottomLabel));
        cryingButton.addMouseListener(new EmoteButtonListener("sad"));
        thumbsUpButton.addMouseListener(new EmoteButtonListener("thumbsUp"));

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
