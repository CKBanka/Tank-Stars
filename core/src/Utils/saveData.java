package Utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
public class saveData implements Serializable {
    public int t1;
    public int t2;
    public int h1;
    public int h2;
    public int turn;
    public int t1x;
    public int t1y;
    public int t2x;
    public int t2y;

    public saveData(int t1, int t2, int h1, int h2, int turn, int t1x, int t1y, int t2x, int t2y) {
        this.t1 = t1;
        this.t2 = t2;
        this.h1 = h1;
        this.h2 = h2;
        this.turn = turn;
        this.t1x = t1x;
        this.t1y = t1y;
        this.t2x = t2x;
        this.t2y = t2y;
    }
}
