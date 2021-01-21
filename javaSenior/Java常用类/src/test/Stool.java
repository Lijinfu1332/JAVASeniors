package test;

public class Stool {
    private double top_r;
    private double top_h;
    private double middle_r;
    private double middle_h;
    private double botton_r;
    private double botton_h;

    public Stool(double top_r, int top_h, double middle_r, int middle_h, double botton_r, int botton_h) {
        this.top_r=top_r;
        this.top_h=top_h;
        this.middle_r=middle_r;
        this.middle_h=middle_h;
        this.botton_r=botton_r;
        this.botton_h=botton_h;
    }

    public double getTop_r() {
        return top_r;
    }

    public void setTop_r(double top_r) {
        this.top_r = top_r;
    }

    public double getTop_h() {
        return top_h;
    }

    public void setTop_h(double top_h) {
        this.top_h = top_h;
    }

    public double getMiddle_r() {
        return middle_r;
    }

    public void setMiddle_r(double middle_r) {
        this.middle_r = middle_r;
    }

    public double getMiddle_h() {
        return middle_h;
    }

    public void setMiddle_h(double middle_h) {
        this.middle_h = middle_h;
    }

    public double getBotton_r() {
        return botton_r;
    }

    public void setBotton_r(double botton_r) {
        this.botton_r = botton_r;
    }

    public double getBotton_h() {
        return botton_h;
    }

    public void setBotton_h(double botton_h) {
        this.botton_h = botton_h;
    }
    public double getArea(){
        double Area=(top_r*top_r+botton_r*botton_r-middle_r*middle_r)*Math.PI*2+(top_h*top_r-middle_h*middle_r+botton_r*botton_h)*Math.PI*2;
        return Area;
    }
    //计算面积
    public double getVol(){
        double Vol=Math.PI*(top_r*top_r*top_h+middle_r*middle_r*middle_h+botton_h*botton_r*botton_r);
        return Vol;
    }

    @Override
    public String toString() {
        return "Stool{" +
                "top_r=" + top_r +
                ", top_h=" + top_h +
                ", middle_r=" + middle_r +
                ", middle_h=" + middle_h +
                ", botton_r=" + botton_r +
                ", botton_h=" + botton_h +
                '}';
    }
}
