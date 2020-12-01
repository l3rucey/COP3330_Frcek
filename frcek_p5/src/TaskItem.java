// Contains a "title" (1 or more 'char' in len)
// Contains a "desc" (0 or more 'char' in len)
// Contains a "due date" (in this format YYYY-MM-DD)

import org.junit.jupiter.api.Test;

// Encapsulate item data
public class TaskItem {
    private String title;
    private String description;
    private String date;
    private boolean mark;

    public TaskItem(String title, String description, String date) {
        if (date.length() != 10) {
            System.out.println("ERROR: Date needs to be in YYYY-MM-DD format");
        } else if (title.length() < 1) {
            System.out.println("ERROR: Title needs to be 1 or more characters");
        } else {
            this.title = title;
            this.description = description;
            this.date = date;
        }
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

