import java.io.File;

public class Main {
    /*
    1) В папке Games создайте несколько директорий: src, res, savegames, temp.
    2) В каталоге src создайте две директории: main, test.
    3) В подкаталоге main создайте два файла: Main.java, Utils.java.
    4) В каталог res создайте три директории: drawables, vectors, icons.
    5) В директории temp создайте файл temp.txt.
    */
    public static void main(String[] args) {
        System.out.println("Task T03_install");
        String rootFolder = "./Games";

        GameInstall gi = new GameInstall(rootFolder);

    }
}