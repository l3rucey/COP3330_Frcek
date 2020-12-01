import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() {
        TaskItem newItem = new TaskItem("task1", "desc", "08/08/09");
        assertEquals(null, newItem.getDate());
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        TaskItem newItem = new TaskItem("", "desc", "1997-08-08");
        assertEquals(null, newItem.getTitle());
    }


    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem newItem = new TaskItem("task 1", "desc", "1997-08-08");
        assertEquals("1997-08-08", newItem.getDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem newItem = new TaskItem("task 1", "desc", "1997-08-08");
        assertEquals("task 1", newItem.getTitle());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 2", "new desc", "1997-07-24");
        assertEquals("new desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 2", "new desc", "08/07/09");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 2", "new desc", "08/27/09");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 2", "new desc", "2009-08-08");
        assertEquals("2009-08-08", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"", "new desc", "2008/27/09");
        assertEquals(null, list.getItemList().get(0).getTitle());
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 2", "new desc", "2008/27/09");
        assertEquals("task 2", list.getItemList().get(0).getTitle());
    }
}
