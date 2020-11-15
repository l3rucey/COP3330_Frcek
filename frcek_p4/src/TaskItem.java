import java.io.FileNotFoundException;
import java.util.Formatter;

// Contains a "title" (1 or more 'char' in len)
// Contains a "desc" (0 or more 'char' in len)
// Contains a "due date" (in this format YYYY-MM-DD)

// Encapsulate item data
public class TaskItem {
    private String title;
    private String description;
    private String date;

    // Constructor
    public TaskItem(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDate() {
        return this.date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

//    private Formatter x;
//
//    public void openFile() {
//        try {
//            x= new Formatter("japanese.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addRec() {
//        x.format("%s%s%s", "8 ", "Bruce", "Frcek");
//    }
//
//    public void closeFile() {
//        x.close();
//    }