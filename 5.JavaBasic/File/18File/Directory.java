import java.io.*;
import java.util.regex.*;
import java.util.*;
public final class Directory{
    //当前目录的内容
    public static File[] local(File dir,final String regex){
        //listFiles返回File,并且会回调用accept方法
        return dir.listFiles(new FilenameFilter(){
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir,String name){
                //System.out.println("accept方法: "+name);
                return pattern.matcher(
                    new File(name).getName()).matches();
            }
        });
    }

    //Overload
    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    //Overload
    public static File[] local(String path){
        return local(new File(path),".*");
    }


    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }


    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    //递归遍历整个目录树
    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for(File item: startDir.listFiles()){
            if(item.isDirectory()){ //路径
                result.dirs.add(item);
                //递归及回溯
                result.addAll(recurseDirs(item,regex));
            }else{  //文件
                if(item.getName().matches(regex))
                    result.files.add(item);
            }
        }
        //回溯
        return result;
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator(){
            return files.iterator();
        }


        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString(){
            return "dirs: "+PPrint.pformat(dirs)+
                   "\n\nfiles: "+PPrint.pformat(files);
        }
    }


}

