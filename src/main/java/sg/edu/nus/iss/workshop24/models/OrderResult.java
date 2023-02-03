package sg.edu.nus.iss.workshop24.models;

public class OrderResult {
    private int inserCntForPO;
    private int inserCntForLineItem;

    
    public int getInserCntForPO() {
        return inserCntForPO;
    }
    public void setInserCntForPO(int inserCntForPO) {
        this.inserCntForPO = inserCntForPO;
    }
    public int getInserCntForLineItem() {
        return inserCntForLineItem;
    }
    public void setInserCntForLineItem(int inserCntForLineItem) {
        this.inserCntForLineItem = inserCntForLineItem;
    }
    
}
