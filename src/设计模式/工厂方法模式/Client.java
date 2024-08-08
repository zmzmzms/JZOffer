package 设计模式.工厂方法模式;

interface Phone {
    void call();
}

class Xiaomi implements Phone {
    @Override
    public void call() {
        System.out.println("xiaomi call");
    }
}

class Apple implements Phone {

    @Override
    public void call() {
        System.out.println("iphone call");
    }
}

interface AbstractFactory{
    Phone produce();
}

class AppleFactory implements AbstractFactory {

    @Override
    public Phone produce() {
        return new Apple();
    }
}

class XiaomiFactory implements AbstractFactory {

    @Override
    public Phone produce() {
        return new Xiaomi();
    }
}



public class Client {
    public static void main(String[] args) {
        AbstractFactory appleFactory = new AppleFactory();
        Phone apple = appleFactory.produce();
        apple.call();

        AbstractFactory xiaomiFactory = new XiaomiFactory();
        Phone xiaomi = xiaomiFactory.produce();
        xiaomi.call();
    }
}
