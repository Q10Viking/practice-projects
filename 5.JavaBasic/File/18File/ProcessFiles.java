/**
* 使用策略模式对指定路径下的所有指定后缀名的文件进行处理
*/
import java.io.*;
public class ProcessFiles{
    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy,String ext){
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){
        try{
            if(args.length == 0)
                processDirectoryTree(new File("."));
            else{
                for(String arg: args){
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else{
                        //Allow user to leave off extension
                        if(!arg.endsWith("."+ext))
                            arg += "."+ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }

            }
        }catch(IOException e){
            //
        }
    }

    public void processDirectoryTree(File root) throws IOException{
        //TreeInfo实现了Iterable
        //正则表达式后缀设置
        for(File file: Directory.walk(root.getCanonicalFile(),".*\\."+ext)){
            //绝对路径的file
            strategy.process(file.getCanonicalFile());
        }
    }

    //Demonstration of how to use it
    public static void main(String[] args){
        new ProcessFiles(new ProcessFiles.Strategy(){
            public void process(File file){
                System.out.println(file);
            }
        },"java").start(args);
    }
}


/**
λ java ProcessFiles
C:\Users\Viking\Desktop\lab\javaGo\18File\Directory.java
C:\Users\Viking\Desktop\lab\javaGo\18File\DirectoryDemo.java
C:\Users\Viking\Desktop\lab\javaGo\18File\DirList.java
C:\Users\Viking\Desktop\lab\javaGo\18File\PPrint.java
C:\Users\Viking\Desktop\lab\javaGo\18File\ProcessFiles.java


λ java ProcessFiles .\Temp\Q10Viking.txt
C:\Users\Viking\Desktop\lab\javaGo\18File\Temp\Q10Viking.txt.java


*/
