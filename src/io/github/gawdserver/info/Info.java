package io.github.gawdserver.info;

import io.github.gawdserver.api.plugin.Plugin;
import io.github.gawdserver.api.plugin.PluginDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class Info implements Plugin {
    public static final Logger logger = Logger.getLogger("Info");
    @Override
    public void startup() {
        File helpFile = new File(PluginDir.getPluginDir(), "Info/info.txt");
        if (!helpFile.exists()) {
            try {
                helpFile.getParentFile().mkdirs();
                FileWriter fw = new FileWriter(helpFile);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Edit file 'plugins/Info/info.txt' to change this message.");
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error creating default Info file.", ex);
            }
        }
    }

    @Override
    public void shutdown() {}
}
