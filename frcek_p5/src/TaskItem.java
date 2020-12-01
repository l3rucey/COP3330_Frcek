// Contains a "title" (1 or more 'char' in len)
// Contains a "desc" (0 or more 'char' in len)
// Contains a "due date" (in this format YYYY-MM-DD)

// Encapsulate item data
public class TaskItem {
    private String title;
    private String description;
    private String date;
    private boolean mark;

    public TaskItem(String title, String description, String date) {
//        if () {
//            this.title = title;
//            this.description = description;
//            this.date = date;
//        } else {
//            System.out.println("ERROR: All entries cannot be blank");
//        }
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

    public boolean getMark() {
        return this.mark;
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

    public void setMark(boolean mark) {
        this.mark = mark;
    }

}

