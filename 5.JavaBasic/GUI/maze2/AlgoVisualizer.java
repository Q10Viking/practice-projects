import java.awt.*;
import java.util.*;
public class AlgoVisualizer{
    private static int blockSize=6;
    private static int DELAY=10;
    private MazeData maze;
    private AlgoFrame frame;
    //一个位置的四个方向
    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public AlgoVisualizer(String filename){
        maze = new MazeData(filename);
        int sceneHeight = maze.getN()*blockSize;
        int sceneWidth = maze.getM()*blockSize;

        //初始化视图
        EventQueue.invokeLater(()->{
            frame = new AlgoFrame("Maze Solver Visualization",sceneWidth,sceneHeight);

            new Thread(()->{
                run();
            }).start();

        });
    }


    private void run(){
        setData();

        //使用栈的方式代替递归

        Stack<Position> stack = new Stack<Position>();
        Position entrance = new Position(maze.getEntranceX(),maze.getEntranceY());
        stack.push(entrance);
        maze.visited[entrance.getX()][entrance.getY()]=true;
        setData();

        while(!stack.isEmpty()){
            Position position = stack.pop();


            if(position.getX()==maze.getExitX() && position.getY() == maze.getExitY()){
                //找到了终点，那就找到path
                generate_Full_Path(position);
                break;
            }

            for(int i=0;i<4;i++){
                int newX = position.getX()+d[i][0];
                int newY = position.getY()+d[i][1];
                Position newPos = new Position(newX,newY,position);
                if(maze.inArea(newX,newY)
                    && maze.getMaze(newX,newY) == MazeData.ROAD
                    && !maze.visited[newX][newY]){

                    stack.push(newPos);
                    maze.visited[newPos.getX()][newPos.getY()]=true;
                    setData();
                }

            }
        }

        if(stack.isEmpty())
            System.out.println("The maze has no solution.");
        setData();

    }

    //根据终点目标，生成路径
    private void generate_Full_Path(Position des){
        Position current = des;
        while(current!=null){
            maze.path[current.getX()][current.getY()] = true;
            current = current.getPrev();
        }
    }

    private void setData(){
        frame.render(maze);
        AlgoHelper.pause(DELAY);
    }
}
