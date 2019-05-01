package com.nonglianwang.buchong.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageQueryBean implements Serializable {
    private static final long serialVersionUID = 8536131589548538163L;
    private Integer currentPage;
    private Integer pageSize;
}
