package data;

public enum InputField {
    userName ("Ivan Ivanov"),
    userEmail ("ivanov@ivan.ru"),
    currentAddress("Some street, 1"),
    permanentAddress("Some street, 25");

    public final String description;

    InputField(String description) {
        this.description = description;
    }
}
