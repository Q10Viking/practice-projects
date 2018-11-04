public abstract class Decorator implements Animal{
    //һ������ʵ���������
    private Animal animal;

    //���췽��
    public Decorator(Animal animal){
        this.animal = animal;
    }

    //������ת�����������
    public void name(){
        animal.name();
    }
}
