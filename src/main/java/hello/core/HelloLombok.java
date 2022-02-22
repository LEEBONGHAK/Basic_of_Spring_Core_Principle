package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // set func 생성
@Setter // get func 생성
@ToString   // toString func 생성
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello lombok");

        System.out.println("helloLombok = " + helloLombok);
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
