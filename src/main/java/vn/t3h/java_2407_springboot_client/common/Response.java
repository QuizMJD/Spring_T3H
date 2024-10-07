package vn.t3h.java_2407_springboot_client.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    int code;
    String message;
    Object data;
}
