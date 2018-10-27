import java.awt.*;
import java.awt.event.*;
public class AlgoVisualizer{
    private Circle[] circles;
    private AlgoFrame frame;
    //�����Ƿ�����
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

        //swing�е��̵߳��¼��ַ�
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("������",sceneWidth,sceneHeight);
            //���ü�����
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(()->{
                while(true){
                    run();
                }
            }).start();

        });
    }


    //��װ�������߼�
    private void run(){
        //��������
        frame.render(circles);
        AlgoViHelper.pause(20);
        if(isAnimated){
            //��������
            for(Circle circle: circles){
                circle.move(0,0,frame.getCanvasWeight(),frame.getCanvasHeight());
            }
        }
    }

    //����һ���ڲ���������
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event){
            //����Ƿ��ǿո�
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }


    //����һ���ڲ�����������
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            //����ֵ�任��ʹ����������JPanelΪ���ն�����JFrame
            event.translatePoint(0,-(frame.getBounds().height - frame.getCanvasHeight())+5);
            System.out.println("2: "+event.getPoint());
            for(Circle circle:circles)
                if(circle.contains(event.getPoint()))
                    circle.isFilled = !circle.isFilled;
        }
    }

}
