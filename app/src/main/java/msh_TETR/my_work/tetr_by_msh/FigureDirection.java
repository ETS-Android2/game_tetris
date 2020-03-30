package msh_TETR.my_work.tetr_by_msh;

import java.util.Random;

enum FigureDirection {
    Left, Top, Right, Bottom;

    public static FigureDirection getRandomDirection()
    {
        return FigureDirection.values()[new Random().nextInt(4)];
    }
}
