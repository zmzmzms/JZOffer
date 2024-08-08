package 设计模式.抽象方法模式;

interface ProductA{
    void display();
}
interface ProductB{
    void show();
}

interface AbstractFactory{
    ProductA produceA();
    ProductB produceB();
}
class ProductA1 implements ProductA{
    @Override
    public void display() {
        System.out.println("display ProductA1");
    }
}

class ProductA2 implements ProductA {
    @Override
    public void display() {
        System.out.println("display ProductA2");

    }
}

class ProductB1 implements ProductB{

    @Override
    public void show() {
        System.out.println("show ProductB1");
    }
}

class FactoryA implements AbstractFactory{

    @Override
    public ProductA produceA() {
        return new ProductA1();
    }

    @Override
    public ProductB produceB() {
        return new ProductB1();
    }
}

class FactoryB implements AbstractFactory{

    @Override
    public ProductA produceA() {
        return new ProductA2();
    }

    @Override
    public ProductB produceB() {
        return new ProductB2();
    }
}

class ProductB2 implements ProductB{

    @Override
    public void show() {
        System.out.println("show ProductB2");
    }
}




public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new FactoryA();
        ProductA productA = abstractFactory.produceA();
        ProductB productB = abstractFactory.produceB();
        productA.display();
        productB.show();
        System.out.println("--------");
        AbstractFactory abstractFactory1 = new FactoryB();
        ProductA productA1 = abstractFactory1.produceA();
        ProductB productB1 = abstractFactory1.produceB();
        productA1.display();
        productB1.show();
    }
}
