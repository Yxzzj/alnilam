package pres.jeremy.alnilam.support;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pres.jeremy.alnilam.enums.ResponseCode;

@Getter
@Setter
@ToString
public class ResponseEntity<T>
{
    private int code;

    private String msg;

    private T data;

    public ResponseEntity(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseEntity(int code, String msg) {
        new ResponseEntity<T>(code, msg, null);
    }

    public static <T> ResponseEntity<T> success()
    {
        return result(ResponseCode.OPERATE_SUCCESS.code(), ResponseCode.OPERATE_SUCCESS.message(), null);
    }

    public static <T> ResponseEntity<T> success(T data)
    {
        return result(ResponseCode.OPERATE_SUCCESS.code(), ResponseCode.OPERATE_SUCCESS.message(), data);
    }

    public static <T> ResponseEntity<T> success(String msg, T data)
    {
        return result(ResponseCode.OPERATE_SUCCESS.code(), msg, data);
    }

    public static <T> ResponseEntity<T> fail()
    {
        return result(ResponseCode.OPERATE_FAILED.code(), ResponseCode.OPERATE_FAILED.message(), null);
    }

    public static <T> ResponseEntity<T> fail(String msg)
    {
        return result(ResponseCode.OPERATE_FAILED.code(), msg, null);
    }

    public static <T> ResponseEntity<T> fail(int code, String msg)
    {
        return result(code, msg, null);
    }

    public static <T> ResponseEntity<T> fail(String msg, T data)
    {
        return result(ResponseCode.OPERATE_FAILED.code(), msg, data);
    }

    public static <T> ResponseEntity<T> result(int code, String msg, T data)
    {
        return new ResponseEntity<>(code, msg, data);
    }

    public static <T> ResponseEntity<T> result(int code, String msg)
    {
        return new ResponseEntity<>(code, msg, null);
    }

    public static <T> ResponseEntity<T> result(ResponseCode responseCode, T data)
    {
        return result(responseCode.code(), responseCode.message(), data);
    }

    public static <T> ResponseEntity<T> result(ResponseCode responseCode)
    {
        return result(responseCode.code(), responseCode.message());
    }
}
