import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MyFirstAutomationWithJava {
    private static final Color TEXT_COLOR=Color.WHITE;
    public static void main(String[] args) {
        //IMPORTANT NOTICE!
        /* I am a bare beginner, I am a Beginner, I dont know about all these initially as said by the file name! 
        dont ask for hard updates cuz I am still an beginner learning Java programming! It's just my first year or just months
        I want explanations of: Robot class, the entire awt pack, ImageIO.write() function, how it works!      
        */
     try {
        //initialize the robot!
        Robot robot= new Robot();
        robot.setAutoDelay(0);
        MakeGUIWarning();
        
        //get the screen size
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();  //get the length breath of the default monitor screen size
        Rectangle screenRectangle=new Rectangle(screenSize);
        //to have the rectangle of it

        //capture photo first
        BufferedImage bufferedImage=robot.createScreenCapture(screenRectangle);

        
        //to the system paths of all OS        
        String picString=System.getProperty("user.home") + "/Pictures/Screenshots"; 


        File directory=new File(picString);  
        if (!directory.exists()) {  
            directory.mkdirs();
        }

        //This generates the name of the screenshot file with a timestamp to ensure uniqueness. The file is saved in the specified directory in JPEG format. 
        String timeString="Screenshot_" + System.currentTimeMillis() + ".jpg";
        File systemFile=new File(directory, timeString);
        ImageIO.write(bufferedImage, "jpg", systemFile);     
    }    
    catch (Exception e) {
     e.printStackTrace();
    }
 }
private static void MakeGUIWarning() {
    JFrame frame=new JFrame();
    frame.setAlwaysOnTop(true);
    frame.setDefaultCloseOperationI(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(300,300);

    JPanel pannel=new Jpanel();
    pannel.setLayout(Jpanel, new BoxLayout(pannel, box.Y_AXIS));
    pannel.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
    pannel.setBackground(new Color(100,100,100));

}
}
