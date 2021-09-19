import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
/*
Java program can run any Shell script in windows by subsystem to Linux
By: Eng. Mohammad Yaser Ammar
https://github.com/
https://www.linkedin.com/in/mohammad-y-ammar/
 */
public class main{
    public static void main(String[]args) throws IOException, InterruptedException {
        try{
            //The section to run any shell script in a Linux subsystem inside Windows
            String cmd = "bash *.sh";
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
            Process process = builder.start();
            process.waitFor();

            System.out.println("done");//For debug
            infoBox("Open any shell script","Done");
        }catch (Exception ex){
            infoBox("Open any shell script","Error: " + ex.getMessage());
        }
    }
    public static void infoBox(String titleBar, String infoMessage )
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
