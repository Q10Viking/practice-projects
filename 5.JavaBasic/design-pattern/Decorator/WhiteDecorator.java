public class WhiteDecorator extends Decorator{
    //���캯��
    public WhiteDecorator(Animal animal){
        super(animal);
    }

    //��дname������ע���µĹ���
    @Override
    public void name(){
        super.name();
        white();
    }

    private void white(){
        System.out.println("Color: White");
    }
}
