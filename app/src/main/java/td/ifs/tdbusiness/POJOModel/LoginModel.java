package td.ifs.tdbusiness.POJOModel;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.POST;

public class LoginModel
{
@SerializedName("id")
    String id;
@SerializedName("nm")
    String nm;
@SerializedName("img")
    String img;
@SerializedName("area")
    String area;
@SerializedName("doc")
    String doc;
@SerializedName("log_stst")
    String log_stst;

    public LoginModel() {
    }

    public LoginModel(String id, String nm, String img, String area, String doc, String log_stst) {
        this.id = id;
        this.nm = nm;
        this.img = img;
        this.area = area;
        this.doc = doc;
        this.log_stst = log_stst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getLog_stst() {
        return log_stst;
    }

    public void setLog_stst(String log_stst) {
        this.log_stst = log_stst;
    }
}
