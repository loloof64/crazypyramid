package com.loloof64;

import java.util.ArrayList;
import java.util.List;

public class Sastantua {
    public static void main(String[] args) {
        printSastantuaForMaxLevelsCount(8);
    }

    public static void printSastantuaForMaxLevelsCount(int levels){
        List<String> sastantua = buildForLevelsCount(levels);
        for (String line : sastantua){
            System.out.println(line);
        }
    }

    public static List<String> buildForLevelsCount(int maxLevel){
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

        final List<String> linesSecondPass = new ArrayList<>();

        final StringBuilder doorSubsitutionBuilder = new StringBuilder();
        for (int i = 0; i < maxLevel; i++){
            doorSubsitutionBuilder.append('|');
        }
        final String doorSubstitution = doorSubsitutionBuilder.toString();

        for (int i = 0; i < linesCount - maxLevel; i++){
            linesSecondPass.add(linesFirstPass.get(i));
        }
        for (int i = 0; i < maxLevel; i++){
            int currentListIndex = linesCount - maxLevel + i;
            String originalLineValue = linesFirstPass.get(currentListIndex);
            int substitutionStartIndex = (originalLineValue.length() - maxLevel / 2) / 2 - i/2;
            if ((maxLevel-1) % 4 == 0 || (maxLevel - 2) % 4 == 0) {
                substitutionStartIndex += (i%2 == 1 ? -1: 0);
            }
            String newLineValue = originalLineValue.substring(0, substitutionStartIndex) + doorSubstitution +
                    originalLineValue.substring(substitutionStartIndex+maxLevel);
            linesSecondPass.add(newLineValue);

        }

        return linesSecondPass;
    }
}
