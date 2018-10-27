import java.awt.*;
import java.awt.event.*;
public class AlgoVisualizer{
    private Circle[] circles;
    private AlgoFrame frame;
    //动画是否运行
    private boolean isAnimated=true;

    public AlgoVisualizer(int sceneWidth,int sceneHeight,int N){

        circles = new Circle[N];
        int R = 50;

        for(int i=0;i<N;i++){
            int x = (int)(Math.random()*(sceneWidth-2*R))+R;
            int y = (int)(Math.random()*(sceneHeight-2*R))+R;
            int vx = (int)(Math.random()*10)-5;
            int vy = (int)(Math.random()*10)-5;
            circles[i] = new Circle(x,y,R,vx,vy);
        }

        //swing中的线程的事件分发
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("简单屏保",sceneWidth,sceneHeight);
            //设置监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(()->{
                while(true){
                    run();
                }
            }).start();

        });
    }


    //封装动画的逻辑
    private void run(){
        //绘制数据
        frame.render(circles);
        AlgoViHelper.pause(20);
        if(isAnimated){
            //更新数据
            for(Circle circle: circles){
                circle.move(0,0,frame.getCanvasWeight(),frame.getCanvasHeight());
            }
        }
    }

    //定义一个内部监听器类
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event){
            //检测是否是空格
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }


    //定义一个内部的鼠标监听器
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            //坐标值变换，使得坐标是以JPanel为参照而不是JFrame
            event.translatePoint(0,-(frame.getBounds().height - frame.getCanvasHeight())+5);
            System.out.println("2: "+event.getPoint());
            for(Circle circle:circles)
                if(circle.contains(event.getPoint()))
                    circle.isFilled = !circle.isFilled;
        }
    }

}
