public class RedDecorator extends Decorator{
    //构造函数
    public RedDecorator(Animal animal){
        super(animal);
    }

    //重写name方法，注入新的功能
    @Override
    public void name(){
        super.name();
        red();
    }

    private void red(){
        System.out.println("Color: Red");
    }
}
