package rs.co.sbb.sbbworkorders.entity.response;

/**
 * Created by Predrag.Tasic on 6/7/2017.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WoData implements Serializable{

    @SerializedName("ET_IZLAZ")
    @Expose
    private List<Etizlaz> eTIZLAZ = null;

    public List<Etizlaz> getETIZLAZ() {
        return eTIZLAZ;
    }

    public void setETIZLAZ(List<Etizlaz> eTIZLAZ) {
        this.eTIZLAZ = eTIZLAZ;
    }
}

