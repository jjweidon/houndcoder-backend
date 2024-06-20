package com.houndcoder.members.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class NicknameGenerator {

    private final List<String> firstParts;
    private final List<String> secondParts;
    private final Random random = new Random();

    public NicknameGenerator(
            @Value("#{'${houndcoder.nickname.first}'.split(', ')}") List<String> firstParts, 
            @Value("#{'${houndcoder.nickname.second}'.split(', ')}") List<String> secondParts) {
        this.firstParts = firstParts;
        this.secondParts = secondParts;
    }

    public String generateRandomNickname() {
        String first = firstParts.get(random.nextInt(firstParts.size()));
        String second = secondParts.get(random.nextInt(secondParts.size()));
        return first + second;
    }
}
