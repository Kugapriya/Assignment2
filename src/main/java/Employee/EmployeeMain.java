package Employee;

//import Employee.Employee1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class EmployeeMain
{
    public static void main(String []args)
    {
        try {
            ObjectMapper mapper=new XmlMapper();
            FileInputStream inputStream = new FileInputStream("D:/util/src/main/java/Employee/Employee.xml");
            TypeReference<List<Employee1>> typeReference = new TypeReference<List<Employee1>>() {};
            List<Employee1> employeelist = mapper.readValue(inputStream,typeReference);
            inputStream.close();
            for(Employee1 a:employeelist)
            {
                System.out.println(a.getPosition());
                a.Database();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }