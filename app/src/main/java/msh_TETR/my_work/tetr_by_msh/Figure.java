package msh_TETR.my_work.tetr_by_msh;

import android.util.Pair;

interface Figure {


    public void reDrawFigure();

    public void drawFigure();
    public void wipeOffFigure();

    public void sideSwipe(float dx);

    public boolean canDown();

    public void figureToField();

    public void setFormPosition();

    public Pair<Integer, Integer> chooseFormPosition();

    public void turnFigure();

    public void toDown();

    public void drawForm();
    public void wipeOffForm();

    public int offsetSize(int offset);

    //public void setFormPosition();

    public void draw(int colorCode, int x, int y);

    public boolean canShow();

    public Pair<Integer, Integer> getTopCoordinate();
    public Pair<Integer, Integer> getRightCoordinate();
    public Pair<Integer, Integer> getBottomCoordinate();
    public Pair<Integer, Integer> getLeftCoordinate();


    public Pair<Integer, Integer> getTopCoordinate(int x, int y);
    public Pair<Integer, Integer> getRightCoordinate(int x, int y);
    public Pair<Integer, Integer> getBottomCoordinate(int x, int y);
    public Pair<Integer, Integer> getLeftCoordinate(int x, int y);

}
