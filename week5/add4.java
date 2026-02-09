import java.io.File;
//Program: Rename a File
public class add4 {
    public static void main(String[] args) {

        File oldFile = new File("input.txt");
        File newFile = new File("renamed.txt");

        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Rename failed.");
        }
    }
}

/*Common File Class Methods
| Method              | Purpose                    |
| ------------------- | -------------------------- |
| `exists()`          | Checks if file exists      |
| `length()`          | Returns file size in bytes |
| `getName()`         | File name                  |
| `getPath()`         | Path given                 |
| `getAbsolutePath()` | Full path                  |
| `canRead()`         | Read permission            |
| `canWrite()`        | Write permission           |
| `isFile()`          | Checks if file             |
| `isDirectory()`     | Checks if directory        |
| `delete()`          | Deletes file               |
 */