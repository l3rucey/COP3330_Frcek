import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        int size = list.getItemList().size();
        assertEquals(1, size);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(0, 1);
        assertTrue(list.getItemList().get(0).getMark());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(0, 1);
        assertTrue(list.getItemList().get(0).getMark());
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        list.createList();
        int size = list.getItemList().size();
        assertEquals(0, size);
    }

    // simplify later
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("");
        item.setDescription("desc");
        item.setDate("1997-09-09");
        list.createList();
        //Some way to validate/add to list
        int size = list.getItemList().size();
        assertEquals(0, size);
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.addToList("task 2", "desc2", "1997-08-09");
        list.removeItem(0, 2);
        int size = list.getItemList().size();
        assertEquals(1, size);
    }

    // get rid of assertEquals?
    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(0, 1);
        list.unMarkItem(0, 1);
        assertFalse(list.getItemList().get(0).getMark());
        //assertEquals(true, list.getItemList().get(0).getMark());
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.saveFile("save.txt");
        list.loadList("save.txt");
        assertEquals(1, list.getItemList().size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.addToList("task 2", "desc2", "1997-08-09");
        list.removeItem(3, 2);
        int size = list.getItemList().size();
        assertEquals(2, size);
    }

//    // come back to this
//    @Test
//    public void savedTaskListCanBeLoaded() {
//        TaskList list = new TaskList();
//        list.createList();
//        list.addToList("task 1", "desc", "1997-09-09");
//        list.saveFile("text.txt");
//        list.loadList("text.txt");
//        assertEquals(, list.viewList());
//    }

//    @Test
//    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
//        TaskList list = new TaskList();
//        list.createList();
//        list.addToList("task 1", "desc", "1997-09-09");
//        list.editList(1, "new title", "desc", "1997-07-24");
//        assertEquals();
//    }

//    @Test
//    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
//        TaskList list = new TaskList();
//        list.createList();
//        list.addToList("task 1", "desc", "1997-09-09");
//        list.editList(0, "new title", "desc", "1997-07-24");
//        assertEquals();
//    }

    // check all values??
    @Test
    public void editingTaskItemChangesValues() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"new title", "desc", "1997-07-24");
        assertEquals("new title", list.getItemList().get(0).getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "new desc", "1997-07-24");
        assertEquals("new desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "new desc", "2000-01-01");
        assertEquals("2000-01-01", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"new title", "desc", "1997-07-24");
        assertEquals("new title", list.getItemList().get(0).getTitle());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(5, 1);
        //assertThrows(IllegalArgumentException.class, () -> list.markItem(5, 1));
        int size = list.getItemList().size();
        assertEquals(1, size);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 1", "new desc", "1997-07-24");
        assertEquals("desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 1", "new desc", "1997-08-20");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 50", "new desc", "1997-07-24");
        assertEquals("task 1", list.getItemList().get(0).getTitle());
    }

}