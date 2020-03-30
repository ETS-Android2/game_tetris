package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

public final class FigureT extends TetrFigure {

    //X - center of figureT at axis OX
    //Y - center of figureT at axis OY

    public FigureT(FigureDirection direction, int color){
        this.direction = direction;
        this.color = color;
        initializeCoordinate();
    }

    private void initializeCoordinate()
    {
        if(direction == FigureDirection.Bottom)
            Y = -1;
        else
            Y = 0;
        X = 5;
    }

    @Override
    public void draw(int colorCode, int x, int y) {

        FieldActivity.gameField.fieldImages.get(y).get(x).setImageResource(colorCode);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.fieldImages.get(y - 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x - 1).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x + 1).setImageResource(colorCode);
                break;

            case Right:
                FieldActivity.gameField.fieldImages.get(y - 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x + 1).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y + 1).get(x).setImageResource(colorCode);
                break;

            case Bottom:
                FieldActivity.gameField.fieldImages.get(y).get(x + 1).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y + 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x - 1).setImageResource(colorCode);
                break;

            case Left:
                FieldActivity.gameField.fieldImages.get(y + 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y).get(x - 1).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y - 1).get(x).setImageResource(colorCode);
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
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y - 1).get(x)
                && !FieldActivity.gameField.mapOfField.get(y).get(x - 1) && !FieldActivity.gameField.mapOfField.get(y).get(x + 1));
                break;

            case Right:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y).get(x + 1)
                        && !FieldActivity.gameField.mapOfField.get(y - 1).get(x) && !FieldActivity.gameField.mapOfField.get(y + 1).get(x));
                break;

            case Bottom:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y).get(x + 1)
                        && !FieldActivity.gameField.mapOfField.get(y).get(x - 1) && !FieldActivity.gameField.mapOfField.get(y + 1).get(x));
                break;

            case Left:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y).get(x - 1)
                        && !FieldActivity.gameField.mapOfField.get(y - 1).get(x) && !FieldActivity.gameField.mapOfField.get(y + 1).get(x));
                break;
        }

        return predicate;
    }

    @Override
    public Pair<Integer, Integer> getTopCoordinate(int centerX, int centerY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(centerX, centerY - 1);

            case Right:
                return new Pair<>(centerX, centerY - 1);

            case Bottom:
                return new Pair<>(centerX, centerY);

            case Left:
                return new Pair<>(centerX, centerY - 1);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getRightCoordinate(int centerX, int centerY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(centerX + 1, centerY);

            case Right:
                return new Pair<>(centerX + 1, centerY);

            case Bottom:
                return new Pair<>(centerX + 1, centerY);

            case Left:
                return new Pair<>(centerX, centerY);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getBottomCoordinate(int centerX, int centerY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(centerX, centerY);

            case Right:
                return new Pair<>(centerX, centerY + 1);

            case Bottom:
                return new Pair<>(centerX, centerY + 1);

            case Left:
                return new Pair<>(centerX, centerY + 1);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getLeftCoordinate(int centerX, int centerY)
    {
        switch (direction)
        {
            case Top:
                return new Pair<>(centerX - 1, centerY);

            case Right:
                return new Pair<>(centerX, centerY);

            case Bottom:
                return new Pair<>(centerX - 1, centerY);

            case Left:
                return new Pair<>(centerX - 1, centerY);
        }

        return new Pair<>(-1, -1);
    }

    @Override
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
                            && !FieldActivity.gameField.mapOfField.get(Y - 1).get(side + realOffset));
                    break;

                case Right:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X + realOffset + dx));
                    break;

                case Bottom:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 1).get(side + realOffset));
                    break;

                case Left:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X + realOffset + dx));
                    break;
            }

            if(!predicate)
                break;
        }

        return realOffset;
    }

    @Override
    public void turnFigure() {

        switch (direction)
        {
            case Left:
                if(X == FieldActivity.gameField.nColumns - 1 || FieldActivity.gameField.mapOfField.get(Y).get(X + 1))
                {
                    if(!FieldActivity.gameField.mapOfField.get(Y - 1).get(X - 1) && X - 2 >= 0 && !FieldActivity.gameField.mapOfField.get(Y).get(X - 2))
                        forTurn(FigureDirection.Top, -1, 0);
                }
                else
                    forTurn(FigureDirection.Top, 0, 0);
                break;

            case Top:
                if(Y == FieldActivity.gameField.nRows - 1 || FieldActivity.gameField.mapOfField.get(Y + 1).get(X))
                {
                    if(!FieldActivity.gameField.mapOfField.get(Y - 1).get(X + 1) && Y - 2 >= 0 && !FieldActivity.gameField.mapOfField.get(Y - 2).get(X))
                        forTurn(FigureDirection.Right, 0, -1);
                }
                else
                    forTurn(FigureDirection.Right, 0, 0);
                break;

            case Right:
                if(X == 0 || FieldActivity.gameField.mapOfField.get(Y).get(X - 1))
                {
                    if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && X + 2 < FieldActivity.gameField.nColumns && !FieldActivity.gameField.mapOfField.get(Y).get(X + 2))
                        forTurn(FigureDirection.Bottom, 1, 0);
                }
                else
                    forTurn(FigureDirection.Bottom, 0, 0);
                break;

            case Bottom:
                if(Y == 0 || FieldActivity.gameField.mapOfField.get(Y - 1).get(X))
                {
                    if(!FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && Y + 2 < FieldActivity.gameField.nRows && !FieldActivity.gameField.mapOfField.get(Y + 2).get(X))
                        forTurn(FigureDirection.Left, 0, 1);
                }
                else
                    forTurn(FigureDirection.Left, 0, 0);
                break;
        }
    }

    @Override
    public Pair<Integer, Integer> chooseFormPosition()
    {
        Pair<Integer, Integer> position = new Pair<>(X, Y);
        boolean search = true;

        while (getBottomCoordinate(position.first, position.second).second < FieldActivity.gameField.nRows - 1 && search) {
            switch (direction) {
                case Top:
                    if (!FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first - 1)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 1))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;

                case Right:
                    if (!FieldActivity.gameField.mapOfField.get(position.second + 2).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 1))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;

                case Bottom:
                    if (!FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first - 1)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 2).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 1))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;

                case Left:
                    if (!FieldActivity.gameField.mapOfField.get(position.second + 2).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first - 1))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;
            }
        }

        return position;
    }

    @Override
    public void figureToField()
    {
        FieldActivity.gameField.changeFigure = true;
        FieldActivity.gameField.mapOfField.get(Y).set(X, true);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.mapOfField.get(Y).set(X - 1, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X + 1, true);
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X, true);
                break;

            case Right:
                FieldActivity.gameField.mapOfField.get(Y + 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X + 1, true);
                break;

            case Bottom:
                FieldActivity.gameField.mapOfField.get(Y).set(X + 1, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X - 1, true);
                FieldActivity.gameField.mapOfField.get(Y + 1).set(X, true);
                break;

            case Left:
                FieldActivity.gameField.mapOfField.get(Y + 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y).set(X - 1, true);
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X, true);
                break;
        }
    }

}
