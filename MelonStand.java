public class MelonStand {
    private long id;
    private String name;
    private int total;
    private boolean isClosed;
    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getTotal(){
        return total;
    }
    public boolean ifClosed(){
        return isClosed;
    }
    public String toString(){
        String temp = "摊号：" + id + "\n摊主姓名：" + name + "\n在售西瓜数：" + total + "\n是否休摊整改:";
        if (isClosed == true) {
            temp += "是";
        } else {
            temp += "否";
        }
        return temp;
    }
    public MelonStand(long id, String name, int total, boolean isClosed){
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }
    public static void purchase(MelonStand stand, int num){
        if (stand.getTotal()>=num && stand.ifClosed()!=true && num>0) {
            stand.setTotal(stand.getTotal()-num);
            System.out.println("交易成功！");
        } else {
            System.out.print("交易失败！");
            if (num <= 0){
                System.out.print("参数非法");
            } else if (stand.getTotal()>=num) {
                System.out.print("西瓜数量不足");
            } else {
                System.out.print("休摊整改中");
            }
        }
    }
    public void restock(int num){
        if (num<=200 && num >=0){
            total += num;
            System.out.println("进货成功！");
        } else {
            System.out.println("进货失败！数量不合法");
        }
    }
    public static void closeBooths(MelonStand[] booths){
        for (int i=0; i<booths.length; i++){
            if (booths[i].ifClosed() == true){
                System.out.println(booths[i].toString());
            }
            else {
                booths[i].setClosed(true);
            }
        }
    }
}
