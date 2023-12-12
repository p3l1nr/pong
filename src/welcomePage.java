import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class welcomePage extends JFrame {
    JFrame f;

    welcomePage( ) {

        JButton b = new JButton( "click" );
        JPanel panel = new JPanel( );
        b.setBounds( 100, 100, 100, 100 );
        b.setBorderPainted( false );
        b.setFocusPainted( false );
        b.setContentAreaFilled( false );
        add( panel );
        panel.add( b );
        panel.setSize( 400, 500 );
        panel.setBackground( Color.black );
        panel.setVisible( true );
        panel.setLayout( null );


        setSize( 400, 500 );
        setLayout( null );
        setVisible( true );
        setBackground( Color.black );
        setLocationRelativeTo( null );
        panel.setFocusable( true );
        panel.requestFocusInWindow( );

        panel.addKeyListener( new KeyAdapter( ) {
            public void keyPressed( KeyEvent e ) {
                if ( e.getKeyCode( ) == KeyEvent.VK_ESCAPE ) {
                    System.out.println( "Escape key pressed" );
                    System.exit( 0 ); // terminate program
                }
            }
        } );
        //press ENTER and the game start
        panel.addKeyListener( new KeyAdapter( ) {
            public void keyPressed( KeyEvent e ) {
                if ( e.getKeyCode( ) == KeyEvent.VK_ENTER ) {
                    try {
                        new GameFrame();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                        throw new RuntimeException( ex );
                    }
                }
            }

        } );
        b.addActionListener( new ActionListener( ) {
            public void actionPerformed( ActionEvent e ) {
                dispose( ); // close the current window
            }
        } );

        b.addActionListener( e -> {
            try {
                new GameFrame( );
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException( ex );
            }
        } );
    }

    public static void main( String[] args ) {
        new welcomePage( );
    }
}