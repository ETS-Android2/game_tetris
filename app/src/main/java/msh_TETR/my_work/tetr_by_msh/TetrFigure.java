package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

import msh_TETR.my_work.tetr_by_msh.R;

public abstract class TetrFigure implements Figure{

    protected FigureDirection direction;
    protected int color;
    protected int X;
    protected int Y;
    protected Pair<Integer, Integer> formPosition;

    public void reDrawFigure() {
        if(canDown())
        {
            if(!FieldActivity.gameField.currentFigureFirstShow)
                wipeOffFigure();

            ++Y;

            drawFigure();
        }
        else
            figureToField();
    }

    public boolean canDown()
    {
        return Y < formPosition.second;
    }

    public void drawForm() {
        draw(R.drawable.grey, formPosition.first, formPosition.second);
    }

    public void wipeOffForm() { draw(R.drawable.midnight_blue, formPosition.first, formPosition.second); }

    public void drawFigure() { draw(color, X, Y); }

    public void wipeOffFigure() {
        draw(R.drawable.midnight_blue, X, Y);
    }

    public void toDown() {
        wipeOffForm();
        wipeOffFigure();

        Y = formPosition.second;

        drawFigure();
    }

    public Pair<Integer, Integer> getTopCoordinate()
    {
        return getTopCoordinate(X, Y);
    }

    public Pair<Integer, Integer> getRightCoordinate()
    {
        return getRightCoordinate(X, Y);
    }

    public Pair<Integer, Integer> getBottomCoordinate() {
        return getBottomCoordinate(X, Y);
    }

    public Pair<Integer, Integer> getLeftCoordinate()
    {
        return getLeftCoordinate(X, Y);
    }

    public void sideSwipe(final float dx) {

        int offset = (int) (dx / 250 + (dx > 0? 1:-1));

        if(!((getLeftCoordinate().first == 0 && offset < 0)||(getRightCoordinate().first == FieldActivity.gameField.nColumns - 1 && offset > 0)))
        {
            wipeOffForm();
            wipeOffFigure();

            X += offsetSize(offset);

            formPosition = chooseFormPosition();
            drawForm();
            drawFigure();
        }
    }

    protected void forTurn(FigureDirection dir, int dx, int dy)
    {
        wipeOffForm();
        wipeOffFigure();
        X += dx;
        Y += dy;
        direction = dir;
        formPosition = chooseFormPosition();
        drawForm();
        drawFigure();
    }

    public void setFormPosition()
    {
        if(FieldActivity.gameField.currentFigureFirstShow)
            formPosition = chooseFormPosition();
    }

}
