package rs.co.sbb.sbbworkorders.entity;

/**
 * Created by Predrag.Tasic on 6/7/2017.
 */

public class RetrofitError {

    private int code;
    private String message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}
