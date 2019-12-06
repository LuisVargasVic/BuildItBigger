package com.baxter.javoker;

import java.util.ArrayList;
import java.util.List;

public class Javoker {

    public List<String> jokes = new ArrayList<>();

    // Jokes retrieved from https://www.goodhousekeeping.com/life/parenting/g28581033/best-jokes-for-kids/
    public void populateJokes() {
        jokes.add("Why is Cinderella bad at soccer?\n" + "Because she’s always running away from the ball!");
        jokes.add("Why did the picture go to prison?\n" + "Because it was framed!");
        jokes.add("Where do cows go on Friday nights?\n" + "They go to the moo-vies!");
        jokes.add("What did one eye say to the other eye?\n" + "Between us, something smells!");
        jokes.add("Why do bicycles fall over?\n" + "Because they’re two-tired!");
        jokes.add("Knock, knock!\n" + "Who’s there?\n" + "Hatch.\n" + "Hatch who?\n" + "Bless you!");
        jokes.add("What does a rain cloud wear under her dress?\n" + "Thunderwear!");
    }

    public String tellJoke() {
        populateJokes();
        return jokes.get((int) (Math.random() * 6));
    }
}
