/**
* ʹ�ò���ģʽ��ָ��·���µ�����ָ����׺�����ļ����д���
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
        //TreeInfoʵ����Iterable
        //������ʽ��׺����
        for(File file: Directory.walk(root.getCanonicalFile(),".*\\."+ext)){
            //����·����file
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
�� java ProcessFiles
C:\Users\Viking\Desktop\lab\javaGo\18File\Directory.java
C:\Users\Viking\Desktop\lab\javaGo\18File\DirectoryDemo.java
C:\Users\Viking\Desktop\lab\javaGo\18File\DirList.java
C:\Users\Viking\Desktop\lab\javaGo\18File\PPrint.java
C:\Users\Viking\Desktop\lab\javaGo\18File\ProcessFiles.java


�� java ProcessFiles .\Temp\Q10Viking.txt
C:\Users\Viking\Desktop\lab\javaGo\18File\Temp\Q10Viking.txt.java


*/
