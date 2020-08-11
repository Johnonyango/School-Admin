package logicTest;

import com.john.logic.TeacherLogic;
import com.john.logic.TeacherLogicI;
import com.john.model.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TeacherLogicTest {
    TeacherLogicI teacherLogicI;

    public TeacherLogicTest() throws SQLException, ClassNotFoundException {
        teacherLogicI = new TeacherLogic();
    }
    @Test
    public void updateTeacher() throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setStaffNo("000012");
        teacher.setName("Mr Ambujo");
        teacher.setId(521);
        teacher.setCourse("Resarch");
        if (!teacherLogicI.add(teacher)) Assert.assertFalse(false); // confirmation that it has failetd
        Teacher search = teacherLogicI.find(teacher.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
        Assert.assertEquals(teacher.getName(), search.getName());
        Assert.assertEquals(teacher.getCourse(), search.getCourse());
        Assert.assertEquals(teacher.getId(), search.getId());
    }
}