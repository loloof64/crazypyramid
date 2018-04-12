package com.loloof64;

public class SastantuaBuilder {

    public int getLevelLines(int levelStartingAt1) {
        return levelStartingAt1 + 2;
    }

    /**
     * Gets the extra stars we need to add when going from the last line
     * of the given level, and the first line of the next level : where extra
     * stars is the difference between the expected augmentation from its previous line and the
     * augmentation needed to form the sastantua at this level.
     */
    public int getLevelSwitchingExtraStars_exitingFromLevel(int levelStartingAt1) {
        return 4 + 2 * (int) ((levelStartingAt1 - 1) / 2);
    }

    public int starsCountForLine(int overallLineStartingAt0) {
        int value = 1;
        int currentLevel = 1;
        int remainingLinesForCurrentLevel = getLevelLines(currentLevel);
        for (int line = 0; line < overallLineStartingAt0; line++){
            value += 2;
            remainingLinesForCurrentLevel--;
            if (remainingLinesForCurrentLevel <= 0){
                int oldLevel = currentLevel;
                currentLevel++;
                remainingLinesForCurrentLevel = getLevelLines(currentLevel);
                value += getLevelSwitchingExtraStars_exitingFromLevel(oldLevel);
            }
        }
        return value;
    }

    public int getTotalLines(int levels){
        int linesCount = 0;
        for (int currentLevel = 1; currentLevel <= levels; currentLevel++) {
            linesCount += getLevelLines(currentLevel);
        }
        return linesCount;
    }

    public int getStarsNeededForLastLine(int levels){

        return starsCountForLine(getTotalLines(levels)-1);
    }
}
