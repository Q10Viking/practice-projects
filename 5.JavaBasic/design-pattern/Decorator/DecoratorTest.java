public class DecoratorTest{
    public static void main(String[] args){
        //����è
        Animal animal = new Cat();
        animal.name();
        System.out.println("\n----------\n");

        //��ɫ��è
        RedDecorator redDecoratro = new RedDecorator(animal);
        redDecoratro.name();
        System.out.println("\n----------\n");


        //��ɫ��è
        WhiteDecorator whiteDecorator = new WhiteDecorator(animal);
        whiteDecorator.name();
        System.out.println("\n----------\n");

        //һֻ��ɫ��ɫ��è
        RedDecorator red_white = new RedDecorator(new WhiteDecorator(animal));
        red_white.name();
        System.out.println("\n----------\n");
    }
}

/**
Cat: Hello,I'm Vivi

----------

Cat: Hello,I'm Vivi
Color: Red

----------

Cat: Hello,I'm Vivi
Color: White

----------

Cat: Hello,I'm Vivi
Color: White
Color: Red

----------

*/
