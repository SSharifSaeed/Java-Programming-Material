

// Edit class name
public class CustomInteger {

    private int value;

    public customInteger(int integer){
        this.value = integer + 1;
    }

    @Override
    public String toString(){
        return ""+value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return Long.valueOf(value);
    }

    @Override
    public float floatValue() {
        return Float.valueOf(value);
    }

    @Override
    public double doubleValue() {
        return Double.valueOf(value);
    }

}
