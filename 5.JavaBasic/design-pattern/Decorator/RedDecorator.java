public class RedDecorator extends Decorator{
    //���캯��
    public RedDecorator(Animal animal){
        super(animal);
    }

    //��дname������ע���µĹ���
    @Override
    public void name(){
        super.name();
        red();
    }

    private void red(){
        System.out.println("Color: Red");
    }
}
