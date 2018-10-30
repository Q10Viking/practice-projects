import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class AlgoVisualizer{
    private static final int BLOCKSIZE = 20;
    private static final int DELAY = 5;

    private static final int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private MazeData mazeData;
    private AlgoFrame frame;
    //����Ƿ���ͣ
    private boolean isAnimated = true;
    public AlgoVisualizer(int n,int m){
        mazeData = new MazeData(n,m);
        int sceneWidth = BLOCKSIZE*m;
        int sceneHeight = BLOCKSIZE*n;
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Maze Generalization",sceneWidth,sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            new Thread(()->{
                    run();
            }).start();

        });


    }

    //���Թ��������ɵĹ���
    private void run(){
        setData(-1,-1);

        //ʹ�ö��б���
        RandomQueue<Point> queue = new RandomQueue<Point>();
        Point entrancePoint = new Point(mazeData.getEntranceX(),mazeData.getEntranceY()+1);
        queue.add(entrancePoint);
        //������ҪΪ����ͣ���Ȳ����б���
        setData(entrancePoint.getX(),entrancePoint.getY());
        mazeData.visited[entrancePoint.getX()][entrancePoint.getY()]=true;

        while(queue.size()!=0){
            Point cur = queue.poll();

            for(int i=0;i<4;i++){
                int x = cur.getX()+d[i][0]*2;
                int y = cur.getY()+d[i][1]*2;
                Point newPoint = new Point(x,y);

                if(mazeData.inArea(x,y) && !mazeData.visited[x][y]){
                    //������ȱ�����׼��
                    queue.add(newPoint);
                    //��ͨǽ��
                    setData(cur.getX()+d[i][0],cur.getY()+d[i][1]);
                    //����Ѿ����ʵ�
                    mazeData.visited[x][y]=true;

                }
            }

        }



        setData(-1,-1);

    }

    private void setData(int x,int y){
        if(mazeData.inArea(x,y)){
            //���Ʊ���
            mazeData.maze[x][y] = MazeData.ROAD;

            //�����㷨���������Թ�
            while(isAnimated){
             AlgoHelper.pause(DELAY); //��Ҫʱ����Ӧ����
             //System.out.println("Waiting...");
            }
            isAnimated = true;

        }

        frame.render(mazeData);
        AlgoHelper.pause(DELAY);

    }



    //�ܹ�һ����ִ�в鿴�Թ�������
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event){
            //����Ƿ��ǿո�
            if(event.getKeyChar() == ' ')
                isAnimated = false;
        }
    }

}
