package logicTest;

import com.john.logic.StudentLogic;
import com.john.logic.StudentLogicI;
import com.john.model.Student;
import org.junit.Assert;

import java.sql.SQLException;

public class StudentLogicTest {
    StudentLogicI studentLogicI;

    public StudentLogicTest() throws SQLException, ClassNotFoundException {
        studentLogicI = new StudentLogic();
    }

    @org.junit.Test
    public void add() throws SQLException {
        Student student = new Student();
        student.setIdNumber("12000");
        student.setCourse("Ecotourism");
        student.setRegistrationNo("N13/50192/13");
        student.setName("This guy");
        if (!studentLogicI.add(student)) Assert.assertFalse(false); // confirmation that it has failed
        Student search = studentLogicI.find(student.getRegistrationNo());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
        Assert.assertEquals(student.getName(), search.getName());
        Assert.assertEquals(student.getCourse(), search.getCourse());
        Assert.assertEquals(student.getIdNumber(), search.getIdNumber());
    }
}