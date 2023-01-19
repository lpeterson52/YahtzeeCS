public class Die {
    int value = 0;
    boolean keep = false;
    public Die(int value, boolean keep) {
        this.value = value;
        this.keep = keep;
    }

    public void roll(){
        if(keep != true){
            this.value = (int)(Math.random()*6) + 1;
        }
    }

    // getter methods
    public int getValue() {
        return this.value;
    }

    public boolean getKeep() {
        return this.keep;
    }
    public void setKeep(boolean x){
        this.keep = x;
    }
}
