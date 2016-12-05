import java.io.Serializable;

/**
 * Created by t00189398 on 23/11/2016.
 *
 *
 *
 */
public class Person implements Serializable {

    private String name;

    /**
     *
     * @param name
     */

    public Person (String name) {
        this.name = name;

    }

    /**
     *
     * @param name
     */

    public void setName(String name)
    {

        this.name = name;
    }


    public Person() {
        this("Not Given");
    }

    /**
     *
     * @return Accessor method for name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return name
     */
    public String toString ()
    {
        return "Name" + getName();
    }




}
