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

    private void run(){
        setData(-1,-1);

        //使用stack遍历
        Stack<Point> stack = new Stack<Point>();
        Point entrancePoint = new Point(mazeData.getEntranceX(),mazeData.getEntranceY()+1);
        stack.push(entrancePoint);
        //这里主要为了暂停，先不进行遍历
        setData(entrancePoint.getX(),entrancePoint.getY());
        mazeData.visited[entrancePoint.getX()][entrancePoint.getY()]=true;

        while(!stack.isEmpty()){
            Point cur = stack.pop();

            for(int i=0;i<4;i++){
                int x = cur.getX()+d[i][0]*2;
                int y = cur.getY()+d[i][1]*2;
                Point newPoint = new Point(x,y);

                if(mazeData.inArea(x,y) && !mazeData.visited[x][y]){
                    //做好深度遍历的准备
                    stack.push(newPoint);
                    //打通墙壁
                    setData(cur.getX()+d[i][0],cur.getY()+d[i][1]);
                    //标记已经访问的
                    mazeData.visited[x][y]=true;

                }
            }

        }



        setData(-1,-1);

    }

    private void setData(int x,int y){
        if(mazeData.inArea(x,y)){
            //打破壁垒
            mazeData.maze[x][y] = MazeData.ROAD;

            //阻塞算法进行生成迷宫
            while(isAnimated){
             AlgoHelper.pause(DELAY); //需要时间响应键盘
             //System.out.println("Waiting...");
            }
            isAnimated = true;
        }

        frame.render(mazeData);
        AlgoHelper.pause(DELAY);

    }



    //能够一步步执行查看迷宫的生成
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event){
            //检测是否是空格
            if(event.getKeyChar() == ' ')
                isAnimated = false;
        }
    }

}
