package com.ddh.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/19 21:08 <br>
 * @see com.ddh.mybatis <br>
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private long id;

    private String userName;

    private String passWord;
}
