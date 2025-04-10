package ru.bot.telegram;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {
    private final List<String> phrase;

    public Storage() {
        phrase = new ArrayList<>();
        phrase.add("Катя лучшая");
        phrase.add("Максим лучший");
        phrase.add("Ральф лучший");
    }

    public String getPhrase() {
        int randomValue = (int) (Math.random() * phrase.size());

        return phrase.get(randomValue);
    }
}