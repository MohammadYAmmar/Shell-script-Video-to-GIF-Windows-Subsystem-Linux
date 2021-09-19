import java.io.IOException;

public class open_shell_windows{
    public static void main(String[]args) throws IOException, InterruptedException {

//        String cmd = "dir > test1998.txt";
//        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
//        Process process = builder.start();
//        process.waitFor();
//        System.out.println("done");


        //String cmd = "bash hello.sh";
        //Video_to_GIF5.sh

        //Run
        String cmd = "bash *.sh";

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", cmd);
        Process process = builder.start();
        process.waitFor();
        System.out.println("done");
    }
}

