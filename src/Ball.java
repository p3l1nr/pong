import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Ball extends Rectangle {

    private BufferedImage ballImage;  // Declare the BufferedImage variable

    private Random random;
    public int xVelocity;
    public int yVelocity;
    private int initialSpeed = 10;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width+100, height+100);
        try {
            // Load the image from file
            ballImage = ImageIO.read(new File("C:\\Users\\Robert\\Desktop\\pong\\funny ball.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * initialSpeed);
    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        // Draw the ball image
        g.drawImage(ballImage, x, y, width, height, null);
    }
}
