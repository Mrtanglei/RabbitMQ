package com.lei.tang.rabbitmq.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 7089265370957770629L;

    private Long id;

    private String name;
}
