class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("B-Checkbox: [x] " + text);
    }
}
