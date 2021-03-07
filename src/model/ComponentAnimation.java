package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class ComponentAnimation implements Observer {

    private GraphicsContext g;
    private double x, y, r;
    private double x1, y1, x2, y2, x3, y3;
    private double cX, cY;
    private Rotate rotate;
    private double angle;

    public ComponentAnimation(GraphicsContext g){
        this.g = g;
        x = (g.getCanvas().getWidth() / 4);
        y = (g.getCanvas().getHeight() / 4);
        r = g.getCanvas().getWidth() / 2;
        cX = g.getCanvas().getWidth() / 2;
        cY = g.getCanvas().getHeight() / 2;



        /*x1 = g.getCanvas().getWidth() / 2;
        y1 = g.getCanvas().getHeight() / 2;
        x2 = g.getCanvas().getWidth() / 2;
        y2 = g.getCanvas().getHeight() / 2 - r / 2;*/
        angle = 270;
        rotate = new Rotate(angle, g.getCanvas().getWidth() / 2, g.getCanvas().getHeight() / 2);
    }

    private void moveCircle(Subject st) {
        int ticks = st.getState();
        int hours = (int)Math.floor(ticks / 60 / 60);
        int minutes = (int)Math.floor(ticks / 60);
        int seconds = (int)(ticks % 60);

        deleteCircle();

        rotate.setAngle(angle);
        g.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(), rotate.getTx(), rotate.getTy());
        createCircle(hours, minutes, seconds);
    }

    public void createCircle(int h, int m, int s) {
        x1 = cX + (g.getCanvas().getWidth() / 4 / 2) * Math.cos(h * 0.523599);
        y1 = cY + (g.getCanvas().getWidth() / 4 / 2) * Math.sin(h * 0.523599);
        x2 = cX + g.getCanvas().getWidth() / 4 * Math.cos(m * 0.10472);
        y2 = cY + g.getCanvas().getWidth() / 4 * Math.sin(m * 0.10472);
        x3 = cX + g.getCanvas().getWidth() / 4 * Math.cos(s * 0.10472);
        y3 = cY + g.getCanvas().getWidth() / 4 * Math.sin(s * 0.10472);

        //g.setFill(Color.RED);
        //g.fillOval(x, y, r, r);

        for (int i = 0; i <= 11; i++){
            double xx = cX + (g.getCanvas().getWidth() / 4 - 10)  * Math.cos(i * 0.523599);
            double yy = cX + (g.getCanvas().getWidth() / 4 - 10)  * Math.sin(i * 0.523599);
            g.setFill(Color.BLUE);
            g.fillOval(xx + 3,yy + 3,6,6);
        }

        g.setLineWidth(5);
        g.strokeLine(x1, y1, cX, cY);
        g.strokeLine(x2, y2, cX, cY);
        g.setLineWidth(2);
        g.strokeLine(x3, y3, cX, cY);


    }

    public void deleteCircle(){
        g.clearRect(0,0,1000,1000);
    }

    @Override
    public void update(Subject st) {

        moveCircle(st);
    }

}
