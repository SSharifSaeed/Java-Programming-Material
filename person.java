import java.util.NoSuchElementException;
import java.util.Arrays;


public class person extends Container{
    Private String name;
    Private int age;

    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    
    @override
    public toString(){
        return "Person [name="+ name + ", age =" + age + "]";
    }

}
