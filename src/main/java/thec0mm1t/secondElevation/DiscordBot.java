package thec0mm1t.secondElevation;

import ca.tristan.easycommands.commands.EasyCommands;
import ca.tristan.easycommands.commands.HelpCmd;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.Arrays;

public class DiscordBot {
    private static final GatewayIntent[] gatewayIntents = {GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS};

    public static void main(String[] args) throws InterruptedException {
        Dotenv dotenv = Dotenv.load();

        DiscordBot bot = new DiscordBot();

        JDABuilder jdaBuilder = JDABuilder.create(dotenv.get("BOT_TOKEN"), Arrays.asList(gatewayIntents));

        JDA jda = jdaBuilder.build().awaitReady();

        EasyCommands easyCommands = new EasyCommands(jda, false);
        easyCommands.addExecutor(new HelpCmd(easyCommands));
//        easyCommands.getExecutors();

        jda.addEventListener(easyCommands);
    }
}
