package 账户存钱;
//继承方式实现
//class Customer extends Thread{
//实现Runnable接口实现
class Customer implements Runnable{
    private Account acct;
    public Customer(Account acct){
        this.acct=acct;
    }


    @Override
    public void run() {
        for (int i=0;i<3;i++){
            acct.saveMoney(1000);
        }
    }
}
