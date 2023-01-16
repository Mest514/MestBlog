package com.mest.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MestBlog
 * @description:
 * @author: Mest
 * @create: 2022-12-29 17:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkVo {
    private String address;
    private String description;
    private String logo;
    private String name;
    //审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)
    private String status;
    private Long id;
}
