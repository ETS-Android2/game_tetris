package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

public final class FigureI extends TetrFigure {

    //X - left down of figureI at axis OX
    //Y - left down of figureI at axis OY


    public FigureI(FigureDirection direction, int color){
        if(direction == FigureDirection.Bottom)
            direction = FigureDirection.Top;
        if(direction == FigureDirection.Right)
            direction = FigureDirection.Left;
        this.direction = direction;
        this.color = color;
        initializeCoordinate();
    }

    private void initializeCoordinate()
    {
        Y = -1;
        if(direction == FigureDirection.Top)
            X = 5;
        else
            X = 3;
    }

    @Override
    public Pair<Integer, Integer> chooseFormPosition()
    {
        Pair<Integer, Integer> position = new Pair<>(X, Y);
        boolean search = true;

        while (getBottomCoordinate(position.first, position.second).second < FieldActivity.gameField.nRows - 1 && search)
            switch (direction)
            {
                case Top:
                    if(!FieldActivity.gameField.mapOfField.get(position.second + 4).get(position.first))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;

                case Left:
                    if(!FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 1)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 2)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 3))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;
            }

        return position;
    }

    @Override
    public void turnFigure() {
        switch (direction)
        {
            case Top:
                if(X >= FieldActivity.gameField.nColumns - 3)
                {
                    if(X == FieldActivity.gameField.nColumns - 1)
                    {
                        if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 2) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 3))
                            forTurn(FigureDirection.Left, -3, 1);
                    }

                    if(X == FieldActivity.gameField.nColumns - 2)
                    {
                        if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 2))
                            forTurn(FigureDirection.Left, -2, 1);
                    }

                    if(X == FieldActivity.gameField.nColumns - 3)
                    {
                        if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 2) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1))
                            forTurn(FigureDirection.Left, -1, 1);
                    }
                }
                else
                {
                    if(FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) || FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 2))
                    {
                        if(FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1))
                        {
                            if(X - 3 >= 0 && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 2) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 3))
                                forTurn(FigureDirection.Left, -3, 1);
                        }
                        else
                            if(X - 2 >= 0 && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 2))
                                forTurn(FigureDirection.Left, -2, 1);
                    }
                    else
                    {
                        if(X == 0 || FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1))
                        {
                            if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 2) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 3))
                                forTurn(FigureDirection.Left, 0, 1);
                        }
                        else
                            forTurn(FigureDirection.Left, -1, 1);
                    }

                }
                break;

            case Left:
                if(Y >= FieldActivity.gameField.nRows - 2)
                {
                    if(Y == FieldActivity.gameField.nRows - 1)
                    {
                        if(!FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 2).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 3).get(X + 1))
                            forTurn(FigureDirection.Top, 1, -3);
                    }

                    if(Y == FieldActivity.gameField.nRows - 2)
                    {
                        if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 2).get(X + 1))
                            forTurn(FigureDirection.Top, 1, -2);
                    }
                }
                else
                {
                    if(FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) || FieldActivity.gameField.mapOfField.get(Y + 2).get(X + 1))
                    {
                        if(FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1))
                        {
                            if(Y - 3 >= 0 && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 2).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 3).get(X + 1))
                                forTurn(FigureDirection.Top, 1, -3);
                        }
                        else
                            if(Y - 2 >= 0 && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y - 2).get(X + 2))
                                forTurn(FigureDirection.Top, -2, 1);
                    }
                    else
                    {
                        if(Y == 0 || FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1))
                        {
                            if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 2).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 3).get(X + 1))
                                forTurn(FigureDirection.Top, 1, 0);
                        }
                        else
                            forTurn(FigureDirection.Top, 1, -1);
                    }

                }
                break;

        }
    }

    @Override
    public Pair<Integer, Integer> getTopCoordinate(int leftX, int leftY)
    {
        return new Pair<>(leftX, leftY);
    }

    @Override
    public Pair<Integer, Integer> getRightCoordinate(int leftX, int leftY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(leftX, leftY + 3);

            case Left:
                return new Pair<>(leftX + 3, leftY);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getBottomCoordinate(int leftX, int leftY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(leftX, leftY + 3);

            case Left:
                return new Pair<>(leftX + 3, leftY);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getLeftCoordinate(int leftX, int leftY)
    {
        return new Pair<>(leftX, leftY);
    }

    @Override
    public void draw(int colorCode, int x, int y) {

        FieldActivity.gameField.fieldImages.get(y).get(x).setImageResource(colorCode);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.fieldImages.get(y + 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y + 2).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y + 3).get(x).setImageResource(colorCode);
                break;

            case Left:
                FieldActivity.gameField.fieldImages.get(y).get(x + 1).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x + 2).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x + 3).setImageResource(colorCode);
                break;
        }
    }

    @Override
    public boolean canShow() {
        int x = X;
        int y = Y + 1;
        boolean predicate = true;

        switch (direction)
        {
            case Top:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y + 1).get(x)
                        && !FieldActivity.gameField.mapOfField.get(y + 2).get(x) && !FieldActivity.gameField.mapOfField.get(y + 3).get(x));
                break;

            case Left:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y).get(x + 1)
                        && !FieldActivity.gameField.mapOfField.get(y).get(x + 2) && !FieldActivity.gameField.mapOfField.get(y).get(x + 3));
                break;
        }

        return predicate;
    }

    public int offsetSize(int offset)
    {
        int side;
        int dx;
        if(offset > 0)
        {
            dx = 1;
            side = getRightCoordinate().first;
        }
        else
        {
            dx = -1;
            side = getLeftCoordinate().first;
        }

        boolean predicate = true;
        int realOffset;
        for(realOffset = 0; Math.abs(realOffset) < Math.abs(offset); realOffset += dx)
        {
            switch (direction)
            {
                case Top:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 1).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 2).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 3).get(side + realOffset + dx));
                    break;

                case Left:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx));
                    break;
            }

            if(!predicate)
                break;
        }

        return realOffset;
    }

    @Override
    public void figureToField() {

        FieldActivity.gameField.changeFigure = true;
        FieldActivity.gameField.mapOfField.get(Y).set(X, true);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.mapOfField.get(Y + 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y + 2).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y + 3).set(X, true);
                break;

            case Left:
                FieldActivity.gameField.mapOfField.get(Y).set(X + 1, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X + 2, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X + 3, true);
                break;
        }
    }

}
