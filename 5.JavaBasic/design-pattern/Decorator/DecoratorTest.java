public class DecoratorTest{
    public static void main(String[] args){
        //定义猫
        Animal animal = new Cat();
        animal.name();
        System.out.println("\n----------\n");

        //红色的猫
        RedDecorator redDecoratro = new RedDecorator(animal);
        redDecoratro.name();
        System.out.println("\n----------\n");


        //白色的猫
        WhiteDecorator whiteDecorator = new WhiteDecorator(animal);
        whiteDecorator.name();
        System.out.println("\n----------\n");

        //一只红色白色的猫
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
