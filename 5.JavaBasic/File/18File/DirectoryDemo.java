import java.io.*;
public class DirectoryDemo{
    public static void main(String[] args){
        //All directories;
        Directory.TreeInfo t1 = Directory.walk(".");
        System.out.println(t1);

        System.out.println("\n-----------------------\n");

        /*
        for(File file: Directory.local("."))
            System.out.println(file);
        */
        //使用PPring的功能，将数组转化成List
        PPrint.pprint(Directory.local("."));


    }
}

/*
λ java DirectoryDemo
dirs: [
 .\Temp
 .\Temp\Temp2
 ]

files: [
 .\Directory$1.class
 .\Directory$TreeInfo.class
 .\Directory.class
 .\Directory.java
 .\DirectoryDemo.class
 .\DirectoryDemo.java
 .\DirFilter.class
 .\DirList$1.class
 .\DirList.class
 .\DirList.java
 .\PPrint.class
 .\PPrint.java
 .\Temp\Q10Viking.txt
 ]

-----------------------

[
 .\Directory$1.class
 .\Directory$TreeInfo.class
 .\Directory.class
 .\Directory.java
 .\DirectoryDemo.class
 .\DirectoryDemo.java
 .\DirFilter.class
 .\DirList$1.class
 .\DirList.class
 .\DirList.java
 .\PPrint.class
 .\PPrint.java
 .\Temp
 ]
*/
