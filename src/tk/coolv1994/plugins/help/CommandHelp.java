package tk.coolv1994.plugins.help;

import tk.coolv1994.gawdserver.events.Command;
import tk.coolv1994.gawdserver.utils.Chat;

import java.io.*;

/**
 * Created by Vinnie on 2/18/2015.
 */
public class CommandHelp implements Command {
    @Override
    public void onCommand(String player, String[] args) {
        File helpFile = new File("./plugins/Help/help.txt");
        if (args.length > 0)
            helpFile = new File("./plugins/Help/" + args[0].toLowerCase() + ".txt");
        if (helpFile.exists())
        {
            BufferedReader br = null;
            try {
                String currentLine;
                br = new BufferedReader(new FileReader(helpFile));
                while ((currentLine = br.readLine()) != null) {
                    Chat.sendMessage(player, currentLine);
                }
            } catch (IOException e) {
                Chat.sendMessage(player, "Error loading help.");
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            Chat.sendMessage(player, "Help file does not exist.");
        }
    }
}
