package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

public final class FigureO extends TetrFigure {

    //X - left down of figureI at axis OX
    //Y - left down of figureI at axis OY


    public FigureO(FigureDirection direction, int color){
        this.direction = FigureDirection.Top;
        this.color = color;
        initializeCoordinate();
    }

    private void initializeCoordinate()
    {
        Y = 0;
        X = 4;
    }

    @Override
    public Pair<Integer, Integer> chooseFormPosition() {
        Pair<Integer, Integer> position = new Pair<>(X, Y);
        boolean search = true;

        while (getBottomCoordinate(position.first, position.second).second < FieldActivity.gameField.nRows - 1 && search)
        {
            if(!FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first)
                    && !FieldActivity.gameField.mapOfField.get(position.second + 1).get(position.first + 1))
                position = new Pair<>(position.first, position.second + 1);
            else
                search = false;
        }

        return position;
    }

    @Override
    public void turnFigure() {

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
            predicate = ((side + realOffset + dx) < FieldActivity.gameField.nColumns
                    && (side + realOffset + dx) >= 0
                    && !FieldActivity.gameField.mapOfField.get(Y).get(side + realOffset + dx)
                    && !FieldActivity.gameField.mapOfField.get(Y - 1).get(side + realOffset + dx));

            if(!predicate)
                break;

        }

        return realOffset;
    }

    @Override
    public Pair<Integer, Integer> getTopCoordinate(int x, int y) {
        return new Pair<>(x + 1, y - 1);
    }

    @Override
    public Pair<Integer, Integer> getRightCoordinate(int x, int y) {
        return new Pair<>(x + 1, y - 1);
    }

    @Override
    public Pair<Integer, Integer> getBottomCoordinate(int x, int y) {
        return new Pair<>(x, y);
    }

    @Override
    public Pair<Integer, Integer> getLeftCoordinate(int x, int y) {
        return new Pair<>(x, y);
    }

    @Override
    public void figureToField()
    {
        FieldActivity.gameField.changeFigure = true;
        FieldActivity.gameField.mapOfField.get(Y).set(X, true);
        FieldActivity.gameField.mapOfField.get(Y).set(X + 1, true);
        FieldActivity.gameField.mapOfField.get(Y - 1).set(X, true);
        FieldActivity.gameField.mapOfField.get(Y - 1).set(X + 1, true);
    }

    @Override
    public void draw(int colorCode, int x, int y) {

        FieldActivity.gameField.fieldImages.get(y).get(x).setImageResource(colorCode);

        FieldActivity.gameField.fieldImages.get(y).get(x + 1).setImageResource(colorCode);
        FieldActivity.gameField.fieldImages.get(y - 1).get(x).setImageResource(colorCode);
        FieldActivity.gameField.fieldImages.get(y - 1).get(x + 1).setImageResource(colorCode);
    }

    @Override
    public boolean canShow() {
        int x = X;
        int y = Y + 1;

        return (!FieldActivity.gameField.mapOfField.get(y).get(x) && !FieldActivity.gameField.mapOfField.get(y - 1).get(x)
                && !FieldActivity.gameField.mapOfField.get(y - 1).get(x + 1) && !FieldActivity.gameField.mapOfField.get(y).get(x + 1));
    }

}
