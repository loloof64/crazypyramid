package com.loloof64;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSastantuaBuilder {

    private SastantuaBuilder builder;

    @Before
    public void setup(){
        builder = new SastantuaBuilder();
    }

    @Test
    public void linesNumberForLevel_1(){
        assertEquals(3, builder.getLevelLines(1));
    }

    @Test
    public void linesNumberForLevel_2(){
        assertEquals(4, builder.getLevelLines(2));
    }

    @Test
    public void linesNumberForLevel_3(){
        assertEquals(5, builder.getLevelLines(3));
    }

    @Test
    public void levelSwitchingExtraStars_between_1_and_2(){
        assertEquals(4, builder.getLevelSwitchingExtraStars_exitingFromLevel(1));
    }

    @Test
    public void levelSwitchingExtraStars_between_2_and_3(){
        assertEquals(4, builder.getLevelSwitchingExtraStars_exitingFromLevel(2));
    }

    @Test
    public void levelSwitchingExtraStars_between_3_and_4(){
        assertEquals(6, builder.getLevelSwitchingExtraStars_exitingFromLevel(3));
    }

    @Test
    public void levelSwitchingExtraStars_between_4_and_5(){
        assertEquals(6, builder.getLevelSwitchingExtraStars_exitingFromLevel(4));
    }

    @Test
    public void levelSwitchingExtraStars_between_5_and_6(){
        assertEquals(8, builder.getLevelSwitchingExtraStars_exitingFromLevel(5));
    }

    @Test
    public void levelSwitchingExtraStars_between_6_and_7(){
        assertEquals(8, builder.getLevelSwitchingExtraStars_exitingFromLevel(6));
    }

    @Test
    public void starsCount_line_0(){
        assertEquals(1, builder.starsCountForLine(0));
    }

    @Test
    public void starsCount_line_1(){
        assertEquals(3, builder.starsCountForLine(1));
    }

    @Test
    public void starsCount_line_2(){
        assertEquals(5, builder.starsCountForLine(2));
    }

    @Test
    public void starsCount_line_3(){
        assertEquals(11, builder.starsCountForLine(3));
    }

    @Test
    public void starsCount_line_6(){
        assertEquals(17, builder.starsCountForLine(6));
    }

    @Test
    public void starsCount_line_7(){
        assertEquals(23, builder.starsCountForLine(7));
    }

    @Test
    public void starsCount_line_10(){
        assertEquals(29, builder.starsCountForLine(10));
    }

    @Test
    public void starsCount_line_11(){
        assertEquals(31, builder.starsCountForLine(11));
    }

    @Test
    public void starsCount_line_12(){
        assertEquals(39, builder.starsCountForLine(12));
    }

    @Test
    public void starsCount_line_14(){
        assertEquals(43, builder.starsCountForLine(14));
    }

    @Test
    public void starsCount_line_17(){
        assertEquals(49, builder.starsCountForLine(17));
    }

    @Test
    public void starsCount_line_18(){
        assertEquals(57, builder.starsCountForLine(18));
    }

    @Test
    public void starsCount_line_19(){
        assertEquals(59, builder.starsCountForLine(19));
    }

    @Test
    public void starsNeededForLastLine_1_level(){
        assertEquals(5, builder.getStarsNeededForLastLine(1));
    }

    @Test
    public void starsNeededForLastLine_2_level(){
        assertEquals(17, builder.getStarsNeededForLastLine(2));
    }

    @Test
    public void starsNeededForLastLine_4_level(){
        assertEquals(49, builder.getStarsNeededForLastLine(4));
    }

}
