package msh_TETR.my_work.tetr_by_msh;

import android.widget.ImageView;
import android.widget.Toast;

import msh_TETR.my_work.tetr_by_msh.R;

import java.util.ArrayList;
import java.util.Random;

public class Field {

    public ArrayList<ArrayList<ImageView>> fieldImages;
    public ArrayList<ArrayList<Boolean>> mapOfField;
    public Figure currentFigure;
    private Figure nextFigure;
    private ImageView nextFigureImage;
    public boolean currentFigureFirstShow;
    public final int nColumns = 10;
    public final int nRows = 18;

    public boolean gameOver;
    public boolean changeFigure;

    private int lastNullLine = nRows - 1;

    private int points = 0;

    public boolean isInterrupt;

    private int delay = 1000;

    private int pointsToIncreaseLevel;

    public Thread thread;



    public Field() {
        fieldImages = new ArrayList<>();
        mapOfField = new ArrayList<>();

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_0));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_1));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_2));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_3));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_4));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_5));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_6));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_7));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_8));
        fieldImages.get(0).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView0_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_0));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_1));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_2));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_3));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_4));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_5));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_6));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_7));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_8));
        fieldImages.get(1).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView1_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_0));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_1));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_2));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_3));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_4));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_5));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_6));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_7));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_8));
        fieldImages.get(2).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView2_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_0));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_1));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_2));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_3));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_4));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_5));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_6));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_7));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_8));
        fieldImages.get(3).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView3_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_0));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_1));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_2));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_3));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_4));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_5));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_6));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_7));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_8));
        fieldImages.get(4).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView4_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_0));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_1));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_2));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_3));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_4));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_5));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_6));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_7));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_8));
        fieldImages.get(5).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView5_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_0));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_1));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_2));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_3));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_4));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_5));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_6));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_7));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_8));
        fieldImages.get(6).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView6_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_0));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_1));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_2));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_3));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_4));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_5));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_6));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_7));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_8));
        fieldImages.get(7).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView7_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_0));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_1));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_2));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_3));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_4));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_5));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_6));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_7));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_8));
        fieldImages.get(8).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView8_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_0));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_1));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_2));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_3));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_4));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_5));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_6));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_7));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_8));
        fieldImages.get(9).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView9_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_0));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_1));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_2));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_3));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_4));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_5));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_6));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_7));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_8));
        fieldImages.get(10).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView10_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_0));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_1));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_2));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_3));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_4));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_5));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_6));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_7));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_8));
        fieldImages.get(11).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView11_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_0));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_1));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_2));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_3));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_4));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_5));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_6));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_7));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_8));
        fieldImages.get(12).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView12_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_0));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_1));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_2));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_3));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_4));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_5));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_6));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_7));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_8));
        fieldImages.get(13).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView13_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_0));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_1));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_2));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_3));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_4));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_5));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_6));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_7));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_8));
        fieldImages.get(14).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView14_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_0));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_1));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_2));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_3));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_4));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_5));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_6));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_7));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_8));
        fieldImages.get(15).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView15_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_0));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_1));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_2));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_3));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_4));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_5));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_6));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_7));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_8));
        fieldImages.get(16).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView16_9));

        fieldImages.add(new ArrayList<ImageView>());
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_0));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_1));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_2));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_3));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_4));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_5));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_6));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_7));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_8));
        fieldImages.get(17).add((ImageView) FieldActivity.fieldActivity.findViewById(R.id.imageView17_9));

        gameOver = false;
        isInterrupt = false;

        for (int i = 0; i < nRows; ++i) {
            mapOfField.add(new ArrayList<Boolean>());
            for (int j = 0; j < nColumns; ++j) {
                mapOfField.get(i).add(false);
                fieldImages.get(i).get(j).setImageResource(R.drawable.midnight_blue);
            }
        }

        nextFigureImage = FieldActivity.fieldActivity.findViewById(R.id.imageViewNext);

        nextFigure = getRandomFigure();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FieldActivity.fieldActivity.getApplicationContext(), "level: 1", Toast.LENGTH_LONG).show();
                    }
                });
                pointsToIncreaseLevel = 500;


                while (!gameOver)
                {
                    currentFigureFirstShow = true;
                    changeFigure = false;
                    currentFigure = nextFigure;
                    nextFigure = getRandomFigure();
                    if(currentFigure.canShow())
                    {
                        while (!changeFigure)
                        {
                            if(!isInterrupt)
                            {
                                FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(currentFigureFirstShow)
                                        {
                                            currentFigure.setFormPosition();
                                            currentFigure.drawForm();
                                        }

                                        currentFigure.reDrawFigure();

                                        if(currentFigureFirstShow)
                                            currentFigureFirstShow = false;
                                    }
                                });

                                try {
                                    Thread.sleep(delay);
                                } catch (Exception e) {
                                    gameOver = true;
                                    mapOfField.clear();
                                    fieldImages.clear();
                                    break;
                                }
                            }
                        }
                        if(!gameOver) {
                            deleteFullLines();
                            points += 10;
                            changeLevel();
                            updatePointsView();
                        }
                    }
                    else
                    {
                        gameOver = true;
                        FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(FieldActivity.fieldActivity.getApplicationContext(), "Игра закончена!", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }
        });

        thread.start();

    }

    private void changeLevel()
    {
        if(points >= pointsToIncreaseLevel) {
            delay /= 1.2;
            pointsToIncreaseLevel += 500;
            FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(FieldActivity.fieldActivity.getApplicationContext(), "level: " + String.valueOf(points/500 + 1), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void updatePointsView()
    {
        FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FieldActivity.fieldActivity.pointView.setText("Очки: " + String.valueOf(points));
            }
        });
    }

    private void deleteFullLines()
    {
        lastNullLine -= 4;
        if(lastNullLine < 0 )
            lastNullLine = 0;
        while (lastNullLine < nRows)
        {
            boolean out = false;
            for (int i = 0; i < nColumns; ++i)
                if(mapOfField.get(lastNullLine + 1).get(i))
                {
                    out = true;
                    break;
                }
            if(out)
                break;
            ++lastNullLine;
        }

        for (int i = lastNullLine + 1; i < nRows; ++i)
        {
            int j;
            for (j = 0; j < nColumns; ++j)
                if(!mapOfField.get(i).get(j))
                    break;
            if(j == nColumns)
            {
                mapOfField.remove(i);
                mapOfField.add(0, new ArrayList<Boolean>());
                for(int k = 0; k < nColumns; ++k)
                    mapOfField.get(0).add(false);

                final int v = i;
                FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(int z = 0; z < nColumns; ++z)
                            fieldImages.get(v).get(z).setImageResource(R.drawable.midnight_blue);
                    }
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(int k = v; k > lastNullLine; --k)
                            for(int el = 0; el < nColumns; ++el)
                                fieldImages.get(k).get(el).setImageDrawable(fieldImages.get(k - 1).get(el).getDrawable());
                    }
                });

                points += 50;
            }
        }
    }

    private TetrFigure getRandomFigure()
    {
        FigureDirection randomDirection = FigureDirection.getRandomDirection();
        int randomColor = getRandomColor();
        int random = new Random().nextInt(6);
        TetrFigure randomFigure = null;

        switch (random)
        {
            case 0:
                randomFigure = new FigureT(randomDirection, randomColor);
                break;
            case 1:
                randomFigure = new FigureI(randomDirection, randomColor);
                break;
            case 2:
                randomFigure = new FigureO(randomDirection, randomColor);
                break;
            case 3:
                randomFigure = new FigureJ(randomDirection, randomColor);
                break;
            case 4:
                randomFigure = new FigureL(randomDirection, randomColor);
                break;
            case 5:
                randomFigure = new FigureS(randomDirection, randomColor);
                break;
            case 6:
                randomFigure = new FigureZ(randomDirection, randomColor);
                break;
        }

        chooseFigureImage(random, randomDirection, randomColor);

        return randomFigure;
    }

    private int getRandomColor()
    {
        switch (new Random().nextInt(7))
        {
            case 0:
                return R.drawable.blue;
            case 1:
                return R.drawable.green;
            case 2:
                return R.drawable.orange;
            case 3:
                return R.drawable.red;
            case 4:
                return R.drawable.violet;
            case 5:
                return R.drawable.yellow;
            case 6:
                return R.drawable.light_blue;
            default:
                return -1;
        }
    }

    private void chooseFigureImage(final int figure, final FigureDirection randomDirection, final int randomColor)
    {
        FieldActivity.fieldActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (figure){
                    case 0:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_blue_left);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_green_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_green_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_green_left);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_orange_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_orange_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_orange_left);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_red_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_red_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_red_left);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_violet_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_violet_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_violet_left);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_yellow_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_yellow_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_yellow_left);
                                        break;
                                }
                            break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_light_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_light_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_t_light_blue_left);
                                        break;
                                }
                                break;
                        }
                        break;

                    case 1:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_blue_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_blue_left);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_green_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_green_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_green_left);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_orange_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_orange_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_orange_left);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_red_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_red_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_red_left);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_violet_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_violet_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_violet_left);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_yellow_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_yellow_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_yellow_left);
                                        break;
                                }
                                break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_light_blue_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_light_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_i_light_blue_left);
                                        break;
                                }
                                break;
                        }
                        break;

                    case 2:
                        switch (randomColor){
                            case R.drawable.blue:
                                nextFigureImage.setImageResource(R.drawable.figure_o_blue_top);
                                break;

                            case R.drawable.green:
                                nextFigureImage.setImageResource(R.drawable.figure_o_green_top);
                                break;

                            case R.drawable.orange:
                                nextFigureImage.setImageResource(R.drawable.figure_o_orange_top);
                                break;

                            case R.drawable.red:
                                nextFigureImage.setImageResource(R.drawable.figure_o_red_top);
                                break;

                            case R.drawable.violet:
                                nextFigureImage.setImageResource(R.drawable.figure_o_violet_top);
                                break;

                            case R.drawable.yellow:
                                nextFigureImage.setImageResource(R.drawable.figure_o_yellow_top);
                                break;

                            case R.drawable.light_blue:
                                nextFigureImage.setImageResource(R.drawable.figure_o_light_blue_top);
                                break;
                        }
                        break;

                    case 3:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_blue_left);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_green_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_green_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_green_left);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_orange_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_orange_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_orange_left);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_red_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_red_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_red_left);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_violet_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_violet_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_violet_left);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_yellow_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_yellow_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_yellow_left);
                                        break;
                                }
                                break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_light_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_light_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_j_light_blue_left);
                                        break;
                                }
                                break;
                        }
                        break;

                    case 4:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_blue_left);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_green_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_green_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_green_left);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_orange_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_orange_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_orange_left);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_red_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_red_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_red_left);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_violet_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_violet_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_violet_left);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_yellow_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_yellow_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_yellow_left);
                                        break;
                                }
                                break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_light_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_light_blue_bottom);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_l_light_blue_left);
                                        break;
                                }
                                break;
                        }
                        break;

                    case 5:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_blue_right);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_green_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_green_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_green_right);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_orange_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_orange_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_orange_right);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_red_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_red_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_red_right);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_violet_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_violet_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_violet_right);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_yellow_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_yellow_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_yellow_right);
                                        break;
                                }
                                break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_light_blue_right);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_light_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_s_light_blue_right);
                                        break;
                                }
                                break;
                        }
                        break;

                    case 6:
                        switch (randomColor){
                            case R.drawable.blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_blue_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_blue_left);
                                        break;
                                }
                                break;

                            case R.drawable.green:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_green_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_green_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_green_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_green_left);
                                        break;
                                }
                                break;

                            case R.drawable.orange:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_orange_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_orange_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_orange_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_orange_left);
                                        break;
                                }
                                break;

                            case R.drawable.red:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_red_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_red_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_red_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_red_left);
                                        break;
                                }
                                break;

                            case R.drawable.violet:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_violet_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_violet_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_violet_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_violet_left);
                                        break;
                                }
                                break;

                            case R.drawable.yellow:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_yellow_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_yellow_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_yellow_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_yellow_left);
                                        break;
                                }
                                break;

                            case R.drawable.light_blue:
                                switch (randomDirection){
                                    case Top:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_light_blue_top);
                                        break;
                                    case Right:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_light_blue_left);
                                        break;
                                    case Bottom:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_light_blue_top);
                                        break;
                                    case Left:
                                        nextFigureImage.setImageResource(R.drawable.figure_z_light_blue_left);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
        });

    }
}
