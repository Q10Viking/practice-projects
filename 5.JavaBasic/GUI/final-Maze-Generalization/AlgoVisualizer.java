import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class AlgoVisualizer{
    private static final int BLOCKSIZE = 6;
    private static final int DELAY = 5;

    private static final int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private MazeData mazeData;
    private AlgoFrame frame;
    //标记是否暂停
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

    //对迷宫进行生成的过程
    private void run(){
        setData(-1,-1);

        //使用队列遍历
        RandomQueue<Point> queue = new RandomQueue<Point>();
        Point entrancePoint = new Point(mazeData.getEntranceX(),mazeData.getEntranceY()+1);
        queue.add(entrancePoint);
        //这里主要为了暂停，先不进行遍历
        setData(entrancePoint.getX(),entrancePoint.getY());
        mazeData.visited[entrancePoint.getX()][entrancePoint.getY()]=true;
        mazeData.openMist(entrancePoint.getX(),entrancePoint.getY());

        while(queue.size()!=0){
            Point cur = queue.poll();

            for(int i=0;i<4;i++){
                int x = cur.getX()+d[i][0]*2;
                int y = cur.getY()+d[i][1]*2;
                Point newPoint = new Point(x,y);

                if(mazeData.inArea(x,y) && !mazeData.visited[x][y]){
                    //做好深度遍历的准备
                    queue.add(newPoint);
                    //打通墙壁
                    setData(cur.getX()+d[i][0],cur.getY()+d[i][1]);
                    //标记已经访问的
                    mazeData.visited[x][y]=true;
                    //打开迷雾
                    mazeData.openMist(x,y);
                }


            }

        }

        setData(-1,-1);
        mazeData.initVisited();
        //找路径
        if(!go(mazeData.getEntranceX(),mazeData.getEntranceY()))
            System.out.println("There is no path in the maze.");

        setData(-1,-1);

    }

    private void setData(int x,int y){
        if(mazeData.inArea(x,y)){
            //打破壁垒
            mazeData.maze[x][y] = MazeData.ROAD;

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


    public boolean go(int x,int y){
        mazeData.visited[x][y]=true;
        mazeData.path[x][y]=true;
        setData(-1,-1);
        if(x == mazeData.getExitX() && y == mazeData.getExitY()){
            return true;
        }
        for(int i=0;i<4;i++){
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(mazeData.inArea(newX,newY) && mazeData.maze[newX][newY]==MazeData.ROAD
                && !mazeData.visited[newX][newY] ){
                if(go(newX,newY))
                    return true;
            }
        }
        mazeData.path[x][y]=false;
        setData(-1,-1);
        return false;
    }
}
