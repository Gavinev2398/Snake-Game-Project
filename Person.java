/**
 * Created by t00189398 on 23/11/2016.
 */
public class Person {

    private String name;



    public Person (String name) {
        this.name = name;

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Person() {
        this("Not Given");
    }

    public String getName()
    {
        return name;
    }



}
