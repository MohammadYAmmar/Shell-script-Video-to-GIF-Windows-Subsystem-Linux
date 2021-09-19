import java.awt.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/*
Java program can run Shell script in windows by subsystem to Linux
By: Eng. Mohammad Yaser Ammar
https://github.com/MohammadYAmmar
https://www.linkedin.com/in/mohammad-y-ammar/
 */
public class main{
    public static void main(String[]args) throws IOException, InterruptedException {

        // Call method here to check to shell and video and send "shell"
        checkFile("Video_to_GIF.sh");//Put this as a comment if you want to run any shell in folder

        //TODO It is preferable to add here to check whether there is a video of the tool or not
        //checkFile(".mp4");

        //TODO It is preferable to add here to check whether there is Linux installed as a subsystem or not
        try{
            //The section to run any shell script in a Linux subsystem inside Windows
            String cmd = "bash *.sh";
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
            Process process = builder.start();
            process.waitFor();

            //process.getOutputStream();//test
            //process.getInputStream();

            System.out.println("done");//For debug
            infoBox("Video to GIF","Done converting to GIF");
        }catch (Exception ex){
            infoBox("Video to GIF","Error: " + ex.getMessage());
        }
    }
    public static void checkFile(String fileName)
    {
        try
        {
            //boolean check = new File(fileName).exists();
            if (new File(fileName).exists()) {
                System.out.println(fileName + " is exist");//For debug
            }
            else{
                infoBox("Video to GIF","Error: " + fileName + " is not exist");
                System.exit(0);
            }

        } catch (Exception ex)
        {
            infoBox("Video to GIF","Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void infoBox(String titleBar, String infoMessage )
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void infoBox_with_Options(){
        //todo
        //https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html#button
        Object[] options = {"Yes, please",
                "No way!"};
        int n = JOptionPane.showOptionDialog(null,
                "Would you like Tom and Jerry?",
                "A Silly Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        //open_URL()
    }

    public static void open_URL() throws IOException {
        String url = "https://github.com/MohammadYAmmar";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);//todo what that?
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}//class
