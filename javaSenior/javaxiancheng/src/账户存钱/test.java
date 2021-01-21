package 账户存钱;

public class test {
    public static void main(String[] args) {
    Account account=new Account(0);
    Customer customer=new Customer(account);
   Thread c1=new Thread(customer);
   Thread c2=new Thread(customer);
    c1.setName("甲");
    c2.setName("已");
    c1.start();
    c2.start();
    }
}
