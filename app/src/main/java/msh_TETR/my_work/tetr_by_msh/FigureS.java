package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

public final class FigureS extends TetrFigure {

    //X - down angle of figureI at axis OX
    //Y - down angle of figureI at axis OY


    public FigureS(FigureDirection direction, int color){
        if(direction == FigureDirection.Bottom)
            direction = FigureDirection.Top;
        if(direction == FigureDirection.Left)
            direction = FigureDirection.Right;
        this.direction = direction;
        this.color = color;
        initializeCoordinate();
    }

    private void initializeCoordinate() {
        Y = 0;
        X = 5;
    }

    @Override
    public void figureToField() {
        FieldActivity.gameField.changeFigure = true;
        FieldActivity.gameField.mapOfField.get(Y).set(X, true);
        FieldActivity.gameField.mapOfField.get(Y).set(X - 1, true);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.mapOfField.get(Y + 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X - 1, true);
                break;

            case Right:
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X, true);
                FieldActivity.gameField.mapOfField.get(Y - 1).set(X + 1, true);
                break;
        }
    }

    @Override
    public Pair<Integer, Integer> chooseFormPosition() {
        Pair<Integer, Integer> position = new Pair<>(X, Y);
        boolean search = true;

        while (getBottomCoordinate(position.first, position.second).second < FieldActivity.gameField.nRows - 1 && search)
            switch (direction)
            {
                case Top:
                    if(!FieldActivity.gameField.mapOfField.get(position.second + 2).get(position.first)
                    && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first - 1))
                        position = new Pair<>(position.first, position.second + 1);
                    else
                        search = false;
                    break;

                case Right:
                    if(!FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first)
                            && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first - 1)
                            && !FieldActivity.gameField.mapOfField.get(position.second).get(position.first + 1))
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
                if(X == FieldActivity.gameField.nColumns - 1 || FieldActivity.gameField.mapOfField.get(Y).get(X + 1))
                {
                    if(X - 2 >= 0 && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 2))
                        forTurn(FigureDirection.Right, -1, 1);
                }
                else
                    if(FieldActivity.gameField.mapOfField.get(Y + 1).get(X - 1))
                    {
                        if(X + 2 < FieldActivity.gameField.nColumns && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y).get(X + 2))
                            forTurn(FigureDirection.Right, 1, 1);
                    }
                    else
                        forTurn(FigureDirection.Right, 0, 1);
                break;

            case Right:
                if(FieldActivity.gameField.mapOfField.get(Y - 1).get(X - 1))
                {
                    if(Y + 1 < FieldActivity.gameField.nRows && !FieldActivity.gameField.mapOfField.get(Y).get(X + 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + 1))
                        forTurn(FigureDirection.Top, 1, 0);
                }
                else
                    if(Y == 1 || FieldActivity.gameField.mapOfField.get(Y - 2).get(X - 1))
                    {
                        if(Y + 1 < FieldActivity.gameField.nRows && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X - 1) && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X))
                            forTurn(FigureDirection.Top, 0, 0);
                    }
                    else
                        forTurn(FigureDirection.Top, 0, -1);
                break;
        }
    }

    @Override
    public int offsetSize(int offset) {
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
                            && !FieldActivity.gameField.mapOfField.get(Y - 1).get(X - 1 + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                            && !FieldActivity.gameField.mapOfField.get(Y + 1).get(X + realOffset + dx));
                    break;

                case Right:
                    predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                            && (side + realOffset + dx) >= 0
                            && !FieldActivity.gameField.mapOfField.get(Y - 1).get(side + realOffset + (offset > 0 ? dx : 0))
                            && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + (offset < 0 ? dx : 0)));
                    break;
            }

            if(!predicate)
                break;
        }

        return realOffset;
    }

    @Override
    public void draw(int colorCode, int x, int y) {

        FieldActivity.gameField.fieldImages.get(y).get(x).setImageResource(colorCode);
        FieldActivity.gameField.fieldImages.get(y).get(x - 1).setImageResource(colorCode);

        switch (direction)
        {
            case Top:
                FieldActivity.gameField.fieldImages.get(y + 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y - 1).get(x - 1).setImageResource(colorCode);
                break;

            case Right:
                FieldActivity.gameField.fieldImages.get(y - 1).get(x).setImageResource(colorCode);
                FieldActivity.gameField.fieldImages.get(y - 1).get(x + 1).setImageResource(colorCode);
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
                        && !FieldActivity.gameField.mapOfField.get(y).get(x - 1) && !FieldActivity.gameField.mapOfField.get(y - 1).get(x - 1));
                break;

            case Right:
                predicate = (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y - 1).get(x)
                        && !FieldActivity.gameField.mapOfField.get(y).get(x - 1) && !FieldActivity.gameField.mapOfField.get(y - 1).get(x + 1));
                break;

        }

        return predicate;
    }

    @Override
    public Pair<Integer, Integer> getTopCoordinate(int x, int y) {
        switch (direction)
        {
            case Top:
                return new Pair<>(x - 1, y - 1);

            case Right:
                return new Pair<>(x + 1, y - 1);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getRightCoordinate(int x, int y) {
        switch (direction)
        {
            case Top:
                return new Pair<>(x, y);

            case Right:
                return new Pair<>(x + 1, y - 1);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getBottomCoordinate(int x, int y) {
        switch (direction)
        {
            case Top:
                return new Pair<>(x, y + 1);

            case Right:
                return new Pair<>(x - 1, y);
        }

        return new Pair<>(-1, -1);
    }

    @Override
    public Pair<Integer, Integer> getLeftCoordinate(int x, int y) {
        switch (direction)
        {
            case Top:
                return new Pair<>(x - 1, y - 1);

            case Right:
                return new Pair<>(x - 1, y);
        }

        return new Pair<>(-1, -1);
    }
}
