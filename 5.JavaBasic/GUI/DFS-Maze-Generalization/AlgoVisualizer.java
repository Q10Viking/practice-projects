import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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


        go(mazeData.getEntranceX(),mazeData.getEntranceY()+1);

        setData(-1,-1);

    }

    private void setData(int x,int y){
        if(mazeData.inArea(x,y)){
            mazeData.maze[x][y] = MazeData.ROAD;

            while(isAnimated){
             AlgoHelper.pause(DELAY); //��Ҫʱ����Ӧ����
             //System.out.println("Waiting...");
            }
            isAnimated = true;
        }

        frame.render(mazeData);
        AlgoHelper.pause(DELAY);

    }

    //��ȱ���ͼ
    private void go(int x,int y){

        if(!mazeData.inArea(x,y))
            throw new IllegalArgumentException("x,y are out of index in go function!");
        System.out.println("x="+x+"  y="+y);
        mazeData.visited[x][y]=true;

        for(int i=0;i<4;i++){
            int newX = x+d[i][0]*2;
            int newY = y+d[i][1]*2;
            if(mazeData.inArea(newX,newY) && !mazeData.visited[newX][newY]){
                //�м��ǽ����ͨ
                setData(x+d[i][0],y+d[i][1]);
                go(newX,newY);
            }

        }
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
