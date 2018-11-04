import java.io.*;
public class MakeDirectories{
    private static void usage(){
        System.err.println(
            "Usage: MakeDirectories path1 ...\n" +
            "Creates each path\n" +
            "Usage:MakeDirectories -d path1 ...\n" +
            "Deletes each path\n" +
            "Usage: MakeDirectories -r path1 path2 \n" +
            "Renames from path1 to path2"
            );
        System.exit(1);
    }

    private static void fileData(File f){
        System.out.println(
                "Absolute path: " + f.getAbsolutePath() +
                "\n Can read: " + f.canRead() +
                "\n Can write: " + f.canWrite() +
                "\n getName: " + f.getName() +
                "\n getParent: " + f.getParent() +
                "\n getPath: " + f.getPath() +
                "\n length: " + f.length() +
                "\n lastModified: " + f.lastModified()
            );
        if(f.isFile())
            System.out.println("It's a file");
        else if(f.isDirectory())
            System.out.println("It's a directory");
    }

    public static void main(String[] args){
        if(args.length < 1) usage();

        if(args[0].equals("-r")){
            if(args.length != 3) usage();

            File old = new File(args[1]);
            File dest = new File(args[2]);
            old.renameTo(dest);
            fileData(old);
            fileData(dest);
            return; //Exit main
        }

        //������ɾ�������һ��д�Ĵ��������

        int count = 0; //�������args
        boolean del = false;
        if(args[0].equals("-d")){
            count++;
            del = true;
        }
        count--;
        while(++count < args.length){
            File f = new File(args[count]);
            if(f.exists()){
                System.out.println(f+" exists");
                if(del){
                    System.out.println("deleting..."+f);
                    f.delete();
                }

            }else{  //doesn't exists
                if(!del){
                    f.mkdirs();
                    System.out.println("created "+f);
                }
            }

            fileData(f);
        }
    }
}


/**
�����ļ���
�� java MakeDirectories FoldTest
created FoldTest
Absolute path: C:\Users\Viking\Desktop\lab\javaGo\18File\FoldTest
 Can read: true
 Can write: true
 getName: FoldTest
 getParent: null
 getPath: FoldTest
 length: 0
 lastModified: 1541326790915
It's a directory

//���������ļ���
�� java MakeDirectories -r FoldTest FoldTest2
Absolute path: C:\Users\Viking\Desktop\lab\javaGo\18File\FoldTest
 Can read: false
 Can write: false
 getName: FoldTest
 getParent: null
 getPath: FoldTest
 length: 0
 lastModified: 0
Absolute path: C:\Users\Viking\Desktop\lab\javaGo\18File\FoldTest2
 Can read: true
 Can write: true
 getName: FoldTest2
 getParent: null
 getPath: FoldTest2
 length: 0
 lastModified: 1541326790915
It's a directory

ɾ�����ļ���
�� java MakeDirectories -d FoldTest2
FoldTest2 exists
deleting...FoldTest2
Absolute path: C:\Users\Viking\Desktop\lab\javaGo\18File\FoldTest2
 Can read: false
 Can write: false
 getName: FoldTest2
 getParent: null
 getPath: FoldTest2
 length: 0
 lastModified: 0

 */
