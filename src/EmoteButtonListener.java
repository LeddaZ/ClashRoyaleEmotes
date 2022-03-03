import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

/**
 * Listener for the emote buttons.
 * @author Leonardo Ledda (LeddaZ)
 */
public class EmoteButtonListener implements MouseListener {

    private final String emote;
    private static int clickCount = 0;
    private JLabel label;

    /**
     * Constructor without JLabel.
     * @param emote a string corresponding to the emote's
     *              audio file name (without extension)
     */
    public EmoteButtonListener(String emote) {
        this.emote = emote;
    }

    /**
     * Constructor with JLabel. Made for the laughing emote.
     * @param emote a string corresponding to the emote's
     *              audio file name (without extension)
     * @param label JLabel with the laugh count
     */
    public EmoteButtonListener(String emote, JLabel label) {
        this.emote = emote;
        this.label = label;
    }

    /**
     * Plays the corresponding sound when an emote button is
     * clicked (and increases the laugh count if the laughing
     * emoji is clicked).
     * @param e the event to be processed
     */
    public void mouseClicked(MouseEvent e) {
        try {
            if(emote.equals("laugh")) {
                clickCount++;
                label.setText("You laughed " + clickCount + " times. HEHEHEHA!");
            }
            InputStream is= getClass().getResourceAsStream("audio/" + emote + ".wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException ex) {
            System.out.println(ex);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

}
