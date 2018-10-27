import java.io.*;
import java.util.Scanner;
public class MazeData{

    public static final char WALL='#';
    public static final char ROAD=' ';
    //指定迷宫入口与出口
    private int entranceX,entranceY;
    private int exitX,exitY;

    private int N,M;
    private char[][] maze;
    public boolean[][] visited;
    public boolean[][] path;
    public MazeData(String filename){
        if(filename == null)
            throw new IllegalArgumentException("Filename can not be null!");
        Scanner scanner = null;
        try{
            File file = new File(filename);
            if(!file.exists())
                throw new IllegalArgumentException("File "+filename+" doesn't exist.");
            FileInputStream fileStream = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fileStream),"UTF-8");

            //读取第一行
            String nmline = scanner.nextLine();
            String[] nm = nmline.trim().split("\\s+");
            //System.out.println(nm[0]+" "+nm[1]);

            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);

            maze = new char[N][M];
            visited = new boolean[N][M];
            path = new boolean[N][M];

            for(int i = 0; i < N; i++){
                String line = scanner.nextLine();
                //确保每行都是M个元素
                if(line.length()!=M)
                    throw new IllegalArgumentException("Maze file "+filename+" is invalid.");
                for(int j = 0; j < M;j++){
                    maze[i][j] = line.charAt(j);
                    visited[i][j]=false;
                    path[i][j] = false;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(scanner != null)
                scanner.close();
        }

        //初始化迷宫的入口出口，表示数据的下标
        entranceX = 1;
        entranceY = 0;
        exitX = N-2;
        exitY = M-1;

    }

    public int getN(){ return N;}
    public int getM(){ return M;}
    public int getEntranceX(){ return entranceX;}
    public int getEntranceY(){ return entranceY;}
    public int getExitX(){ return exitX;}
    public int getExitY(){ return exitY;}


    public char getMaze(int i,int j){
        if(!inArea(i,j))
            throw new IllegalArgumentException("i or j is out of index in getMaze!");
        return maze[i][j];
    }

    public boolean inArea(int i,int j){
        return i>=0 && i<N && j>=0 && j<M;
    }

    //检测是否读取成功
    public void printMaze(){
        System.out.println(N+" "+M);
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
