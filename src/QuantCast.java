//import java.io.*;
//import java.util.*;
//import org.junit.*;
//import org.junit.runner.*;

class QuantCast {
    public static void main(String[] args) {

    }
}
    /*
     * Return the value of the message given a path.
     *
     * Here are examples of a path:
     *   - "name"
     *   - "age"
     *   - "address.zipCode"
     *
     * Here `f` represents a field in some root message, `a` and `b`
     * fields in the message found in `f`, and `d` a field found in the
     * message in `f.b`.
     *
     * @param message a Message instance
     * @param path path to the field
     * @return
     *
    static Object getValue(Message message, String path) {
        String[] fields = path.split(".");
        Field result;
        Message m = message;
        for (int i=0; i<fields.length; i++) {
            result = m.getField(fields[i]);
            if (result.type == MESSAGE) {
                m = (Message)result.value;
            }

            if (result.type == PRIMITIVE && i < fields.length-1) {
                throw new Exception();
            }
        }


        return result.value;
    }

    @Test
    public void test() {
        Person person = new Person();
        person.name = "Wesley";
        person.address = new Address();
        person.address.zipCode = "1000";

        Field nameField = person.getField("name");
        assert nameField.type == PRIMITIVE;
        assert nameField.name == "name";
        assert nameField.value == "Wesley";

        Field addressField = person.getField("address");
        assert addressField.type == MESSAGE;
        assert addressField.name == "address";
        assert addressField.value == person.address;

        assert person.getField("address.zipCode") == null;

        assert getValue(person, "name") == "Wesley";
        assert getValue(person, "address.zipCode") == "1000";
        assert getValue(person, "name.age")
    }
}

interface Message {
    Field getField(String name);
}

class Field {
    Type type;
    String name;
    Object value;

    enum Type {
        PRIMITIVE,
        MESSAGE;
    }
}

// these are examples
class Person implements Message {
    String name;
    int age;
    Address address;
}

class Address implements Message {
    String zipCode;
}
*/
