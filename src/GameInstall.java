import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstall {
    public String rootFolder;
    public String[] subFolders = new String[] {"src", "res", "savegames", "temp"};
    public StringBuilder log = new StringBuilder();

    public GameInstall(String rootFolder) {
        this.rootFolder = rootFolder;
        this.createFolder(this.rootFolder);

        for (String s : this.subFolders) {
            //System.out.println(s);

            switch (s) {
                case "src":
                    this.createFolder(this.rootFolder + "/src");
                    this.createFolder(this.rootFolder + "/src/main");
                    this.createFolder(this.rootFolder + "/src/test");
                    this.createFile(this.rootFolder + "/src/main", "Main.java");
                    this.createFile(this.rootFolder + "/src/main", "Utils.java");
                    break;
                case "res":
                    this.createFolder(this.rootFolder + "/res");
                    this.createFolder(this.rootFolder + "/res/drawables");
                    this.createFolder(this.rootFolder + "/res/vectors");
                    this.createFolder(this.rootFolder + "/res/icons");
                    break;
                case "savegames":
                    this.createFolder(this.rootFolder + "/savegames");
                    break;
                case "temp":
                    this.createFolder(this.rootFolder + "/temp");
                    this.createFile(this.rootFolder + "/temp", "temp.txt");
                    break;
                default:
                    System.out.println("?");
            }
        }

        System.out.println("==========================");
        // write log data to file
        try (FileWriter writer = new FileWriter(this.rootFolder + "/temp/" + "temp.txt", false)) {
            writer.write(this.log.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /*try (FileOutputStream fos = new FileOutputStream(this.rootFolder + "/temp/" + "temp.txt")) {
            byte[] data = this.log.toString().getBytes();
            fos.write(data, 0, data.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    public void createFolder(String folderName) {
        File dir = new File(folderName);
        if (dir.mkdir()) {
            this.log.append("created " + folderName + " folder\n");
        }
    }

    public void createFile(String folderName, String fileName) {
        File file = new File(folderName, fileName);
        try {
            if (file.createNewFile()) {
                this.log.append("created " + fileName + " file\n");
            }
        } catch (IOException ex) {
            this.log.append(ex.getMessage());
        }
    }


}
