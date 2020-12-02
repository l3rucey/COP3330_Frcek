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
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(5, 1);
        int size = list.getItemList().size();
        assertEquals(1, size);
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 1", "new desc", "1997-07-24");
        assertEquals("desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "new desc", "1997-07-24");
        assertEquals("new desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "desc", "2000-01-01");
        assertEquals("2000-01-01", list.getItemList().get(0).getDate());
    }

//    @Test
//    public void editingItemTitleFailsWithEmptyString() {
//        TaskList list = new TaskList();
//        list.createList();
//        list.addToList("task 1", "desc", "1997-09-09");
//        list.editList(0, 1,"", "desc", "1997-07-24");
//        assertEquals(null, list.getItemList().get(0).getTitle());
//    }

    // how
    @Test
    public void editingItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"", "desc", "1997-07-24");
        assertEquals("task 1", list.getItemList().get(0).getTitle());
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task one", "desc", "1997-07-24");
        assertEquals("task one", list.getItemList().get(0).getTitle());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "desc", "09/09/97");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 1", "desc", "1999-08-20");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1,"task 1", "desc", "09/09/97");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1, "task 2", "new desc", "1997-09-09");
        assertEquals("desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1, "task 2", "new desc", "1997-09-09");
        assertEquals("new desc", list.getItemList().get(0).getDescription());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1, "task 2", "new desc", "2000-20-09");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1, "task 2", "new desc", "1997-09-09");
        assertEquals("1997-09-09", list.getItemList().get(0).getDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1, "task 3", "new desc", "1997-09-09");
        assertEquals("task 1", list.getItemList().get(0).getTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(0, 1, "task 2", "new desc", "1997-09-09");
        assertEquals("task 2", list.getItemList().get(0).getTitle());
    }

    @Test
    public void newListIsEmpty() {
        TaskList list = new TaskList();
        list.createList();
        int size = list.getItemList().size();
        assertEquals(0, size);
    }

    @Test
    public void removingItemsDecreasesSize() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.addToList("task 2", "desc2", "1997-08-09");
        list.removeItem(0, 2);
        int size = list.getItemList().size();
        assertEquals(1, size);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.addToList("task 2", "desc2", "1997-08-09");
        list.removeItem(3, 2);
        int size = list.getItemList().size();
        assertEquals(2, size);
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
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.markItem(0, 1);

        assertTrue(list.getItemList().get(0).getMark());
    }

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
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        list.createList();
        list.addToList("task 1", "desc", "1997-09-09");
        list.editList(3, 1,"task 50", "new desc", "1997-07-24");
        assertEquals("task 1", list.getItemList().get(0).getTitle());
    }
}