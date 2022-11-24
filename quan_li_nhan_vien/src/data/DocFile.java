package data;

import entity.NhanVienFullTime;
import entity.NhanVienPartTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocFile {
    public static void writeFileNvFt(List<NhanVienFullTime> nhanVienFList, String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanVienFList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<NhanVienFullTime> readFileNvFt(String path) {
        List<NhanVienFullTime> nhanVienList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            nhanVienList = (List<NhanVienFullTime>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.err.println("Không có data");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    public static void writeFileNvPt(List<NhanVienPartTime> nhanVienList, String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanVienList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<NhanVienPartTime> readFileNvPt(String path) {
        List<NhanVienPartTime> nhanVienList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            nhanVienList = (List<NhanVienPartTime>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.err.println("Không có data");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nhanVienList;
    }

    public static void writeFileLuong(List<Double> luongList, String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(luongList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Double> readFileLuong(String path) {
        List<Double> luongList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            luongList = (List<Double>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.err.println("Không có data");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return luongList;
    }

}
