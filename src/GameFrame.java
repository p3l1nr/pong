import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

       // close the game when ESC is pressed
        panel.addKeyListener( new KeyAdapter( ) {
            public void keyPressed( KeyEvent e ) {
                if ( e.getKeyCode( ) == KeyEvent.VK_ESCAPE ) {
                    System.out.println( "Escape key pressed" );
                    System.exit( 0 ); // terminate program
                }
            }
        } );
    }
}
