package demo.cglib;

public class Target {

    public String execute() {
        String message = "----------execute()----------";
        System.out.println(message);
        return message;
    }
}