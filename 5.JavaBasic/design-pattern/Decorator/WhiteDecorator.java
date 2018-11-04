public class WhiteDecorator extends Decorator{
    //构造函数
    public WhiteDecorator(Animal animal){
        super(animal);
    }

    //重写name方法，注入新的功能
    @Override
    public void name(){
        super.name();
        white();
    }

    private void white(){
        System.out.println("Color: White");
    }
}
