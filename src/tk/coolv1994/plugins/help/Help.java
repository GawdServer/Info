package tk.coolv1994.plugins.help;

import tk.coolv1994.gawdapi.plugin.Plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class Help implements Plugin {
    @Override
    public void startup() {
        File helpFile = new File("./plugins/Help/help.txt");
        if (!helpFile.exists()) {
            try {
                helpFile.getParentFile().mkdirs();
                FileWriter fw = new FileWriter(helpFile);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Edit file 'plugins/Help/help.txt' to change this message.");
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                System.out.println("Error creating default Help file.");
            }
        }
    }

    @Override
    public void shutdown() {}
}
