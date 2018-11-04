import java.io.*;
import java.util.regex.*;
import java.util.*;
/**
* args: java DirList .*.java
*/
public class DirList{
    public static void main(final String[] args){
        //FilePath文件路径,表示上一个路径的Callback文件夹
        File path = new File("..\\Callback");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter(){
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir,String name){
                    return pattern.matcher(name).matches();
                }
            });

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list)
            System.out.println(dirItem);
    }

}


/*Output
CallBack.java
Li.java
Test.java
Wang.java
*/
