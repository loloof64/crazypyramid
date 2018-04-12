package com.loloof64;

import java.util.ArrayList;
import java.util.List;

public class Sastantua {
    public static void main(String[] args) {
        final int maxLevel = 8;
        final List<String> sastantuaWithoutDoors = buildForLevelsCountWithoutDoors(maxLevel);
        final List<String> sastantua = buildForLevelsCountWithDoorsThisTime(maxLevel, sastantuaWithoutDoors);
        for (String line : sastantua){
            System.out.println(line);
        }
    }

    public static List<String> buildForLevelsCountWithoutDoors(int maxLevel){
        List<String> linesFirstPass = new ArrayList<>();
        SastantuaBuilder builder = new SastantuaBuilder();

        final int maxStarsCount = builder.getStarsNeededForLastLine(maxLevel);
        final int lastLineLength = maxStarsCount+2;
        final int linesCount = builder.getTotalLines(maxLevel);

        for (int lineIndex = 0; lineIndex < linesCount; lineIndex++) {

            final int starsCount = builder.starsCountForLine(lineIndex);
            final StringBuilder visiblePart = new StringBuilder("/");
            for (int i = 0; i < starsCount; i++) {
                visiblePart.append('*');
            }
            visiblePart.append('\\');
            final int visiblePartLength = visiblePart.length();

            int linesSpaces = lastLineLength - visiblePartLength;
            int spacesBeforeCount = linesSpaces / 2;
            final StringBuilder spacesBefore = new StringBuilder();
            for (int i = 0; i < spacesBeforeCount; i++){
                spacesBefore.append(' ');
            }

            String printableLine = spacesBefore.toString() + visiblePart.toString();
            linesFirstPass.add(printableLine);
        }

        return linesFirstPass;
    }

    public static List<String> buildForLevelsCountWithDoorsThisTime(int maxLevel, List<String> sastantaWithoutDoors){
        final List<String> linesSecondPass = new ArrayList<>();
        SastantuaBuilder builder = new SastantuaBuilder();
        final int linesCount = builder.getTotalLines(maxLevel);

        final StringBuilder doorSubsitutionBuilder = new StringBuilder();
        for (int i = 0; i < maxLevel; i++){
            doorSubsitutionBuilder.append('|');
        }
        final String doorSubstitution = doorSubsitutionBuilder.toString();

        for (int i = 0; i < linesCount - maxLevel; i++){
            linesSecondPass.add(sastantaWithoutDoors.get(i));
        }
        for (int i = 0; i < maxLevel; i++){
            int currentListIndex = linesCount - maxLevel + i;
            String originalLineValue = sastantaWithoutDoors.get(currentListIndex);
            int substitutionStartIndex = (originalLineValue.length() - maxLevel / 2) / 2 - i/2 +1 ;
            String newLineValue = originalLineValue.substring(0, substitutionStartIndex) + doorSubstitution +
                    originalLineValue.substring(substitutionStartIndex+maxLevel);
            linesSecondPass.add(newLineValue);

        }

        return linesSecondPass;
    }
}
