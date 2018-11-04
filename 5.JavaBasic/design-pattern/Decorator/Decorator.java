public abstract class Decorator implements Animal{
    //一个对真实对象的引用
    private Animal animal;

    //构造方法
    public Decorator(Animal animal){
        this.animal = animal;
    }

    //把请求转发给代理对象
    public void name(){
        animal.name();
    }
}
