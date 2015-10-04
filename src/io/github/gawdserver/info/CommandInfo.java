package io.github.gawdserver.info;

import io.github.gawdserver.api.events.Command;
import io.github.gawdserver.api.player.Sender;
import io.github.gawdserver.api.plugin.PluginDir;
import io.github.gawdserver.api.utils.Chat;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class CommandInfo implements Command {

    @Override
    public void playerCommand(String player, String[] args) {
        File txtFile = new File(PluginDir.getPluginDir(), "Info/info.txt");
        if (args.length > 0) {
            txtFile = new File(PluginDir.getPluginDir(), "Info/" + args[0].toLowerCase() + ".txt");
        }
        if (txtFile.exists()) {
            BufferedReader br = null;
            try {
                String currentLine;
                br = new BufferedReader(new FileReader(txtFile));
                while ((currentLine = br.readLine()) != null) {
                    Chat.sendMessage(player, currentLine);
                }
            } catch (IOException ex) {
                Chat.sendMessage(player, "Error loading info.");
                Info.logger.log(Level.SEVERE, "Error loading " + args[0].toLowerCase() + ".txt", ex);
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            Chat.sendMessage(player, "Info does not exist.");
        }
    }

    @Override
    public void serverCommand(Sender sender, String[] args) {
        File txtFile = new File(PluginDir.getPluginDir(), "Info/info.txt");
        if (args.length > 0) {
            txtFile = new File(PluginDir.getPluginDir(), "Info/" + args[0].toLowerCase() + ".txt");
        }
        if (txtFile.exists()) {
            BufferedReader br = null;
            try {
                String currentLine;
                br = new BufferedReader(new FileReader(txtFile));
                while ((currentLine = br.readLine()) != null) {
                    Chat.sendMessage(Sender.CONSOLE.name(), currentLine);
                }
            } catch (IOException ex) {
                Chat.sendMessage(Sender.CONSOLE.name(), "Error loading info.");
                Info.logger.log(Level.SEVERE, "Error loading " + args[0].toLowerCase() + ".txt", ex);
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            Chat.sendMessage(Sender.CONSOLE.name(), "Info does not exist.");
        }
    }
}
