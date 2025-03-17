package cn.itsource.springbootdemo.projects.exception;

public class JsonResult {
    private String code;
    private String message;
    private Object data;

    public JsonResult() {}

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult success() {
        return new JsonResult("200", "Success");
    }

    public static JsonResult success(Object data) {
        return new JsonResult("200", "Success", data);
    }

    public static JsonResult error(String message) {
        return new JsonResult("500", message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
