import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.awt.SystemTray;
import javax.imageio.*;
public class MyFirstAutomationWithJava {
    public static void main(String[] args) {
        if(!SystemTray.isSupported()){
            System.out.println("The System tray is not supported on your OS");
         return;
        }
        try {
        //if OS supports tray,
        SystemTray tray=SystemTray.getSystemTray();

        PopupMenu popupMenu=new PopupMenu();

        //======-=-=-=-=-=-======
        MenuItem inPopupMenu=new MenuItem("ScreenShot");
        inPopupMenu.addActionListener(e-> captureImage());
        popupMenu.add(inPopupMenu);

        //the popupmenu is the main container
        popupMenu.addSeparator();
        //another button

        MenuItem insideMenu=new MenuItem("Exit");
        insideMenu.addActionListener(e-> System.exit(0));
        popupMenu.add(insideMenu);

        TrayIcon tricon=new TrayIcon(createIcon(),"Java Screenshot" , popupMenu);
        tricon.addActionListener(a-> captureImage());
        tray.add(tricon);
        tricon.setImageAutoSize(true);
        }
        catch(Exception exc){
         exc.printStackTrace();
        }
    }
    
private static void captureImage() {
     try {
        //initialize the robot!
        Robot robot= new Robot();
        robot.setAutoDelay(0);
                
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
        String timeString="Screenshot_" + System.currentTimeMillis() + ".png";
        File systemFile=new File(directory, timeString);
        ImageIO.write(bufferedImage, "png", systemFile);     
    }    
    catch (Exception e) {
     e.printStackTrace();
    }
 }
 //For explaination needed
 private static Image createIcon(){
    BufferedImage image=new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    
    Graphics2D graphics=image.createGraphics();   
    
    graphics.setColor(Color.RED); 
    graphics.fillRect(0, 0, 12, 12);
    graphics.dispose();
    return image;
 }
}
