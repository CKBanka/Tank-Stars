package Utils;

import com.mygdx.game.GameMain;

import java.io.*;
public class SaveGame {
    public static saveData s;
    public static void serialize()  {
//        ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("save.txt"));
//        objout.writeObject(s);
//        objout.close();
        int idx = GameMain.num+1;
        File f1 = new File("game1.txt");
        File f2 = new File("game2.txt");
        File f3 = new File("game3.txt");

//        if(f1.exists()){
//            if(f2.exists()){
//                if(f3.exists()){
//                    idx = 1;
//                }
//                else{
//                    idx = 3;
//                }
//            }
//            else{
//                idx = 2;
//            }
//        }

        try{
            FileOutputStream file = new FileOutputStream("game"+idx+".txt");
            ObjectOutputStream out= new ObjectOutputStream(file);
            out.writeObject(s);
            out.close();
            file.close();
            System.out.println("ok serialize"+idx);
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception is caught");
        }
        catch (IOException e) {
            System.out.println("IO Exception is caught");
        }

    }
    public static saveData deserialize(int idx,boolean del){
//        try{
//            ObjectInputStream objin = new ObjectInputStream(new FileInputStream("save.txt"));
//            Object obj = null;
//            obj =  objin.readObject();
//            objin.close();
//            return (saveData)obj;
//        }
        try{
            File f = new File("game"+idx+".txt");
            if(f.exists()==false){
                throw new NoSaveFoundException("No saved game exists");
            }
            FileInputStream file = new FileInputStream("game"+idx+".txt");
            ObjectInputStream in = new ObjectInputStream(file);
            saveData temp = (saveData) in.readObject();
//            System.out.println(temp.t1x);
            in.close();
            file.close();
            if(del) {
                f.delete();
            }
            System.out.println("ok deserialize");
            return temp;
        }
        catch (NoSaveFoundException e) {
            System.out.println("No Save Found Exception is caught!");
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception is caught!");
        }
        catch (IOException e) {
            System.out.println("IO Exception is caught!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception is caught!");
        }
        catch (ClassCastException e){
            System.out.println("Class Cast Exception is caught!");
        }
        System.out.println("not ok deserialize");
        return null;

    }
}
