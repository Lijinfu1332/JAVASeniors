
interface IDriver {
    //是司机就可以驾驶汽车
    public void drive(ICar car);
}
interface ICar {
    //是汽车就可以跑
    public void run();
}
 class Driver{
    public void drive(Bene bene){
        bene.run();
    }

}
class  Bene{
    public void run(){
        System.out.println("Bene is running....");
    }
}
class Bmw{
    public void run(){
        System.out.println("Bmw is running...");
    }
}
public class test9 {
    public static void main(String[] args) {
        Driver alice=new Driver();
        Bene bene=new Bene();
        alice.drive(bene);
    }
}